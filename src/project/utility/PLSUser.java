package project.utility;

public class PLSUser {

	String username ;
	int imsi;
	long celllac;
	long tempo;
	
	public PLSUser(String u, int i, long c, long t){
		this.username = u;
		this.imsi = i;
		this.celllac = c;
		this.tempo = t; 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getImsi() {
		return imsi;
	}

	public void setImsi(int imsi) {
		this.imsi = imsi;
	}

	public long getCelllac() {
		return celllac;
	}

	public void setCelllac(int celllac) {
		this.celllac = celllac;
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}
	
	
	
}