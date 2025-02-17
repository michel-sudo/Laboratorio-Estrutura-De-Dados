package exercicios;
import java.util.HashSet;

public class SomaPares {
	public static void main(String[] args) {
		SomaPares sp = new SomaPares();
		int[] array = {1, 2, 3, 4, 5};
		System.out.println(sp.somaParesOtimizado(array, 8));
		System.out.println(sp.somaPares(array, 8));
		
	}
	
	public boolean somaPares(int[] v, int alvo) {
		for(int i = 0; i < v.length; i++) {
			for(int j = i + 1; j < v.length; j++) {
				if(v[i] + v[j] == alvo) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean somaParesOtimizado(int[] v, int alvo) {
		HashSet<Integer> visitado = new HashSet<Integer>();
		for(int num: v) {
			int complemento = alvo - num;
			if(visitado.contains(complemento)) {
				return true;
			}
			visitado.add(num);
		}
		return false;
	}
}
