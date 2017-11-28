
package project.utility;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import torinoflickrdata.db.FlickrUser;
//import torinoflickrdata.db.PLSUser;

public class ReadThroughFiles {

	public static void main (String [] args)throws Exception{
			
			 String inflow = "C:\\Users\\Alket\\codeindigo\\FlickrAPI2\\DUBL_bbox";
			 String inflow2 = "C:\\Users\\Alket\\codeindigo\\FlickrAPI\\PLS-IMSIstranieri\\TotalIMSIFiles\\TotalIMSIFiles6.txt";
			 File Folder = new File(inflow);
			 File files[];
			 files = Folder.listFiles();
			 List<String>list = new ArrayList<String>();
			 //loadData(inflow2,list);
			 Set<String>set = new HashSet<String>(list);
			 List<String>list2 = new ArrayList<String>(set);
			// print( list2,"TotalIMSIFile6.txt");
			
			try{
		        String line = "";

	            if(files.length>1)
	            {
	             for(int i = 0;i<files.length; i++){
	               
	               BufferedReader br = new BufferedReader(new FileReader(files[i]));
	               System.out.print("reading...");
	               System.out.println(files[i].getName()+", number: "+i);
	               //String filefullname = files[i].getName();
	               //String filetimestamp = filefullname.substring(filefullname.indexOf("_")+1,
	            	//	   filefullname.indexOf("."));
	               
	               //System.out.println("la parte che mi serve è : "+filetimestamp);
	               //long ts = Long.parseLong(filetimestamp);
	               
	              
	                while((line = br.readLine())!=null){
			      
					  //String [] riga = line.split("\t");
					  list.add(line);
					  
					  }
			          br.close();
	            }
	           }
			 }catch( Exception ex){
			    	ex.printStackTrace(); 
		  }
			System.out.println("** "+list.size());
			
			set = new HashSet<String>(list);
			System.out.println(set.size());
			//printList(list, "TotalIMSIFiles6.txt");
		}
	
	 public static void print(List<String>map , String file)throws Exception{
	    	
	    	PrintWriter out = new PrintWriter(new FileWriter(file));
	    	for(int i = 0; i < map.size(); i++){
	    		
					out.println(map.get(i));
					
				
	    	}
	    	out.close();
	    }
	 
		/*
	public static List<PLSUser> findPLSUser(FlickrUser f){
		List<PLSUser> plsuser = new ArrayList<PLSUser>();

		 String inflow = "C:/DATA/data/PLS";
		 File Folder = new File(inflow);
		 File files[];
		 files = Folder.listFiles();
		
		try{
	        String line = "";

           if(files.length>1)
           {
            for(int i = 0;i<files.length; i++){
             
               System.out.print("reading...");
               System.out.println(files[i].getName()+", number: "+i);
              String filefullname = files[i].getName();
              String [] filename = filefullname.split("_");
              System.out.println("la parte che mi serve è : "+filename[1]);
              long ts = Long.parseLong(filename[1]);
              long c = -600000L;
              long ftsp = f.getFUTimestamp(f);
              if(ftsp < ts){
            	  
               BufferedReader br = new BufferedReader(new FileReader(files[i]));
              
               while((line = br.readLine())!=null){
		      
				  String [] riga = line.split("\t");
				  
				  String username = riga[0];
				  int imsi = Integer.parseInt(riga[1]);
				  int celllac = Integer.parseInt(riga[2]);
				  long time = Long.parseLong(riga[3]);
				  if(time == ts){
					  plsuser.add(new PLSUser(username, imsi, celllac,time));
				  }
				  
				  }
		          br.close();
              }
             }
           }
		 }catch( Exception ex){
		    	ex.printStackTrace(); 
	  }
		return plsuser;
	}
	
	*/
	public static void loadData(String file, List<String>list) throws Exception{
		 BufferedReader br = new BufferedReader(new FileReader(file));
		 String line;
		 
		      while((line = br.readLine())!=null){
		      
			      list.add(line);
			  
			  }
	          br.close();
	}
	public static void printList(List<String>map, String outfile) throws Exception{
		
		PrintWriter out = new PrintWriter(new FileWriter(outfile));
			for(int i =0; i < map.size(); i++){
				out.println(map.get(i).toString());
				/*
				out.print(map.get(i).p_pls+",");
				out.print(map.get(s).get(i).imsi+",");
				out.print(map.get(s).get(i).cellac+",");
				out.print(map.get(s).get(i).ts+",");
				out.print(map.get(s).get(i).lat+",");
				out.print(map.get(s).get(i).lon+",");
				out.println(map.get(s).get(i).radius+",");
				*/
			
			
		}
		out.close();
	}
	}
	
	
