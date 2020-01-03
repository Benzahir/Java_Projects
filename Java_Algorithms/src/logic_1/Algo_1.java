package logic_1;

public class Algo_1 {

	public static void main(String[] args) {
		 
		System.out.println(caughtSpeeding(60, false));
	}

	public static int caughtSpeeding(int speed, boolean isBirthday) {
		  
		  if(speed<=60 || isBirthday==true && speed<=65 ){
		    return 0;
		  }
		   if(speed>=61 && speed<=80 || isBirthday==true && speed<=85){
		    return 1;
		  }
		 
		  
		  return 2;
		}

}
