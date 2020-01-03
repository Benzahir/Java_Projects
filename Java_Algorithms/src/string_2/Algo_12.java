package string_2;

public class Algo_12 {

	public static void main(String[] args) {

		System.out.println(zipZap("zipXzap"));

	}
	
	public static String zipZap(String str) {
		  
		 String rs="";
		  if(str.length()>2){
		     for(int i=0; i<str.length(); i++){
		    if(str.substring(i,i+1).equals("z") && str.substring(i+2,i+3).equals("p")){
		      rs+=str.substring(i,i+1)+str.substring(i+2,i+3);
		      i+=2;
		    }
		    else{
		      rs+=str.substring(i,i+1);
		    }
		    
		  }
		  return rs;
		  }
		  
		  return str;
		}



}
