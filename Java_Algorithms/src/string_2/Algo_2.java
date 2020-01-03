package string_2;

public class Algo_2 {

	public static void main(String[] args) {
		
		System.out.println(catDog("catdog"));

	}
	
	public static boolean catDog(String str) {
		  
		  int countCAT=0;
		  int countDOG=0;
		  
		  for(int i=0; i<str.length()-2; i++){
		    if(str.charAt(i)=='c' && str.charAt(i+1)=='a'  && str.charAt(i+2)=='t'){
		      countCAT++;
		    }
		     
		      if(str.charAt(i)=='d' && str.charAt(i+1)=='o'  && str.charAt(i+2)=='g'){
		      countDOG++;
		    }
		  }
		  
		  
		  if(countCAT == countDOG){
		    return true;
		  }
		   return false;
		}



}
