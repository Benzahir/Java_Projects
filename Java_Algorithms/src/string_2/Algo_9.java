package string_2;

public class Algo_9 {

	public static void main(String[] args) {

		System.out.println(repeatSeparator("Word", "X", 3));
	}
	
	public static String repeatSeparator(String word, String sep, int count) {
		  
		  String rs="";
		  
		  if(count >1){
		    for(int i=1; i<count; i++){
		    rs+=word+sep;
		    }
		  }
		  
		  if(count==0){
		    return "";
		  }
		  return rs+word;
		}

}
