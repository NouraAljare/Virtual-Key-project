
package LockedMe.com;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {


    public static void main(String[] args) throws IOException {
       System.out.println("##########################################################\n\t\tWelcome to LockedMe.com System\n\t\tDeveloper Details: Noura Aljare");
       System.out.println();
       int ch = 0;
       Scanner scan = new Scanner(System.in);
       while(ch != -1){
           System.out.println("Please choose your option:");
           System.out.println("1. Retrieve files name in ascending order");
           System.out.println("2. Business-level operations");
           System.out.println("3. Close application");
           ch = scan.nextInt();
           switch(ch){
               case 1:{
                   System.out.println("Enter the path you want to retreve the files names inside it:");
                   String path = scan.next();
                   File folder = new File(path);
                   File[] listOfFiles = folder.listFiles();
                   ArrayList<String> names = new ArrayList<>();
                   for(int i=0;i<listOfFiles.length;i++){
                       if(listOfFiles[i].isFile()){
                           names.add(listOfFiles[i].getName());
                       }
                   }
                   
                   Arrays.sort(names.toArray());
                   System.out.println("Files in "+ path);
                   for(String s:names){
                       System.out.println(s);
                   }
                   System.out.println("End of files in " + path);
                   System.out.println("-----------------------------------------------------");
                   break;
                   
               }
               case 2:{
                   System.out.println("\t1- Add file to existing directory");
                   System.out.println("\t2- Delete a file from existing directory");
                   System.out.println("\t3- Search a file");
                   System.out.println("\t4- Back to main options");
                   int in2 = scan.nextInt();
                   switch(in2){
                       case 1:{
                           System.out.println("\tPlease enter the name of new file with path:\n");
                           String newFile = scan.next();
                           File newFileObj = new File(newFile);
                           newFileObj.createNewFile();
                           System.out.println("\t*** The file "+newFile + " was created.\n");
                           break;
                       }
                       case 2:{
                            System.out.println("\tPlease enter the name of  file to delete with path:\n");
                           String dFile = scan.next();
                           File dFileObj = new File(dFile);
                           dFileObj.delete();
                           System.out.println("\t*** The file "+dFile + " was deleted.\n");
                           break;
                       }
                       case 3:{
                           System.out.println("\tPlease enter the name of  file to search with path:\n");
                           String sFile = scan.next();
                           File sFileObj = new File(sFile);
                           if(sFileObj.exists()){
                               System.out.println("\t*** The file "+sFile + " was found.");
                               System.out.println("\t *** successful operation *** \n");
                           }
                           else{
                               System.out.println("\t*** The file "+sFile + " was not found.");
                               System.out.println("\t *** unsuccessful operation *** \n");  
                           }
                           
                           break;
                       }
                       case 4:{
                           System.out.println("\t--------------------------------------------------------------");
                           break;
                       }
                   }
                   break;
               }
               case 3:{
                   System.out.println("Closing application...\n");
                   System.exit(0);
               }
           }
       }
    }
    
}
