package string_2;

public class Algo_4 {

	public static void main(String[] args) {
		
		System.out.println(endOther("Hiabc", "abc"));

	}
	
	public static boolean endOther(String a, String b) {
		  
		  String aa=a.toLowerCase();
		  String bb=b.toLowerCase();
		  
		  if(a.length()>b.length()){
		    if(aa.substring(a.length()-b.length()).equals(bb)){
		      return true;
		    }
		  }
		  
		  if(b.length()>=a.length()){
		    if(bb.substring(b.length()-a.length()).equals(aa)){
		      return true;
		    }
		  }
		  
		  
		  return false;
		}


}
