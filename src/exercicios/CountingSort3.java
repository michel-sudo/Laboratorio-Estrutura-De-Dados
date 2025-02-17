package exercicios;

import java.util.Arrays;

public class CountingSort3 {
	
	public static void main(String[] args) {
		int[] a = {2324, 1567, 3363, 1523, 4511};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(radixSort(a, 4)));
	}
	
	public static int[] radixSort(int[] a, int k) {
		for(int i = 0; i <= k/2; i += 2) {
			a = countingSort(a, i);
			System.out.println(Arrays.toString(a));
		}
		return a;
	}
	
	public static int getTwoDigit(int a, int k) {
		int h = 0;
		int digito = 0;
		for(int i = k; i <= k + 1; i++) {
			digito += ((a / (int) Math.pow(10, i)) % 10) * (int) Math.pow(10, h);
			h++;
		}
		return digito;
	}
	
	public static int[] countingSort(int[] a, int k) {
		int[] digitos = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			digitos[i] = getTwoDigit(a[i], k);
		}
		System.out.println(Arrays.toString(digitos));
		int[] b = new int[100];
		
		for(int i = 0; i < a.length; i++) {
			b[digitos[i]] += 1;
		}
		
		for(int i = 1; i < b.length; i++) {
			b[i] += b[i - 1];
		}
		
		int[] c = new int[a.length];
		for(int i = a.length - 1; i >= 0; i--) {
			c[b[digitos[i]] - 1] = a[i];
			b[digitos[i]] -= 1;
		}
		return c;
	}
}
