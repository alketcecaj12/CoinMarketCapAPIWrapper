package project.utility;

import java.util.Arrays;
import java.util.List;
 
public class ConvertArray2List {

	  public static void main(String[] argv) {
	 
		  String sArray[] = new String []{"Array 1", "Array 2", "Array 3"};
	      Integer[] i = {1,2,3,4};
		  //convert array to list
		  List<String> lList = Arrays.asList(sArray);
	      List<Integer>iList = Arrays.asList(i);
		  System.out.println(lList);
		  System.out.println(iList);
	 
	  }
	}
