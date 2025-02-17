package exercicios;

import java.util.Arrays;

public class QuickSort2{

	public static void main(String[] args){
		int[] a = {3, 8, 7, 10, 0, 23, 2, 1, 77, 7};
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] a, int ini, int fim){
		if (ini < fim) {
			int pivot = particionamento(a, ini, fim);
			quickSort(a, ini, pivot - 1);
			quickSort(a, pivot + 1, fim);
		}
	}

	public static int particionamento(int[] a, int ini, int fim){
		
		int range = fim - ini + 1;
		int rangePivotIndex = (int)(Math.random() * range) + ini;
		swap(a, ini, rangePivotIndex);
		
		int pivot = a[ini];
		int cont = ini;
		
		for(int i = ini + 1; i <= fim; i++){
			if(a[i] <= pivot){
				cont++;
				swap(a, i, cont);
			}
		}
		swap(a, cont, ini);
		return cont;
	}	

	public static void swap(int[] a, int n1, int n2){
		int aux = a[n1];
		a[n1] = a[n2];
		a[n2] = aux;
	} 
}
