package lab0602;

import java.io.*;
import java.util.*;


public class ContactsStorTxt extends ContactsStorImp implements ContactsStorageInterface{
	private File textFile;
	
	public ContactsStorTxt(File file) {
		super(file);
		this.textFile=file;
	}
	
	 public List<Contact> loadContacts(){
		try {
			List<Contact> contacts = new ArrayList<>();
			Scanner fileScanner = new Scanner(textFile);	   
			
			while (fileScanner.hasNext()) {
			    String line = fileScanner.nextLine();
			    String cont[] = line.split("\\s+"); 
			
			    for (int i=0; i<cont.length; i++) {
			    	contacts.add(new Contact(cont[i], Integer.parseInt(cont[++i])));
			    }
			}
			
			fileScanner.close();
		
		return contacts;
		}
		catch(Exception e){
            System.out.println("ERROR! "+e.toString());
        }

        return null;
	}
	 
	 public boolean saveContacts(List<Contact> list){   
		 try{
			 FileWriter writer = new FileWriter(this.textFile.getName());
			 BufferedWriter bw = new BufferedWriter(writer);

			 for(Contact currentContact : list){
		        bw.write(currentContact.toString());
		        bw.newLine();
			 }
		
			 bw.close();
			 writer.close();
		
			 return true;
		 } catch(Exception e){
			 return false;
		 	}
	}	
}	
