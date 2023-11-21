import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Optional;

public class DoubleDemo {

	public static void main(String[] args) {

		Double d = new Double(12345.12345467);
		
		Double d1 = new Double("12345.12345467");
		
		System.out.println(d+" "+d1);
		System.out.println("Comparing using reference : "+(d==d1)); // false
		
		//Compare to method
		System.out.println("Comparing usig compareTo method : "+ d.compareTo(d1)); // 0
		
		System.out.println();
		
		// Type conversion methods Object - primitive
		byte byteValue = d.byteValue();
		System.out.println("Byte value is : "+byteValue);
		
		float floatValue = d.floatValue();
		System.out.println("Float value is : "+floatValue);
		
		int intValue = d.intValue();
		System.out.println("Int value is : "+intValue);
		
		long longValue = d.longValue();
		System.out.println("Long value is : "+longValue);
		
		String string = d.toString();
		System.out.println("Converting into String : "+string);
		
		System.out.println();
		// Primitive to Object conversion
		Double valueOf = Double.valueOf(12345.12345467);
		System.out.println("primitive to object conversion : "+ valueOf);
		
		Double valueOf1 = Double.valueOf("12345.12345467");
		System.out.println("String to object conversion : "+ valueOf1);
		
		System.out.println();
		//Comparing two double objects using static methods
		int compare = Double.compare(d, d1);
		System.out.println("Compare using static compare method : "+ compare); //0
		
		System.out.println();
		
		Double d2 = 12345.12345467;
		Double d3 = 12345.12346;
		
		double max = Double .max(d2, d3);
		System.out.println("Max value is : "+max);
		
		double min = Double .min(d2, d3);
		System.out.println("Min value is : "+min);
		
		System.out.println();
		
		String hexString = Double.toHexString(min);
		System.out.println("Hexa String is : "+ hexString);
		
		
		Double d4  = Double.NaN;
		boolean naN = Double.isNaN(d4);
		System.out.println("Checking on NaN method : "+naN);
		
		System.out.println();
		
		Optional<Double> describeConstable = d.describeConstable();
		System.out.println("Optional Object"+ describeConstable.get());
		
		
		// Max value of double
		double maxValue = Double.MAX_VALUE;
		System.out.println("Max Value : "+maxValue);
		
		// Min value of Double
		double minValue = Double.MIN_VALUE;
		System.out.println("Min Value"+minValue);
		
		System.out.println();
		
		//Round using DecimalDecoder
		DecimalFormat decfor = new DecimalFormat("0.00");  
		String format = decfor.format(max);
		System.out.println(format);
		decfor.setRoundingMode(RoundingMode.CEILING);
		String format2 = decfor.format(max);
		System.out.println(format2);
	}

}
