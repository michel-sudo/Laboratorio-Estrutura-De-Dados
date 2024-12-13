package faculdade;
import java.util.Scanner;

public class EncontraQuebraRecursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EncontraQuebraRecursivo eqr = new EncontraQuebraRecursivo();
		String[] entrada = sc.nextLine().split(" ");
		int[] listaInt = new int[entrada.length];
		int i = 0;
		for (String e: entrada) {
			listaInt[i] = Integer.parseInt(entrada[i]);
			i++;
		}
		System.out.println(eqr.encontraQuebraRecursivo(listaInt, 0));
	}
	
	public int encontraQuebraRecursivo(int[] lista, int index) {
		if (index == lista.length - 1) {
			return -1;
		}
		if (lista[index] > lista[index + 1]) {
			return index + 1;
		}
		index++;
		return encontraQuebraRecursivo(lista, index);
	}

}
