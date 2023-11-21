import java.math.BigDecimal;

public class Difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double doubleValue = 0.1;
	    Double epsilon = 0.0000000000000001;
	    System.out.println(doubleValue);
	    // It will generate an epsilon value -> It cannot handle the precision
	    System.out.println(epsilon.toString());
	    
	    System.out.println();
	    
	    //BigDecimal
	    //It can handle the precision
	    BigDecimal bd = new BigDecimal("0.0000000000000001");
	    System.out.println(bd.toPlainString());
	    System.out.println("Presition is : "+ bd.precision());
	    
	    System.out.println();
	    
	    BigDecimal bd1 = new BigDecimal("0.001234567088999654321");
	    System.out.println(bd1.toPlainString());
	    System.out.println("Presition is : "+ bd1.precision());
	    
	    System.out.println();
	    
	    BigDecimal bd2 = new BigDecimal("0");
	    System.out.println(bd2);
	    System.out.println("Presition is : "+ bd2.precision());
	    

	}

}
