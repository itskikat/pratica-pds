package lab0602;

import java.io.File;

public class Ex62 {

	public static void main(String[] args) {
		ContactsImp addressManager = new ContactsImp();

        File thisFile = new File("ex62.txt");
        ContactsStorageInterface storage = new ContactsStorImp(thisFile);
        addressManager.openAndLoad(storage);

        System.out.println(addressManager.getByName("Ines"));

        addressManager.add(new Contact("Sara",200));
        System.out.println(addressManager.getByName("Sara"));

        addressManager.remove(addressManager.getByName("Rita"));
        System.out.println(addressManager.exist(new Contact("Rita",7)));

        thisFile = new File("lab0602Binary.bin");
        storage = new ContactsStorImp(thisFile);
        addressManager.saveAndClose(storage);

        addressManager.openAndLoad(storage);
    }
}
