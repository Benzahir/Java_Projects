package string_2;

public class Algo_6 {

	public static void main(String[] args) {
		
		System.out.println(xyBalance("aaxbby"));

	}
	
	public static boolean xyBalance(String str) {
		  
		  int count =0;
		  
		  if(str.length()==0){
		    return true;
		  }

		  for(int i=0; i<str.length(); i++){
		    if(str.charAt(i)=='x'){
		      for(int j=str.length()-1; j>i; j--){
		        if(str.charAt(j)=='y'){
		         return true;
		       }
		       if(str.charAt(j)=='x'){
		         return false;
		       }
		      }
		    }
		    if(str.charAt(i)=='y' && str.length()==1 ){
		      return true;
		    }
		    if(str.charAt(i)!='x' && str.charAt(i)!='y'){
		      count++;
		    }
		     
		  }
		  
		  if(str.length()==count){
		    return true;
		  }
		    
		 
		  return false;
		 
		}


}
