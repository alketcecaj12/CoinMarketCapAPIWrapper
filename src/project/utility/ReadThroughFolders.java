package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ReadThroughFolders {

	

	

		public static void main (String[] args) throws Exception{

	      ReadThroughFolders rf = new ReadThroughFolders();
			//C:\\Users\\Alket\\Desktop\\DOC\\COUNTRIES
	      File MainDirectory = new File("E:\\DOC\\COUNTRIES");
		  rf.readDir(MainDirectory);
	     
		}
		
		
		private void readDir(File f) throws Exception{
			
		    Set<String>set = new TreeSet<String>();
			File []subdir = f.listFiles();
			int count = 0;
			for (File fi : subdir){
				
				if(fi.isFile()){
					//readFile(fi);
					BufferedReader br = new BufferedReader(new FileReader(fi));
					String line;
					while((line = br.readLine())!= null){
						set.add(line);					
					}
					br.close();
					count++;
					//System.out.println("leggo file ----------------");
					//System.out.println(fi.getName());
				}
				String dir = f.getName();
				//System.out.println("****** "+dir);
				dir = dir+".txt";
				if(subdir.length-(count) == 0){
					System.out.println("fine directory"+dir);
					count = 0;
					print(set, dir);
					set = new TreeSet<String>();
				}
				if(fi.isDirectory()){
					//System.out.println("entro nel if di controllo directory");
					readDir(fi);
					System.out.println("leggo la prossima directory");
					
					
				}
			}
		}
		
		public static void print(List<String>list, String file) throws Exception{
			PrintWriter out = new PrintWriter(new FileWriter(new File(file)));
			Set<String>set = new HashSet<String>(list);
			List<String> list2 = new ArrayList<String>();
			list2.addAll(set);
			System.out.println("stampo file --->>>>>>>>>>"+file);
			
			for (int i = 0; i < list2.size(); i++) {
				out.println(list2.get(i).toString());
			}
			out.close();
		}
		public static void print(Set<String>list, String file) throws Exception{
			PrintWriter out = new PrintWriter(new FileWriter(new File(file)));
			
			
			
			System.out.println("stampo file --->>>>>>>>>>"+file);
			for(String s: list){
				out.println(s);
			}
			out.close();
		}
	}

