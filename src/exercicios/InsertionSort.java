package exercicios;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] v = {3, 2, 0, 4, 1};
		System.out.println(Arrays.toString(v));
		is.insertionSort(v);
		//System.out.println(Arrays.toString(v));
	}
	
	public void insertionSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int j = i;
			while(j > 0 && a[j] < a[j - 1]) {
				int aux = a[j];
				a[j] = a[j - 1];
				a[j - 1] = aux;
				j -= 1;
				System.out.println(Arrays.toString(a));
			}
		}
	}
}
