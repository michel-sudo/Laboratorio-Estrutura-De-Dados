package exercicios;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] a = {3, 1, 4, 2, 0};
		System.out.println(Arrays.toString(a));
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void bubbleSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			for(int j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j + 1]) {
					int aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
	}

}
