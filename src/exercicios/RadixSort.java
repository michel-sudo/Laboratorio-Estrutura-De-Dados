package exercicios;

import java.util.Arrays;

public class RadixSort {
	
	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int[] a = {677, 983, 421, 678, 609};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(rs.radixSort(a, 3)));
	}

	// Você pode assumir que todos os valores possuem a mesma quantidade de dígitos
	// Caso precise do counting sort, use o que você já implementou na outra classe.
	public int[] radixSort(int[] v, int digitos) {
		for(int i = 1; i <= digitos; i++) {
			v = countingSort(v, i);
		}
		
		return v;
	}
	
    public int[] countingSort(int[] v, int k) { // k inteiro referente ao digito de referencia para ordenação 
    	int maior = getMaiorIndice(v);
    	int[] arrayDecimais = getDigit(v, k);
    	
    	int[] b = new int[maior+1];
    	
    	for(int i = 0; i < v.length; i++) {
    		b[arrayDecimais[i]] += 1;
    	}
    	
    	for(int i = 1; i < b.length; i++) {
    		b[i] += b[i - 1];
    	}
    	
    	int[] c = new int[v.length];
    	for(int i = v.length - 1; i >= 0; i--) {
    		c[b[arrayDecimais[i]] - 1] = v[i];
    		b[arrayDecimais[i]] -= 1;
    	}
        // TODO implementar
        return c;
    }
    
    public int[] getDigit(int[] a, int casa) {
    	int[] novoArray = new int[a.length];
    	for(int i = 0; i < a.length; i++) {
    		novoArray[i] = (a[i] / ((int) Math.pow(10, casa - 1))) % 10;
    	}
    	return novoArray;
    }
    
    public int getMaiorIndice(int[] v) {
    	int maior = v[0];
    	for(int i = 1; i < v.length; i++) {
    		if(v[i] > maior) {
    			maior = v[i];
    		}
    	}
    	return maior;
    }

}
