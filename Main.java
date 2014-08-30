import java.util.Scanner;


public class Main {

	public static void main (String [] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("N = ");
		double N = in.nextDouble();
		
		System.out.print("Left, Right, or Midpoint sum? ('L' or 'R' or 'M'): ");
		
		String next = in.next();
		
		if(next.equals("L")){
		
			System.out.print("LEFT SUM:" + "\n" + "\n" + getLeftSum(N));
		
		}
		else if(next.equals("R")){
			
			System.out.print("RIGHT SUM:" + "\n" + "\n" + getRightSum(N));
			
		}
		else{
			System.out.print("MIDPOINT SUM:" + "\n" + "\n" + getMidSum(N));		}
		
	}
	
	private static double getLeftSum(double N){
		
		
		double e = Math.E;
		double a = 0;
		double b = 2;
		
		
		double deltaX = 2/N;
		
		System.out.println("deltaX = " + deltaX);
		
		//f(a)
		double total = 1.0 + Math.pow(e, getExponent(deltaX, 1));;
		System.out.println("current total = e^0 + e^" + getExponent(deltaX, 1) + "  = " + total);
		
		for(int i = 2; i < N-1; i++){
			//repeat until N-1
			total += Math.pow(e, getExponent(deltaX, i));
			System.out.println("current total = e^" + getExponent(deltaX, i) + "  = " + total);
		}
		
		// add last f(b-deltaX)
		total += Math.pow(e, getExponent(b-deltaX, 1));
		System.out.println("current total = e^" + getExponent(b-deltaX, 1) + "  = " + total);
		
		
		total *= deltaX;
		System.out.println("after multiplying everything by the outside by " + deltaX);

		System.out.println("total is approx: " + total + "\n" + "\n");
		return total;
	}

	private static double getRightSum(double N){


		double e = Math.E;
		double a = 0;
		double b = 2;


		double deltaX = 2/N;

		System.out.println("deltaX = " + deltaX);
		
		//f(b)
		double total = Math.pow(e, -2.0);
		
		System.out.println("current total = e^(-2.0)" + "  = " + total);
		
		for(int i = 1; i < N; i++){
			//repeat until N-1
			total += Math.pow(e, getExponent(deltaX, i));
			System.out.println("current total = e^" + getExponent(deltaX, i) + "  = " + total);
		}
	
		
		total *= deltaX;
		System.out.println("after multiplying everything by the outside by " + deltaX);
		
		System.out.println("total is approx: " + total + "\n" + "\n");
		return total;
	}
	
	private static double getMidSum(double N){


		double e = Math.E;
		double a = 0;
		double b = 2;


		double deltaX = 2/N;

		System.out.println("deltaX = " + deltaX);
		
		double total = 0.0;
		
		for(int i = 1; i < 2*N; i+=2){
			
			double num = i * deltaX;
			double denom = 2.0;
			double newExp = num/denom;
			
			total += Math.pow(e, getExponent(newExp, 1));
			System.out.println("current total = e^" + getExponent(newExp, i) + "  = " + total);
		}
	
		
		total *= deltaX;
		System.out.println("after multiplying everything by the outside by " + deltaX);
		
		System.out.println("total is approx: " + total + "\n" + "\n");
		return total;
	}

	private static double getExponent(double deltaX, int i){

		double num = -(Math.pow(i*deltaX, 2.0));
		double denom = 2.0;
		//return -(x^2)/2
		return num/denom;

	}
}
