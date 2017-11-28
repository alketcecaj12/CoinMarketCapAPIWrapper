package project.utility;

import java.io.FileWriter;
import java.io.PrintWriter;

public class MathFunctions {

	public static void main (String[] args)throws Exception{
		
		double d = Math.random()*0.0005;
		
		double lat = 45.069285;
		double lon = 7.687491;
		
		double lat1 = lat+d;
		double lon1 = lon;
		System.out.println(d);
		System.out.println(lat+", "+lon);
		printKml("testRandomPlacemark.kml", lat, lon, lat1, lon1);
		
	
	}
	public static void printKml(String file, double lat1, double lon1, double lat2, double lon2)throws Exception{
		
		PrintWriter out = new PrintWriter(new FileWriter(file));
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<kml xmlns=\"http://earth.google.com/kml/2.2\">");
		out.println("<Document>");
		
		out.println("<Placemark>");
		out.println("<name>primo placemark</name>");
		out.println("<description>");
		
		out.println("</description>");
		out.println("<Point>");
		out.println("<coordinates>"+lon1+","+lat1+",0</coordinates>");
		out.println("</Point>");
		out.println("</Placemark>");
		
		
		out.println("<Placemark>");
		out.println("<name>primo placemark</name>");
		out.println("<description>");
		
		out.println("</description>");
		out.println("<Point>");
		out.println("<coordinates>"+lon2+","+lat2+",0</coordinates>");
		out.println("</Point>");
		out.println("</Placemark>");
		
		out.println("</Document>");
		out.println("</kml>");
		
		out.close();
	}
}
