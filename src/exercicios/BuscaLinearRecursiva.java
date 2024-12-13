package exercicios;
import java.util.Scanner;

public class BuscaLinearRecursiva {
	public static void main(String[] args) {
		BuscaLinearRecursiva bl = new BuscaLinearRecursiva();
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		String valor = sc.nextLine();
		String[] lista = entrada.split(" ");
		System.out.println(bl.buscaLinear(lista, 0, valor));
	}
	
	public int buscaLinear(String[] lista, int posiçao, String valor){
		if (posiçao >= lista.length) {
			return -1;
		}	
		if (valor.equals(lista[posiçao])) {
			return posiçao;
		} 
		posiçao++;
		return buscaLinear(lista, posiçao, valor);
		
	} 
}
