package exercicios;

import java.util.Arrays;

public class QuickSort3 {
	
	public static void main(String[] args) {
		int[] a = {4, 1, 2, 7, 9, 6, 8, 7};
		QuickSort3 qs = new QuickSort3();
		System.out.println(Arrays.toString(a));
		qs.quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
	
	public void quickSort(int[] a, int ini, int fim) {
		if(ini >= fim) {
			return;
		}
		int indexPivot = particionaHoare(a, ini, fim);
		quickSort(a, ini, indexPivot);
		quickSort(a, indexPivot + 1, fim);
		
	}
	
	public int particionaLomuto(int[] a, int ini, int fim) {
		int pivot = a[ini];
		int k = ini;
		for(int i = ini + 1; i <= fim; i++) {
			if (a[i] <= pivot) {
				k++;
				swap(a, k, i);
			}
		}
		swap(a, k, ini);
		return k;
	}
	
	public int particionaHoare(int[] a, int ini, int fim) {
		int i = ini + 1;
		int j = fim;
		int pivot = a[ini];
		
		while(i <= j) {
			while (i <= j && a[i] <= pivot) {
				i++;
			}
			while (j >= i && a[j] >= pivot) {
				j--;
			}
			
			if(i <= j) {
				swap(a, i, j);
			}
			//System.out.println(i + " " + j);
		}
		swap(a, ini, j);
		return j;
	}
	
	public void swap(int[] v, int a, int b) {
		int aux = v[a];
		v[a] = v[b];
		v[b] = aux;
	}

}
