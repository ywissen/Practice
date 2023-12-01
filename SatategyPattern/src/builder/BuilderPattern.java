package builder;

import java.util.Arrays;

/*
 * Suppose for given list of Integers we need to do sum depending on user choice and return it.
Options - 
1. All 
2. Odd 
3. Even 

Consider Design Principles and Patterns while coding.

Code should be extensible for any other option -
4. Prime
 */
interface Stategy {
	int operation(int[] arr);
}

class All implements Stategy{

	@Override
	public int operation(int[] arr) {
		return (int) Arrays.stream(arr).sum();
	}
	
}
class Odd implements Stategy{
	
	@Override
	public int operation(int[] arr) {
		return (int) Arrays.stream(arr).filter(a->a%2!=0).sum();
	}
	
}
class Even implements Stategy{
	
	@Override
	public int operation(int[] arr) {
		return (int) Arrays.stream(arr).filter(a->a%2==0).sum();
	}
	
}

class Context{
	Stategy stategy;
	
	Context(Stategy stategy){
		this.stategy = stategy;
	}
	public int doOperation(int[] arr) {
		return stategy.operation(arr);
	}
}


public class BuilderPattern {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		// Adding all numbers
		Context context1 = new Context(new All());
		int doOperation1 = context1.doOperation(arr);
		System.out.println("Adding all numbers "+doOperation1);
		
		//Adding Odd numbers
		Context context2 = new Context(new Odd());
		int doOperation2 = context2.doOperation(arr);
		System.out.println("Adding Odd numbers "+doOperation2);
		
		//Adding Even numbers
		Context context3 = new Context(new Even());
		int doOperation3 = context3.doOperation(arr);
		System.out.println("Adding Even numbers "+doOperation3);
		
		//It is Expendable to prime to

	}

}
