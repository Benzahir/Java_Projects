package string_2;

public class Algo_11 {

	public static void main(String[] args) {
		 
		System.out.println(getSandwich("breadjambread"));

	}
	
	public static String getSandwich(String str) {
		  
		  for(int i=0; i<str.length()-5; i++){
		    if(str.substring(i,i+5).equals("bread")){
		      for(int j=str.length(); j>i+5; j--){
		        if(str.substring(j-5,j).equals("bread")){
		          return str.substring(i+5,j-5);
		        }
		      }
		      
		    }
		  }
		  
		  return "";
		}


}
