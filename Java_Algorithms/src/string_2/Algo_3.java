package string_2;

public class Algo_3 {

	public static void main(String[] args) {
 
		System.out.println(countCode("aaacodebbb"));
	}

	public static int countCode(String str) {
		  
		  int count =0;
		  
		  for(int i=0; i<str.length()-3; i++){
		    if(str.charAt(i)=='c' && str.charAt(i+1)=='o'&& str.charAt(i+3)=='e'){
		      count++;
		    }
		  }
		  
		  return count;
		}

}
