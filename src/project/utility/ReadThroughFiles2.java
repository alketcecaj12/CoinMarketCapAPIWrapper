package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadThroughFiles2 {
	
	public static void main (String [] args)throws Exception{
		
		// String inflow = "C:\\Users\\Alket\\codeindigo\\FlickrAPI2\\DUBL_bbox";
		 String inflow = "C:\\Users\\Alket\\Desktop\\alldataflickr";
		 File Folder = new File(inflow);
		 File files[];
		 files = Folder.listFiles();
		 List<String>list = new ArrayList<String>();
		 List<Flickr>f = new ArrayList<Flickr>();
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
              String filefullname = files[i].getName();
              //String filetimestamp = filefullname.substring(filefullname.indexOf("_")+1,
           	//	   filefullname.indexOf("."));
              
              System.out.println("la parte che mi serve è : "+filefullname);
              //long ts = Long.parseLong(filetimestamp);
              
             
               while((line = br.readLine())!=null){
		      //System.out.println(line);
				  String [] riga = line.split("\t");
				  if(riga.length < 7  ) continue;
				  list.add(line);
				  String user = riga[0];
				  long ts = ConvertString2DataObj.convertDate2Tsp(riga[6]);
				  String date = riga[6];
				  f.add(new Flickr(user, ts,date ));
				  
               }
		          br.close();
		          

		  		Collections.sort(f);
		  		
		  		print(f, filefullname);
		  		f = new ArrayList<Flickr>();
           }
          }
		 }catch( Exception ex){
		    	ex.printStackTrace(); 
	  }
		System.out.println("** "+list.size());
		
	}

public static void print(List<Flickr>map , String file)throws Exception{
   	
   	PrintWriter out = new PrintWriter(new FileWriter(file));
   	for(int i = 0; i < map.size(); i++){
   		
				out.println(map.get(i).toString());
				
			
   	}
   	out.close();
   }

}
