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

public class Flickr2stats {
	

		
	
	
		public static void main (String [] args)throws Exception{
			String file0 = "F:\\FDATAMORE";
			String file = "C:\\Users\\Alket\\Desktop\\DOC\\alldataflickr2";
			
			String file2 = "C:\\Users\\Alket\\junocode\\DataTel\\Instadata3";
			//C:\\Users\\Alket\\Desktop\\DOC\\Countriesfiles //C:\\Users\\Alket\\Desktop\\DOC\\countriesnodesc
			Set<String>newuser_set = new HashSet<String>();
			Set<String>finaluser_set = new HashSet<String>();
			//load(newuser_set,"C:\\Users\\Alket\\junocode\\DataTel\\NewUsersMore.txt" );
			System.out.println(newuser_set.size());
			File f = new File(file2);
			File []folder = f.listFiles();
			Set<String>set = new HashSet<String>();
			Set<String>setevents = new HashSet<String>();
			Set<String>setevents2 = new HashSet<String>();
			int conta = 0;
			
			for(int i = 0; i < folder.length; i++){
				
				//if(folder[i].getName().equals("SFRAN_bbox.txt")){
				
				BufferedReader br = new BufferedReader(new FileReader(folder[i]));

				String line;
				while((line = br.readLine())!= null){
					conta++;
					String [] l = line.split("\t");
				    set.add(l[0]);
				   setevents.add(line);
				    
				  //  if(setevents.size()> 20000000) setevents2.add(line);
//					if(newuser_set.contains(l[0])){
//						 finaluser_set.add(l[0]);
//					}
////					
				    
				}br.close();
				
			  }
		
			 
			
			
			//} 

		
			
			System.out.println("record : "+conta);
			System.out.println("utenti : "+set.size());
			System.out.println("eventi : "+setevents.size()+", "+setevents2.size()
					);
	
			System.out.println("Utenti nuovi = "+(newuser_set.size()- finaluser_set.size()));
			//print(setevents, "AllFlickrUsers.csv");
		}

		
		public static void print(Set<String>list, String file) throws Exception{
			PrintWriter out = new PrintWriter(new FileWriter(new File(file)));
			
			List<String>l = new ArrayList<String>(list);
			Collections.sort(l);
			
			
			
			
			
			
			for (int i = 0; i < l.size(); i++) {
				out.println(l.get(i).toString());
			}
			out.close();
		}
		public static void load(Set<String>list, String file) throws Exception{
			
			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			
			String line; 
			while((line = br.readLine())!= null){
				list.add(line);
			}br.close();
			
		}


}
