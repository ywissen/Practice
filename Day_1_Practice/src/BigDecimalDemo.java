import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class BigDecimalDemo {

	public static void main(String[] args) {

		//Constructors of BigDecimal class
		BigDecimal bd = new BigDecimal(12345.12345467);
		// We are not getting the accurate value by this constructor
		System.out.println("Double constructor : "+bd);
		
		char[] ch = {'1','2','3','4','5','.','1','2','3','4','5','4','6','7'};
 		BigDecimal bd1 = new BigDecimal(ch);
 		System.out.println("char constructor : "+bd1);
 		
 		BigDecimal bd2 = new BigDecimal("12345.12345467");
 		//We will get the accurate value by using string constructor
 		System.out.println("String constructor : "+bd2);
 		
 		BigDecimal bd3 = new BigDecimal(12345.12345467, MathContext.DECIMAL32);
 		System.out.println("Using Math context : "+bd3);
 		
 		System.out.println();
 		
 		//Using double constructor object
 		BigDecimal abs = bd.abs();
 		System.out.println("Absolute value : "+abs);
 		
 		//Using String constructor object
 		BigDecimal abs1 = bd2.abs();
 		System.out.println("Absolute value using String constructor object: "+abs1);
 		
 		//adding two BigDecimal
 		BigDecimal add = bd.add(bd2);
 		System.out.println("Adding two bd and bd2 object : "+add);
 		
 		BigDecimal add2 = bd.add(bd2, MathContext.DECIMAL64);
 		System.out.println("Adding two and getting value by using math context : "+add2);
 		
 		//Generating byte value
 		byte byteValue = bd.byteValue();
 		System.out.println("Byte Value : "+byteValue);
 		
 		System.out.println();
 		
 		int compareTo = bd.compareTo(bd2);
 		System.out.println("Comparing the elements of double constructor and String constructor : "+ compareTo);//-1
 		
 		int compareTo2 = bd1.compareTo(bd2);
 		System.out.println("Comparing the elements of char constructor and String constructor : "+ compareTo2);//0
 		
 		System.out.println();
 		
 		BigDecimal divide = bd.divide(BigDecimal.TEN);
 		System.out.println("Dividing and printing the quotient : "+divide);
 		
 		BigDecimal[] divideAndRemainder = bd.divideAndRemainder(BigDecimal.TEN);
 		System.out.println("Quotient + reminder"+ Arrays.toString(divideAndRemainder));
 		System.out.println();
 		// Type Conversion
 		float floatValue = bd.floatValue();
 		System.out.println("Float value : "+floatValue);
 		
 		int intValue = bd.intValue();
 		System.out.println("Int value : "+intValue);
 		
 		double doubleValue = bd.doubleValue();
 		System.out.println("Double value : "+doubleValue);
 		
 		long longValue = bd.longValue();
 		System.out.println("Long Value is : "+longValue);
 		
 		//Precision -> getting the count of the digits present in the Big Decimal
 		int precision = bd2.precision();
 		System.out.println("Presion is : "+precision);
 		
 		//0 is also counted as 1
 		BigDecimal bd4 = new BigDecimal("-12305.12305467");
 		System.out.println("Presion of bd4 is : "+bd4.precision());
 		
 		// Scale -> Scale is calculated the number of floating points present after the .
 		System.out.println("Scale of bd4 : "+ bd4.scale());//8
 		
 		//Max value
 		BigDecimal max = bd4.max(bd2);
 		System.out.println("Max element of bd4 and bd2 : "+ max);
 		
 		//Min value
 		BigDecimal min = bd4.min(bd2);
 		System.out.println("Min element of bd4 and bd2 : "+ min);
 		
 		//Checking the value is positive or negative
 		System.out.println("Checking value is positive or negative"+bd4.signum());
 		
 		System.out.println();
 		//Primitive to Object
 		BigDecimal valueOf = BigDecimal.valueOf(123456.123456);
 		System.out.println("Double valueOf : "+valueOf);
 		BigDecimal valueOf1 = BigDecimal.valueOf(123456L);
 		System.out.println("Long valueOf : "+valueOf1);
 		BigDecimal valueOf2 = BigDecimal.valueOf(1223345678, 4);
 		System.out.println("Long with presition valueOf : "+valueOf2);
 		
 		//Rounding Mode
 		BigDecimal setScale2 = bd2.setScale(5, RoundingMode.CEILING);
 		System.out.println(setScale2);
 		
 		//Power
 		BigDecimal pow = bd2.pow(4);
 		System.out.println("Power : "+pow);
 		
 		BigDecimal negate = bd2.negate();
 		System.out.println("Negative value : "+negate);
 		
 		BigDecimal plus = bd4.plus();
 		System.out.println("Positive value : "+plus);
 		
 		BigDecimal multiply = bd2.multiply(bd4);
 		System.out.println("Multiplication : "+multiply);
 		
 		// By using set scale method we can give the value grater than the present scale value. If we want to give less than that round is necessary
 		BigDecimal setScale = bd2.setScale(15);
 		System.out.println("Setting up the new scale : "+setScale);
 		
 		
 		
 		
 		
	}

}
