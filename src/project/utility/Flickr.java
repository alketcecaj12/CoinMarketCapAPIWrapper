package project.utility;

public class Flickr implements Comparable<Flickr>{

	
	
	public String user;
	public long ts; 
	String date;
	
	
	public Flickr(String user, long t, String date){
		
		this.user = user;
		this.ts = t;
	}
	
	
	public String toString(){
		return user+","+ts+","+date;
	}
	
	public int compareTo(Flickr f){
		
		if(ts> f.ts) return 1;
		if(ts < f.ts) return -1;
		return 0;
	}
	
}
