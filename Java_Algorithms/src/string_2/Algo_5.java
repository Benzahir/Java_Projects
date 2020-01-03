package string_2;

public class Algo_5 {

	public static void main(String[] args) {

		System.out.println(xyzThere("abc.xyz"));

	}
	
	public static boolean xyzThere(String str) {
		  
		  for(int i=0; i<str.length()-2; i++){
		    if(i==0){
		      if(str.substring(i,i+3).equals("xyz")){
		        return true;
		      }
		    }
		    else{
		      if(str.substring(i,i+3).equals("xyz") && !str.substring(i-1,i).equals(".")){
		        return true;
		      }
		    }
		    
		  }
		  
		  return false;
		}


}
