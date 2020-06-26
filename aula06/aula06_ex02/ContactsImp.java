package lab0602;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsImp implements ContactsInterface{
	private List<Contact> contacts;
	
	public ContactsImp() {
		this.contacts = new ArrayList<>();
	}
	
	@Override
	public void openAndLoad(ContactsStorageInterface store) {
		contacts.addAll(store.loadContacts());
		
	}

	@Override
	public void saveAndClose() {
		if(contacts.size()<1){
            System.out.println("Contacts list was never initialized!");
            return;
        }
		
		
		Scanner input = new Scanner(System.in);
        System.out.println("Filename:");
        String fname = input.nextLine();
        input.close();
        
        try{
        	File file = new File(fname);
        	ContactsStorageInterface contStorage = new ContactsStorImp(file);
        	boolean flag = contStorage.saveContacts(this.contacts);
          
        	if(flag) {
        		System.out.println("save and closed worked");
        	}else {
        		System.out.println("save and closed didnt work");
        	}
           
        }catch(Exception e){
            	System.exit(1);
        }
		
	}

	@Override
	public void saveAndClose(ContactsStorageInterface store) {
		if(contacts.size()<1){
            System.out.println("Contacts list was never initialized!");
            return;
        }

		boolean flag = store.saveContacts(this.contacts);
		if(flag) {
			System.out.println("save and closed worked");
		}else {
			System.out.println("save and closed didnt work");
		}
		
	}

	@Override
	public boolean exist(Contact contact) {
		for(Contact c : contacts) {
			if(c.getName().equals(contact.getName()) && c.getNumber()==contact.getNumber()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Contact getByName(String name) {
		for(Contact c : contacts){
            if(c.getName().equals(name)){
                return c;
            }
        }

        System.out.println("Contact not found!");
        return null;
	}

	@Override
	public boolean add(Contact contact) {
		if(this.exist(contact)) {
			return false;
		}else {
			contacts.add(contact);
			return true;
		}
	}

	@Override
	public boolean remove(Contact contact) {
		if(contact != null && this.exist(contact)) {
			contacts.remove(contact);
			return true;
		}else {
			System.out.println("Contact doesn't exist");
			return false;
		}
	}

}
