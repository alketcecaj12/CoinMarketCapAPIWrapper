package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppendContent2File {


		
	    public static void main( String[] args ){	
	    
	    	
	    	appendContent("TwitterData3");
	    }
	
	
    public static void appendContent(String folder){
	
    	 File Folder = new File(folder);
		 File files[];
		 files = Folder.listFiles();
//		 String filefullname = files[0].getName();
		 File file2 =new File("TwitterDatiFinali.csv");
		System.out.println("creo file"+file2.getName());
		 try{
	      
           if(files.length>1)
            {
             for(int i = 0;i<files.length; i++){
            
             System.out.print("reading...");
             System.out.println(files[i].getName()+", number: "+i);
            
             try{
	
	    		//if file doesnt exists, then create it
	    		if(!file2.exists()){
	    			file2.createNewFile();
	    		}
	 
	    		//true = append file
	    		 BufferedReader br = new BufferedReader(new FileReader(files[i]));
	    		  
		    		FileWriter fileWritter = new FileWriter(file2.getName(),true);
		    	    PrintWriter out = new PrintWriter(fileWritter);    
		    		//BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	    		 String linea = "";
	    		 
	    		 while((linea = br.readLine())!=null){
				      
					  
				
	    	        out.println(linea);
	    	      
	 
		        System.out.println("Done");

				  }
		          br.close();
		          out.close();
	 
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
          
           }
         }
		}catch(Exception e){
        	 e.getMessage();
        	 }
         }
          
}
	

