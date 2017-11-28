package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class NewCoordPlacmk {

	public static void main(String [] args) throws Exception{
		
		List<double[]>l = new ArrayList<double[]>();
		
		l = readData("TO_bbox/FakeFlickrUsers.csv");
		
		printNewPlc("newPls.kml", l);
		
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
	    	
	   
	    	System.out.println(lat1+", "+lon1);
	        list.add(new double[]{lat1, lon1});	   
	     }
	    
	    br.close();
	  
	    return list;
	}
 	
	public static void printNewPlc(String file, List<double[]>list) throws Exception{
		
		PrintWriter out = new PrintWriter(new FileWriter(new File(file)));
		 out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.println("<kml>");
			out.println("<Document>");
			
			out.println("<Style id=\"ffffffff\">");
			out.println("<IconStyle>");
			out.println("<scale>1.2</scale>");
			out.println("<Icon>");
			out.println("<href>http://maps.google.com/mapfiles/kml/shapes/shaded_dot.png</href>");
			out.println("</Icon>");
			out.println("</IconStyle>");
			out.println("<LabelStyle>");
			out.println("<color>ffffffff</color>");
			out.println("</LabelStyle>");
			out.println("<ListStyle>");
			out.println("</ListStyle>");
			out.println("</Style>");
	  
			  for (int i = 0; i < list.size(); i++) {
					out.println("<Placemark>");
					out.println("<styleUrl>#ffffffff</styleUrl>");
					out.println("<Point>");
					out.println("<gx:drawOrder>1</gx:drawOrder>");
			        out.print(" <coordinates>"+list.get(i)[1]+","+list.get(i)[0]+",0 </coordinates>");
			        out.println("</Point>");
					out.println("</Placemark>");
				}
		 
		         out.println("</Document>");
			     out.println("</kml>");
			     out.close();
		
	}
}
