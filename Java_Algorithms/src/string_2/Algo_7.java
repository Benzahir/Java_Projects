package string_2;

public class Algo_7 {
	
   public static void main(String[] args) {
		
		System.out.println(mixString("abc", "xyz"));
	}
	
	public static String mixString(String a, String b) {
		  
		  String rs="";
		    if(a.length()==b.length()){
		      for(int i=0,j=0; i<a.length() && j<b.length(); i++,j++){
		       rs+=a.substring(i,i+1)+b.substring(j,j+1);
		    }
		    }
		    
		    if(a.length()<b.length()){
		      for(int i=0,j=0; i<a.length() && j<b.length(); i++,j++){
		       rs+=a.substring(i,i+1)+b.substring(j,j+1);
		    }
		    rs=rs+b.substring(a.length(),b.length());
		    }
		    
		    if(a.length()>b.length()){
		      for(int i=0,j=0; i<a.length() && j<b.length(); i++,j++){
		       rs+=a.substring(i,i+1)+b.substring(j,j+1);
		    }
		    rs=rs+a.substring(b.length(),a.length());
		    }
		     
		  return rs;
		  
		}


}
