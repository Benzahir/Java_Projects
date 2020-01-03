package logic_1;

public class Algo_6 {

	public static void main(String[] args) {
		 
		System.out.println(fizzString("fig"));
	}
	
	public static String fizzString(String str) {
		  
		  if(str.substring(0,1).equals("f") && str.substring(str.length()-1).equals("b")){
		    return "FizzBuzz";
		  }
		  if(str.substring(0,1).equals("f")){
		    return "Fizz";
		  }
		  if( str.substring(str.length()-1).equals("b")){
		    return "Buzz";
		  }
		  return str;
		}

}
