package string_2;

public class Algo_10 {

	public static void main(String[] args) {

		System.out.println(prefixAgain("abXYabc", 3));

	}
	
	public static boolean prefixAgain(String str, int n) {
		  
		  String rs="";
		  int count=0;
		  
		  rs=str.substring(0,n);
		 
		 for(int i=0; i<=str.length()-n; i++){
		   if(str.substring(i,n+i).equals(rs)){
		     count++;
		   }
		 }
		 
		 if(count>1){
		   return true;
		 }
		  
		  return false;
		  
		  
		}


}
