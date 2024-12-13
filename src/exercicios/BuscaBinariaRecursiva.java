package exercicios;
import java.util.Scanner;

public class BuscaBinariaRecursiva {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BuscaBinariaRecursiva bb = new BuscaBinariaRecursiva();
		String[] entrada = sc.nextLine().split(" ");
		int num = sc.nextInt();
		int[] lista = new int[entrada.length];
		int i = 0;
		for (String e: entrada) {
			lista[i] = Integer.parseInt(e);
			i++;
		}
		System.out.println(bb.buscaBinariaRecursiva(lista, num, 0, lista.length - 1));
	}
	
	public int buscaBinariaRecursiva(int[] lista, int num, int inicio, int fim) {
		int meio = (fim - inicio)/2 + inicio;
		if (inicio >= fim) {
			return -1;
		}
		if (lista[meio] == num) {
			System.out.println(meio);
			return meio;
		}
		if (num < lista[meio]) {
			System.out.println(meio);
			return buscaBinariaRecursiva(lista, num, inicio, meio - 1);
		}
		else {
			System.out.println(meio);
			return buscaBinariaRecursiva(lista, num, meio + 1, fim);
		}
	}
}
