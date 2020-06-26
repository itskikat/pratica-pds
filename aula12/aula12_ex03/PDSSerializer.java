package aula12_ex03;

import java.lang.reflect.*;
import java.util.Arrays;

public class PDSSerializer {

	public static String fromObject(Object o) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> c1 = o.getClass();
		
		/* Method[] methods = c1.getMethods();
		System.out.println("METHODS");
		for (Method m: methods) {
			System.out.println(m);
		} */
		
		/* System.out.println("FIELDS");
		Field[] fields = c1.getDeclaredFields();
		for (Field f: fields) {
			System.out.println(f);
		} */
		
		Field name = c1.getDeclaredField("name");
		// dado que sao private, teremos que colocar acessiveis senao aceder ao valor sera impossivel
		name.setAccessible(true);
		String fieldName = (String)name.get(o);
		
		Field price = c1.getDeclaredField("size");
		price.setAccessible(true);
		Integer fieldPrice = (Integer)price.get(o);
		
		Field owner = c1.getDeclaredField("owner");
		owner.setAccessible(true);
		Owner fieldOwner = (Owner) owner.get(o);
		
		Field passageiros = c1.getDeclaredField("passageiros");
		passageiros.setAccessible(true);
		String[] fieldPassageiros = (String[])passageiros.get(o);
		
		System.out.println("Name: " + fieldName);
		System.out.println("Price: " + fieldPrice);
		System.out.println("Owner: " + fieldOwner);
		System.out.println("Passageiros: " + Arrays.toString(fieldPassageiros));
		
		return "";
	}
	
	
	
}
