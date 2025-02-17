package exercicios;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {3,8,7,10,0,23,2,1,77,7};
		//int[] v = {3,1,2,3,10,23,2,1,77,7};
		int[] v = {3,1,2,3,10,23,2,1,77,7,11,13};
		System.out.println(Arrays.toString(v));
		quickSort(v, 0, v.length - 1);
		//particionamentoHoare(v, 0, v.length - 1);
		System.out.println(Arrays.toString(v));
	}
	
	public static void quickSort(int[] a, int left, int rigth) {
		if (left < rigth) {
			//int index_pivot = particionamento(a, left, rigth);
			int index_pivot = particionamentoHoare(a, left, rigth);
			quickSort(a, index_pivot + 1, rigth);
			quickSort(a, left, index_pivot - 1);
		}
	}
	
	public static int particionamento(int[] a, int left, int rigth) {
		int i = left;
		int pivot = a[left];
		for(int j = left + 1; j <= rigth; j++) {
			if(a[j] <= pivot) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i, left);
		return i;
	}
	
	public static int particionamentoHoare(int[] a, int ini, int fim) {
		int i = ini + 1;
		int j = fim;
		int pivot = a[ini];
		while (i <= j) {
			if(a[i] <= pivot) {
				i++;
			} if(a[j] >= pivot) {
				j--;
			} if (i < a.length && a[i] > pivot && a[j] < pivot) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		swap(a, ini, j);
		return j;
	}
	
	public static void swap(int[] a, int i, int j) {
		int aux = a[j];
		a[j] = a[i];
		a[i] = aux;
	}
}
