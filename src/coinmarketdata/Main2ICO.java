package coinmarketdata;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2ICO {
		
	public static String baseURL ="https://api.coinmarketcap.com/v1/ticker?limit=500";
//	public static String globalURL = "https://api.coinmarketcap.com/v1/global/";
//	public static String euro = "https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=790";
	
	public static void main (String [] args)throws Exception{
	
		 for(int j = 0; j < 365; j++){
			 System.out.println("day "+j);
			 for(int i = 0; i < 24; i++){
				 Date d = new Date();
				 System.out.println("iter "+i+" at "+d.toString());
				 run();
				 Thread.sleep(1000*60*60);
				 run();
			 }
		 }
	}
		
		public static void run() throws Exception{
		String CMC_response = getJSON(baseURL);
       
		Calendar cal = Calendar.getInstance();
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		System.out.println( sdf.format(cal.getTime()) );
		String data =  sdf.format(cal.getTime()).toString();
		String element = CMC_response.replaceAll("\\[|\\]|\\{|\\}|\\\"", "");
		element = element.trim().replace(":", ",");
		String[] e = element.split(",");
		

		List<String>l = new ArrayList<String>();

		int count = 0;
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i < e.length; i = i+2){
			//System.out.println(e[i].trim());
			sb.append(e[i].trim()+",");
			count++;
			if(count == 15){
				String s = sb.toString();
				l.add((s.trim()));
				sb = new StringBuffer();
				count = 0;
			}
		}
		
		int num = 500;
		print("CoinMarketCap_"+data+"_"+num+"_Data.json", CMC_response);
		print2("CoinMarketCap_"+data+"_"+num+"_Data.csv", l, num);

	}
		
	
	
	 public static void print2(String file,  List<String>l, int n) throws Exception{  
			
			PrintWriter out = new PrintWriter(new FileWriter(new File(file)));  
			out.println("id,name,symbol,rank,price_usd,price_btc,"
					     + "h24_volume_usd,market_cap_usd,avail_sup,"
					     + "tot_sup,max_supply,per_change_1h,"
					     + "per_change_24h,per_change_7d,last_updated"
					   );
			    int count = 0;
				for(int i = 0; i < l.size(); i++){
					
					 out.println(l.get(i).substring(0, l.get(i).length()-1));
					count++;
					if(count == n) break;
				}
				
			    out.close(); 
		}
	
	   public static void print(String file, String json) throws Exception{  
			
			PrintWriter out = new PrintWriter(new FileWriter(new File(file)));  
			out.print(json);
				
			    out.close(); 
		}
	
	public static List<Coin>getDailyValues(String resp) throws Exception{
		
		 List<Coin> coins = new ArrayList<Coin>();
		 List<String> coins2 = new ArrayList<String>();

		 String id ="";
		 String name = "";
		 String symbol = "";
		 double rank = 0;
		 double price_usd = 0.0;
		 double price_btc = 0.0;
		 double h24_volusd = 0.0;
		 double mcapusd = 0.0;
		 double aval_sup =0.0;
		 double tot_sup = 0.0;
		 Double max_supply = 0.0;
		 double per_ch1h = 0.0;
		 double per_ch24h = 0.0;
		 double per_ch7d = 0.0;
		 long last_up = 0L;
		
		 try { 

				JSONArray jarr = new JSONArray(resp);  
				
				for(int i = 0; i < jarr.length(); i++){ 
				//	System.out.println(jarr.toString());
					Object jo = jarr.get(i); 
				
					JSONObject jso = (JSONObject)jo; 
				    id = jso.getString("id");
				    System.out.println("id per crypt o "+id);
				    name = jso.getString("name");
				    symbol = jso.getString("symbol");
					 rank = jso.getDouble("rank");
					 System.out.println(name+", "+symbol+", "+rank); 
					 
					 price_usd = jso.getDouble("price_usd");
					 price_btc = jso.getDouble("price_usd");
					 h24_volusd = jso.getDouble("24h_volume_usd");
					 mcapusd = jso.getDouble("market_cap_usd");  
					 aval_sup =jso.getDouble("available_supply");  
					 tot_sup = jso.getDouble("total_supply");  
					 max_supply = jso.getDouble("max_supply");  
					 if(max_supply == null) max_supply = 0.0;
					 per_ch1h = jso.getDouble("percent_change_1h"); 
					 per_ch24h = jso.getDouble("percent_change_24h");
					 per_ch7d = jso.getDouble("percent_change_7d");
					 last_up = jso.getLong("last_updated");

					
	               
	                coins.add(new Coin (id, name, 
	                		symbol,
	                		rank,
	                		price_usd,
	                		price_btc,
	                		h24_volusd,
	                		mcapusd,
	                		aval_sup,
	                		tot_sup,
	                		per_ch1h,
	                		per_ch24h,
	                		per_ch7d,
	                		last_up)
	                		);
				}
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.println("The field is null");
			 
		 }
		 
		 
		 return coins;
	}
	
//	public static List<Coin>getGlobal(String resp) throws Exception {
//		
////		List<Coin> global = new ArrayList<Coin>();	
////		JSONObject jso = new JSONObject(resp); 
////		long total_market_cap_usd = jso.getLong("total_market_cap_usd"); 
////		System.out.println(total_market_cap_usd );
////		long total_24h_volume_usd = jso.getLong("total_24h_volume_usd"); 
////		long bitcoin_percentage_of_market_cap = jso.getLong("bitcoin_percentage_of_market_cap"); 
////		long active_currencies = jso.getLong("active_currencies");
////		long active_assets = jso.getLong("active_assets");
////		long active_markets = jso.getLong("active_markets");
////		
////		global.add(new Coin(total_market_cap_usd, total_24h_volume_usd,bitcoin_percentage_of_market_cap
////				,active_currencies,active_assets,active_markets));
////		return global;
//	} 
	private static String getJSON(String urlString) throws IOException{ 
		URL url = new URL(urlString); 
		URLConnection conn = url.openConnection();  
		
		InputStream is = conn.getInputStream();   
		String json_string = IOUtils.toString(is, "UTF-8");  
		is.close();    
		return json_string; 
	}  

	public static void printGlobal(String file,  List<Coin>m) throws Exception{  
		
		PrintWriter out = new PrintWriter(new FileWriter(new File(file)));  
		out.println("sym,name,rank,price_usd,price_btc,percent_change1h,percent_change1d,vol,last_up");

			for(int i = 0; i < m.size(); i++){
				out.println(m.get(i));
			}
		    out.close(); 
	}

 
	
	
    public static String convertTsp2Date(long timestamp){
		
		Date data ;
		
		Calendar c = new GregorianCalendar();
		c.setTimeInMillis(timestamp);
		data = c.getTime();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yy HH.mm.ss");
		String datainstringa = new String(dateformat.format(data));
		return datainstringa;
		
	}
}
