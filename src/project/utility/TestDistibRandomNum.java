package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestDistibRandomNum {

	public static void main (String[] args) throws Exception{
		
        double[] dati = new double[]{1,1,1,2,4,4};
        double[] h = new double[24];     // creo un intervallo di numeri da 0 a 24
        for(int i=0; i<dati.length;i++){  
               h[(int)dati[i]]++;   // il casting perchè è un indice!
               
        System.out.println("*************"+h[(int)dati[i]]);
        }
        
        for (int i = 0; i < h.length; i++) {
		 System.out.println("h("+i+") --> "+h[i]);	
		}
        
        double sum = 0;
        
        for(int i=0; i<h.length;i++)
               sum+=h[i];
       
        for(int i=0; i<h.length;i++)
               h[i] = h[i] / sum;
       
        for(int i=0; i<h.length;i++)
               System.out.println("p(h"+i+") = "+h[i]);
       
        // h è la distribuzione di probabilità che approssima i dati
       
        // calcolo la probabilità cumulativa
       
        double[] cum = new double[24];
        cum[0] = h[0];
        for(int i=1; i<cum.length;i++)
               cum[i] = cum[i-1]+h[i];
       
        System.out.println();
       
        for(int i=0; i<cum.length;i++)
               System.out.println("cum(h"+i+") = "+cum[i]);
       
        double[] hs = new double[24];
       
        for(int i=0; i<hs.length;i++) {
               double x = Math.random();
               for(int j=0; j<cum.length;j++) {
                      if(x < cum[j]) {
                             hs[i] = j;
                             break;
                      }
               }
        }
        for(int i=0; i<hs.length;i++)
               System.err.println(hs[i]); 
        
        //-----------------------------------------------------------------------
        //-----------------------------------------------------------------------
        
        double[] lat = new double[180];
        lat = readData("FlickrUsersTsAndCoord.csv");
        
        double [] lat50 = new double[50];
        lat50 = findDistrib(lat);
        for (int i = 0; i < lat50.length; i++) {
			System.err.println(i+ "-->> "+lat50[i]);
		}
        
	}
	
	public static double [] readData(String file) throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(new File(file))); 
	    String line = "";
		double[] lat = new double[118];
	    int i = 0;
	    while((line = br.readLine())!= null ){
	    	
	    	String[] linea = line.split(",");
	    	double lat1 = Double.parseDouble(linea[1]);
	    	System.out.println("** "+lat1);
	    	lat[i] = lat1;
	       i++;
	     }br.close();
	  return lat;
	}
	
	
	public static double[] findDistrib( double[] dati ){
		
		//double[] dati = new double[]{1,1,1,2,4,4};
        double[] h = new double[250];     // creo un intervallo di numeri da 0 a 24
        for(int i=0; i<dati.length;i++){  
               h[(int)dati[i]]++;   // il casting perchè è un indice!
               
        System.out.println("*************"+h[(int)dati[i]]);
        }
        
        for (int i = 0; i < h.length; i++) {
		 System.out.println("h("+i+") --> "+h[i]);	
		}
        
        double sum = 0;
        
        for(int i=0; i<h.length;i++)
               sum+=h[i];
       
        for(int i=0; i<h.length;i++)
               h[i] = h[i] / sum;
       
        for(int i=0; i<h.length;i++)
               System.out.println("p(h"+i+") = "+h[i]);
      
       
        double[] cum = new double[250];
        cum[0] = h[0];
        for(int i=1; i<cum.length;i++)
               cum[i] = cum[i-1]+h[i];
       
        System.out.println();
       
        for(int i=0; i<cum.length;i++)
               System.out.println("cum(h"+i+") = "+cum[i]);
       
        double[] hs = new double[50];
       
        for(int i=0; i<hs.length;i++) {
               double x = Math.random();
               for(int j=0; j<cum.length;j++) {
                      if(x < cum[j]) {
                             hs[i] = j;
                             break;
                      }
               }
        }
        for(int i=0; i<hs.length;i++)
               System.err.println(hs[i]);
       
		return hs;
	}
	
    /*
	public static double [] readDataTs(String file) throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(new File(file))); 
	    String line = "";
		long[] tsp = new long[118];
	    int i = 0;
	    while((line = br.readLine())!= null ){
	    	
	    	String[] linea = line.split(",");
	    	System.out.println(linea[3]);
	    	long lat1 = Long.parseLong(linea[3]);
	    	tsp[i] = lat1;
	       i++;
	     }br.close();
	     double[] d = new double[tsp.length];
	     for (int j = 0; j < d.length; j++) {
			d[i]= (double)tsp[i];
		}
	  return d;
	}
	
	
	public static long[] findDistribTs( double[] dati ){
		
		//double[] dati = new double[]{1,1,1,2,4,4};
		
        double[] h = new double[200];     // creo un intervallo di numeri da 0 a 24
        for(int i=0; i<dati.length;i++){ 
        	System.out.println(dati[i]);
               h[(int)dati[i]]++;   // il casting perchè è un indice!
               
       // System.out.println("*************"+h[(int)dati[i]]);
        }
        
        for (int i = 0; i < h.length; i++) {
		 System.out.println("h("+i+") --> "+h[i]);	
		}
        
        long sum = 0;
        
        for(int i=0; i<h.length;i++)
               sum+=h[i];
       
        for(int i=0; i<h.length;i++)
               h[i] = h[i] / sum;
       
        for(int i=0; i<h.length;i++)
               System.out.println("p(h"+i+") = "+h[i]);
      
        double[] cum = new double[118];
        cum[0] = h[0];
        for(int i=1; i<cum.length;i++)
               cum[i] = cum[i-1]+h[i];
       
        System.out.println();
       
        for(int i=0; i<cum.length;i++)
               System.out.println("cum(h"+i+") = "+cum[i]);
       
        long[] hs = new long[50];
       
        for(int i=0; i<hs.length;i++) {
               double x = Math.random();
               for(int j=0; j<cum.length;j++) {
                      if(x < cum[j]) {
                             hs[i] = j;
                             break;
                      }
               }
        }
        for(int i=0; i<hs.length;i++)
               System.err.println(hs[i]);
       
		return hs;
	}
	
	*/
	
	
	
	
	
	
	public static void printFinalFile(String file, String file2, long[] timest) throws Exception{
     String line; 
    PrintWriter out = new PrintWriter(new FileWriter(new File(file2)));
    long[] final_ts = new long[50];
	for(int j = 0; j<timest.length;j++){  
        final_ts[(int)timest[j]]++;   // il casting perchè è un indice!
        
    System.out.println("*************"+final_ts[(int)timest[j]]);
    
    BufferedReader br = new BufferedReader(new FileReader(new File(file))); 
    while((line = br.readLine())!= null ){
    	
    	String[] linea = line.split(",");
    	String username = linea[0];
        out.print(username);	
     }
    	
    	
    }
		
		
	}
}
	

