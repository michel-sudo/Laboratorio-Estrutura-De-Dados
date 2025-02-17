package exercicios;

import java.util.Arrays;

public class MergeSort2 {
	
	public static void main(String[] args) {
		MergeSort2 ms = new MergeSort2();
		int[] v = {7, 12, 10, 8, 19, 5, 3, 90};
		//System.out.println(Arrays.toString(v));
		ms.mergeSort(v, 0, v.length - 1);
		System.out.println(Arrays.toString(v));
	}
	
	public void mergeSort(int[] a, int ini, int fim) {
		if(ini >= fim) {
			return;
		}
		int middle = (ini + fim) / 2;
		mergeSort(a, ini, middle);
		mergeSort(a, middle + 1, fim);
		merge(a, ini, middle, fim);
	}
	
	public void merge(int[] a, int ini, int middle, int fim) {
		int[] helper = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			helper[i] = a[i];
		}
		
		int i = ini;
		int j = middle + 1;
		int k = ini;
		
		while(i <= middle && j <= fim) {
			if (helper[i] <= helper[j]) {
				a[k] = helper[i++];
			} else {
				a[k] = helper[j++];
			}
			k++;
		}
		
		while (i <= middle) {
			a[k++] = helper[i++];
		}
	}
}
