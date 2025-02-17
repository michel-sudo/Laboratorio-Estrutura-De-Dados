package exercicios;

import java.util.Arrays;

public class CountingSort2 {
	public static void main(String[] args) {
		CountingSort2 cs = new CountingSort2();
		int[] a = {1, 9, 1, 3, 4, 7, 6, 7};
		int[] b = {1, 9, 0, 3, 4, 7, 6, 7};
		int[] c = {-2, 1, 9, 0, 3, 4, 7, 6, 7};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(cs.classicCountingSort(a, 9)));
		System.out.println(Arrays.toString(cs.zeroCountingSort(b, 9)));
		System.out.println(Arrays.toString(cs.negativosCountingSort(c, 9)));
	}
    /**
    * Implemente a versão clássica do counting sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public int[] classicCountingSort(int[] a, int k) {
    	int[] b = new int[k];
    	
    	for(int i = 0; i < a.length; i++) {
    		b[a[i] - 1] += 1;
    	}
    	
    	for(int i = 1; i < b.length; i++) {
    		b[i] += b[i - 1];
    	}
    	
    	int[] c = new int[a.length];
    	for(int i = a.length - 1; i >= 0; i--) {
    		c[b[a[i] - 1] - 1] = a[i];
    		b[a[i] - 1] -= 1;
    	}
    	
    	return c;
    }

    /**
    * Implemente uma versão do counting sort que aceita valor 0 na coleção original.
    */
    public int[] zeroCountingSort(int[] v, int k) {
    	int[] b = new int[k+1];
    	
    	for(int i = 0; i < v.length; i++) {
    		b[v[i]] += 1;
    	}
    	
    	for(int i = 1; i < b.length; i++) {
    		b[i] += b[i - 1];
    	}
    	
    	int[] c = new int[v.length];
    	for(int i = v.length - 1; i >= 0; i--) {
    		c[b[v[i]] - 1] = v[i];
    		b[v[i]] -= 1;
    	}
        // TODO implementar
        return c;
    }

    /**
    * Implemente uma versão do counting sort que aceita valores negativos na coleção original. Você
    * vai precisar identificar o menor elemento do array. FAça isso no início do método.
    */
    public int[] negativosCountingSort(int[] v, int k) {
    	int menor = v[0];
    	for(int i = 1; i < v.length; i++) {
    		if(v[i] < menor) {
    			menor = v[i];
    		}
    	}
        
    	int[] b = new int[k + 1 + Math.abs(menor)];
    	for(int i = 0; i < v.length; i++) {
    		b[v[i] + 2] += 1;
    	}
    	
    	for(int i = 1; i < b.length; i++) {
    		b[i] += b[i-1];
    	}
    	
    	int[] c = new int[v.length];
    	for(int i = v.length - 1; i >= 0; i--) {
    		c[b[v[i] + 2] - 1] = v[i];
    		b[v[i] + 2] -= 1;
    	}
        return c;
    }

}