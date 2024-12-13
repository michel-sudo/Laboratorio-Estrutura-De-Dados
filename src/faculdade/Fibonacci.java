package faculdade;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fibonacci fb = new Fibonacci();
		int num = sc.nextInt();
		System.out.println(fb.sequenciaFibonacci(num));
		
	}
	
	public int sequenciaFibonacci(int num) {
		if (num == 1) {
			return 1;
		}
		if (num == 0) {
			return 0;
		}
		return sequenciaFibonacci(num - 1) + sequenciaFibonacci(num - 2);
	}
}
