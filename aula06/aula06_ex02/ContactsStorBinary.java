package lab0602;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ContactsStorBinary  extends ContactsStorImp implements ContactsStorageInterface{
	
	private File binFile;
	
	public ContactsStorBinary(File f) {
		super(f);
		this.binFile=f;
	}
	
	public List<Contact> loadContacts(){
        try{
            List<Contact> contacts = new ArrayList<>();
            
            FileReader fileReader = new FileReader(binFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {

                String cLine[] = line.split(" - ");
                for(int i = 0 ; i < cLine.length ; i++){
                    contacts.add(new Contact (cLine[i],Integer.parseInt(cLine[++i])));
                }        
            }

            bufferedReader.close();
            fileReader.close();

            return contacts;
        }catch(Exception e){
            System.out.println("ERROR! "+e.toString());
        }

        return null;
	}
        
	public boolean saveContacts(List<Contact> list){    
        try{
            FileWriter fileWriter = new FileWriter(binFile.getName());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            //Write contacts from list
            for(Contact currentContact : list){
               bufferedWriter.write(currentContact.toString());
               bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

            return true;
        }catch(Exception e){
            return false;
        }
    }
}
