package exercicios;

import java.util.Arrays;

public class CountingSort {
	
	public static void main(String[] args) {
		int[] v = {8, 3, 2, 6};
		System.out.println(Arrays.toString(v));
		System.out.println(Arrays.toString(countingSortSemRepeticao(v)));
	}
	
	public static int[] countingSort(int[] a) {
		
		int[] c = new int[pegaMaior(a)];
		
		for(int i = 0; i < a.length; i++) {
			c[a[i] - 1] += 1;
		}
		
		for(int j = 1; j < c.length; j++) {
			c[j] += c[j - 1];
		}
		
	}
	
	public static int[] countingSortSemRepeticao(int[] a){
		
		boolean[] c = new boolean[pegaMaior(a)];
		
		for(int i = 0; i < a.length; i++) {
			c[a[i] - 1] = true;
		}
		
		int[] b = new int[a.length];
		int k = 0;
		
		for(int j = 0; j < c.length; j++) {
			if(c[j]) {
				b[k] = j + 1;
				k++;
			}
		}
		
		return b;
	}
	
	public static int pegaMaior(int[] a) {
		int maior = a[0];
		for(int i = 1; i < a.length; i++) {
			if(a[i] > maior) {
				maior = a[i];
			}
		}
		return maior;
	}
	
	
}
