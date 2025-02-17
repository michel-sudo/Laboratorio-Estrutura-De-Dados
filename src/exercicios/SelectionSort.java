package exercicios;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		int[] v = {2, 3, 1, 0, 4};  
		System.out.println(Arrays.toString(v));
		ss.selectionSort(v);
		System.out.println(Arrays.toString(v));
	}
	
	public void selectionSort(int[] array) {
		for(int j = 0; j < array.length; j++) {
			int indiceMenor = j;
			for(int i = j + 1; i < array.length; i++) {
				if(array[i] < array[indiceMenor]) {
					indiceMenor = i;
				}
			}
			int aux = array[j];
			array[j] = array[indiceMenor];
			array[indiceMenor] = aux;
			//System.out.println(Arrays.toString(array));
		}
	}
}