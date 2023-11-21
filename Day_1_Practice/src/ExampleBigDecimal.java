import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExampleBigDecimal {

	public static void main(String[] args) {

		BigDecimal bd = new BigDecimal("12345.12345467");
		BigDecimal setScale = bd.setScale(5, RoundingMode.DOWN);
		System.out.println("Scale with Down mode : "+ setScale);
		
		BigDecimal setScale2 = bd.setScale(5, RoundingMode.UP);
		System.out.println("Scale with Up mode : "+ setScale2);
		
		BigDecimal setScale3 = bd.setScale(5, RoundingMode.FLOOR);
		System.out.println("Scale with Floor mode : "+ setScale3);
		
		BigDecimal setScale4 = bd.setScale(5, RoundingMode.HALF_DOWN);
		System.out.println("Scale with Half Down mode : "+ setScale4);
		
		BigDecimal setScale5 = bd.setScale(5, RoundingMode.CEILING);
		System.out.println("Scale with Ceeling mode : "+ setScale5);
		
		BigDecimal setScale6 = bd.setScale(5, RoundingMode.HALF_UP);
		System.out.println("Scale with Half Up mode : "+ setScale6);
		
		BigDecimal setScale7 = bd.setScale(5, RoundingMode.HALF_EVEN);
		System.out.println("Scale with Half Even mode : "+ setScale7);
		
		System.out.println();
		
		BigDecimal bd1 = new BigDecimal("12345.123456");
		BigDecimal setScale8 = bd1.setScale(5, RoundingMode.DOWN);
		System.out.println("Scale with Down mode : "+ setScale8);
		
		BigDecimal setScale9 = bd1.setScale(5, RoundingMode.UP);
		System.out.println("Scale with Up mode : "+ setScale9);
		
		BigDecimal setScale10 = bd1.setScale(5, RoundingMode.FLOOR);
		System.out.println("Scale with Floor mode : "+ setScale10);
		
		BigDecimal setScale11 = bd1.setScale(5, RoundingMode.HALF_DOWN);
		System.out.println("Scale with Half Down mode : "+ setScale11);
		
		BigDecimal setScale12 = bd1.setScale(5, RoundingMode.CEILING);
		System.out.println("Scale with Ceeling mode : "+ setScale12);
		
		BigDecimal setScale13 = bd1.setScale(5, RoundingMode.HALF_UP);
		System.out.println("Scale with Half Up mode : "+ setScale13);
		
		BigDecimal setScale14 = bd1.setScale(5, RoundingMode.HALF_EVEN);
		System.out.println("Scale with Half Even mode : "+ setScale14);
	}

}
