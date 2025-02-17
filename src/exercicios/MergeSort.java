package exercicios;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] v = {7, 12, 10, 8, 19, 5, 3, 90};
		//System.out.println(Arrays.toString(v));
		ms.mergeSort(v, 0, v.length - 1);
		System.out.println(Arrays.toString(v));
		
	}
	
	public void mergeSort(int[] v, int left, int right) {
		System.out.println(Arrays.toString(v) + " ms " + left + " - " + right);
		if(left >= right) {
			return;
		} else {
			int middle = (left + right) / 2;
			mergeSort(v, left, middle);
			mergeSort(v, middle + 1, right);
			merge(v, left, middle, right);
		}
	}
	
	public void merge(int[] v, int left, int middle, int right) {
		
		int[] helper = new int[v.length];
		for(int i = left; i <= right; i++) {
			helper[i] = v[i];
		}
		
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while(i <= middle && j <= right) {
			
			if(helper[i] <= helper[j]) {
				v[k] = helper[i];
				i++;
			} else {
				v[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle) {
			v[k] = helper[i];
			i++;
			k++;
		}
		System.out.println(Arrays.toString(v) + " m ");
	}

}
