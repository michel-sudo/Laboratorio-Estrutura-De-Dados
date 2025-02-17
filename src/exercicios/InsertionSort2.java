package exercicios;

import java.util.Arrays;

public class InsertionSort2 {
	
	public static void main(String[] args) {
		int[] a = {2, 3, 1, 6, 0};
		InsertionSort2 is = new InsertionSort2();
		System.out.println(Arrays.toString(a));
		is.insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public void insertionSort(int[] v) {
		for(int i = 1; i < v.length; i++) {
			int j = i;
			while(j > 0 && v[j] < v[j - 1]) {
				int aux = v[j];
				v[j] = v[j - 1];
				v[j - 1] = aux;
				j--;
			}
		}
	}

}
