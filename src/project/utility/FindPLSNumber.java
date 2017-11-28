package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FindPLSNumber {

	public static void main (String[] args){
		
		String inflow = "C:\\Users\\Alket\\codeindigo\\FlickrAPI\\AllData";
		 File Folder = new File(inflow);
		 File files[];
		 files = Folder.listFiles();
		 List<PLSUser>list = new ArrayList<PLSUser>();
		 List<String>slist = new ArrayList<String>();
		int k = 0;
		 try{
	        String line = "";

           if(files.length>1)
           {
            for(int i = 0;i<files.length; i++){
              
              BufferedReader br = new BufferedReader(new FileReader(files[i]));
              System.out.print("reading..."+i);
             
             
               while((line = br.readLine())!=null){
		      
				  String [] riga = line.split("\t");
				  String username = riga[0];
				  
				  
				  if(!(slist.contains(username))){
					  slist.add(username);
					  //System.out.println(username+" added");  
				  }
				  }
		          br.close();
		          k = slist.size();
		          System.out.println("size of slist after "+i+" iterations is "+k);
             }
           }
		 }catch( Exception ex){
		    	ex.printStackTrace(); 
	  }
		
	}
}
