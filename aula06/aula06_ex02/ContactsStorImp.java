package lab0602;

import java.io.File;
import java.util.List;

public class ContactsStorImp implements ContactsStorageInterface{

	private File file;

	public ContactsStorImp(File f) {
		try{
			this.file=f;
		}
		catch (Exception e){
			System.exit(1);
			System.err.println(e.toString());
		}
	}
	
	public String fileType() {
		String[] fname = file.getName().split("\\."); 
		String typeOfFile;
		if(fname.length>1) { 
			return typeOfFile="Txt"; 
		}else { 
			return typeOfFile="Binary"; 
		}
	}
	
	@Override
	public List<Contact> loadContacts() {
		String ext = fileType(); // tipo do ficheiro

        try{
            String storageType = "ContactsStor"+ext;
            ContactsStorageInterface specificStorage = (ContactsStorageInterface)Class.forName("lab0602."+storageType).getConstructor(File.class).newInstance(file);
            return specificStorage.loadContacts();

        }catch(Exception e){
            System.out.println("ERRO LC! " + e.toString());
            System.exit(1);
        }
		return null;
	}

	@Override
	public boolean saveContacts(List<Contact> list) {
		String ext = fileType();

        try{
        	String storageType = "ContactsStor"+ext;
            ContactsStorageInterface specificStorage = (ContactsStorageInterface) Class.forName("lab0602."+storageType).getConstructor(File.class).newInstance(file);
            return specificStorage.saveContacts(list);

        }catch(Exception e){
            System.out.println("ERRO SC! " + e.toString());
            System.exit(1);
        }

        
        return true;
	}

}
