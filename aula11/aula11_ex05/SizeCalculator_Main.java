package aula11_ex05;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SizeCalculator_Main {
	
	public static void main(String[] args) {
		
		if(args.length < 0){
            System.out.println("Error! Not enough arguments!");
            System.exit(1);
        }

        if(args.length >= 2){
            int k = 0;
            for(String arg : args){
                if(arg.startsWith("-") && arg.length() == 2){
                    k++;
                }else{
                    break;
                }
            }
            System.out.println("Analysing " + args[k].split("/")[args[k].split("/").length-1]);
            Visitor_SizeCalculator myVisitor = new Visitor_SizeCalculator();
            System.out.println("Total: "+ myVisitor.directorySize(args[k]) + "kB");
        }
    }
}