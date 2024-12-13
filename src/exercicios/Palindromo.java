package exercicios;

public class Palindromo {
	public static void main(String[] args) {
		Palindromo p = new Palindromo();
		String[] entrada = {"c", "a", "s", "a"};
		p.palindromo(entrada);
	}
	
	public void palindromo(String[] lista) {
		int j = lista.length - 1;
		for (int i = 0; i < (lista.length/2); i++) {
			String aux = lista[i];
			lista[i] = lista[j];
			lista[j] = aux;
			j--;
		}
		for (String e: lista) {
			System.out.print(e + " ");
		}
	}
}
