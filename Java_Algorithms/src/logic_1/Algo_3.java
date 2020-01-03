package logic_1;

public class Algo_3 {

	public static void main(String[] args) {
		 
		System.out.println(specialEleven(22));

	}

	public static boolean specialEleven(int n) {
		   
	    for(int i=0; i< 100; i++){
	       if(n==(11*i)+1 ){
	    return true;
	  }
	    }
	  if(n%11==0){
	    return true;
	  }
	  
	  return false;
	}
}
