package faculdade;
import java.util.Scanner;

public class TrocaVizinhos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TrocaVizinhos tv = new TrocaVizinhos();
		String[] entrada = sc.nextLine().split(" ");
		int[] listaInt = new int[entrada.length];
		int i = 0;
		for (String e: entrada) {
			listaInt[i] = Integer.parseInt(entrada[i]);
			i++;
		}
		tv.trocaVizinhos(listaInt);
	}
	
	public void trocaVizinhos(int[] lista){
		for (int i = 0; i < lista.length - 1; i += 2) {
			int aux = lista[i];
			lista[i] = lista[i + 1];
			lista[i + 1] = aux;
		}
		for (int e: lista) {
			System.out.print(e + " ");
		}
	}
}
