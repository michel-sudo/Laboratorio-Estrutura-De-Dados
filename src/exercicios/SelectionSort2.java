package exercicios;

import java.util.Arrays;

public class SelectionSort2 {
	
	public static void main(String[] args) {
		int[] a = {4, 2, 7, 9, 1};
		System.out.println(Arrays.toString(a));
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void selectionSort(int[] v) {
		for(int i = 0; i < v.length; i++) {
			for(int j = i + 1; j < v.length; j++) {
				if (v[j] < v[i]) {
					int aux = v[j];
					v[j] = v[i];
					v[i] = aux;
				}
			}
		}
	}

}
