package project.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import twitterdata.TwitterUserMethods;

public class MoveFiles {
 
	    public static void main(String[] args) throws Exception{
	    	
	    	List<Long> list = new ArrayList<Long>();
	    	
	    	//twitterdata.TwitterUserMethods.loadList(list, "C:\\Users\\Alket\\codeindigo\\FlickrAPI\\FileLavoroAttuale\\TotaleTS4AllUsers.txt");
	    	for (int i = 0; i < list.size(); i++) {
				//System.out.println(list.get(i));
			}
	    	String inflow = "C:/DATA/data/mese/DatiTotali";
			 File Folder = new File(inflow);
			 File files[];
			 files = Folder.listFiles();
	    	
	    	try{
                for(int i = 0; i < list.size(); i++){
                 long file_i = list.get(i);
                 System.out.println("========================================================================"+file_i);
            	   String ts = Long.toString(file_i);
            	   System.out.println("************************************************************************"+ts);
            	   
	               for (int j = 0; j < files.length; j++) {
				    
	            	   String filename = files[j].getName();	
				       System.out.println(filename);
				       String filename_use = filename.substring(filename.indexOf("_")+1, filename.indexOf("."));
				       System.out.println("****"+filename_use);
				       
				       if(filename_use.equals(ts)){
				    	   
				       System.out.println("########################################################################si");
	    	            File afile =new File(files[j].getAbsolutePath());
	 
	    	             if(afile.renameTo(new File("C:\\DATA\\data\\mese\\DatiCorrispondenti" + afile.getName()))){
	    		           System.out.println("File is moved successful!");
	    	        
	    	             }
	    	             else{
	    		            System.out.println("File is failed to move!");
	    	             }
				       }
                   }
                }     
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	}
	
	

