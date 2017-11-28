package project.utility;

import java.util.ArrayList;
import java.util.List;

import org.gps.utils.LatLonPoint;
import org.gps.utils.LatLonUtils;



public class CalculateDistance{ 
	
	public static List<double[]> generateGrid(double lat1, double lon1){
		
		List<double[]> grid = new ArrayList<double[]>();
		
		double c1 = 0.0062;
		double c2 = 0.005;
		double d1 = 0;
		double d2 = 0;
		double temp = lat1;
		
		grid.add(new double[]{lat1, lon1});
	
		for (int i = 0; i < 100; i++) {
			lat1 = temp;
			
			for (int j = 0; j < 100; j++) {
				
				 lat1 =  lat1+c1;
				 
				grid.add(new double[]{lat1, lon1});
			
			}
			lon1 =lon1 +0.0037;
		}
		
		return grid;
		
	}
	
	
	
	
   public static void main (String [] args) throws Exception{
	
	
	
	// v1----v2
	// |     |
	// v3----v4
	
	// v2 = 7.718415221776384,45.0932731788881,0
	// v3 = 7.617133588098584,45.03864590872755,0
     // v = 7.619605572200618,45.03865580794373
	// vtest = 7.718570088979466,45.09089701574843
	// punto inizio = 7.621843859547626,44.98377591209071,0

	
	double lati = 44.903056;             ;	
	double longi = 8.213611;		
	
	double lati1 =  44.903611;
	double longi1 = 8.199444;
	
	
	LatLonPoint gp1 = new LatLonPoint(lati, longi);
	
	LatLonPoint gp2 = new LatLonPoint(lati1, longi1);
	
    double d = LatLonUtils.getHaversineDistance(gp1, gp2);	
	System.out.println( d);

           }
     public static double distanceCalculator(LatLonPoint gp1,LatLonPoint gp2 ){
    	 double d = LatLonUtils.getHaversineDistance(gp1, gp2);	
    		//System.out.println( d);
    		return d;
     }
	} 

