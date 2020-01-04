package Abstract_Factory_Pattern;

public class HDFC implements Bank {
	
	private final String BNAME;  
    public HDFC(){  
           BNAME="HDFC BANK";  
   }  
   public String getBankName() {  
             return BNAME;  
   }  

}
