package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRandomUsers {

	public static void main (String []args) throws Exception{
		 double latplus = 0.0069;
		 double lonplus = 0.0078;
		
		
		List<double[]>l = new ArrayList<double[]>();
		l = readData("TO_bbox/FakeFlickrUsers2.csv");
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(i+"-->"+l.get(i)[0]+"\t"+l.get(i)[1]);
		}
	}
	
	  public static double[] getListElem (List<double[]>list) {
		    Random generator = new Random();
	        int rnd = generator.nextInt(list.size());
	        return list.get(rnd);
	    }
	
	  public static String get (String[] array) {
		    Random generator = new Random();
	        int rnd = generator.nextInt(array.length);
	        return array[rnd];
	    }
	
	  public static long getLong (long[] array) {
		    Random generator = new Random();
	        int rnd = generator.nextInt(array.length);
	        
	        return array[rnd];
	    }
	  
	  
	  public static int getInt (int[] array) {
		    Random generator = new Random();
	        int rnd = generator.nextInt(array.length);
	        return array[rnd];
	    }
	  public static int getMat (int[][] array) {
		    Random generator = new Random();
	        int rnd = generator.nextInt(array.length);
	        int rnd2 = generator.nextInt(array.length);
	        return array[rnd][rnd2];
	    }
	  
      public static List<double[]> readData(String file) throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(new File(file))); 
	    String line = "";
		List<double[]> list = new ArrayList<double[]>();
	    
	    while((line = br.readLine())!= null ){
	    	
	    	String[] linea = line.split("\t");
	    	//System.out.println("*** "+line);
	    	double lat1 = Double.parseDouble(linea[3]);
	    	double lon1 = Double.parseDouble(linea[4]);
	    	
	    	lat1 = lat1 + 0.005;
	    	lon1 = lon1 + 0.005;
	    	System.out.println(lat1+", "+lon1);
	        list.add(new double[]{lat1, lon1});	   
	     }
	    
	    br.close();
	  
	    return list;
	}
 	
      
}
