package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelecomDataAnalysis {

	public static void main (String[] args) throws Exception{
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		
		
		/*
		String file = "C:\\Users\\Alket\\codeindigo\\FlickrAPI\\R_graphic_data\\totaldb_data.csv";
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer>list2 = new ArrayList<Integer>();
		loadList(list2, file);
		Collections.sort(list2);
		printList(list2,"SortedTotalDb.csv");
		*/
		
		//map = freqVal(list2, file);
		//printValues("All_callnrusersnr.csv",map);
		//for (int i : map.keySet()) {
			//System.out.println(i+" ---> "+map.get(i));
		//}
		//provaDel9("All_callnrusersnr.csv");
		//printHashMap(map, "PLSandFreqPerUser.csv");
	}
	
	public static int countFT_Events(){
		
		int counter = 0; 
		  return counter;
		
	}
    public static void printList(List<Integer>list, String file)throws Exception{
		
		PrintWriter out = new PrintWriter(new FileWriter(file));
		
		for (int i = 0; i < list.size(); i++) {
		   out.println(list.get(i));
		}
		out.close();
	}
	
	public static void loadList (List<Integer>list, String file) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File(file)));
		int sum = 0; 
        String line;
		while((line = br.readLine())!= null){
		int k = Integer.parseInt(line);
		System.out.println(k);
		list.add(k);
		}
		br.close();
	}
	public static void printHashMap(Map<Integer, Integer> map, String file)throws Exception{
		
		PrintWriter out = new PrintWriter(new FileWriter(file));
		
		for (int i : map.keySet()) {
		   out.println(i+" ---> "+map.get(i));
		}
		out.close();
	}
	
	public static Map<Integer, Integer> freqVal(List<Integer> list, String file) throws Exception{
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int counter = 0; 
		String line;
		BufferedReader br = new BufferedReader(new FileReader(new File(file)));
		int sum = 0; 

		while((line = br.readLine())!= null){
		int k = Integer.parseInt(line);
		System.out.println(k);
		list.add(k);
		}
		br.close();
		Collections.sort(list);
		for(int i = 1; i < list.size(); i++){
		
			int j = list.get(i-1);
			if(j == list.get(i)){
				counter++;
			}
			else{
				map.put(list.get(i-1), counter+1);
				counter = 0; 
			}
		}
		return map;
		
	}
	public static void printNum(List<Integer>list, String infile, String outfile) throws Exception{
		String line = "";
		
		BufferedReader br = new BufferedReader(new FileReader(new File(infile)));
		int sum = 0; 
		while((line = br.readLine())!= null){
			
			String [] linea = line.split(",");
			int id = Integer.parseInt(linea[0]);
			String usr = linea[1];
			int imsi = Integer.parseInt(linea[2]);
			int counter = Integer.parseInt(linea[3]);
			list.add(counter);
		
			sum += counter;
		
			
		}br.close();
		System.out.println("************************"+sum);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i));
		
		}
		PrintWriter out = new PrintWriter(new FileWriter(new File(outfile)));
		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i));
		}
		out.close();
	}
	
	public static void printValues(String file, Map<Integer, Integer>map) throws Exception{
		
		PrintWriter out = new PrintWriter(new FileWriter(new File(file)));
		out.println();
		for(int i : map.keySet()){
		
			out.print(map.get(i));
			out.println(","+i);
		}
		out.close();
		
	}
	public static void provaDel9 (String infile) throws Exception{
		
       String line = "";
		
		BufferedReader br = new BufferedReader(new FileReader(new File(infile)));
		int sum = 0; 
		int sumCounter = 0;
		//int counter = 0; 
		while((line = br.readLine())!= null){
			
			String [] linea = line.split(",");
			int id = Integer.parseInt(linea[0]);
			int counter = Integer.parseInt(linea[1]);
		
			sum += id;
		    sumCounter +=id*counter;
			
		}br.close();
		System.out.println("*************************"+sum+", "+sumCounter);
	}
}
