package exercicios;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class EncontraPrimeiroNegativo {
	
	public static void main(String[] args) {
		EncontraPrimeiroNegativo primeiroNegativo = new EncontraPrimeiroNegativo();
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		sc.close();
		String[] listaStr = entrada.split(" ");
		List<Integer> listaInt = new ArrayList<Integer>();
		for (String e: listaStr) {
			if(e != "") {
				listaInt.add(Integer.parseInt(e));
			}
		}
		System.out.println(primeiroNegativo.EncontraPrimeiroNegativoRecursivo(listaInt));
	}
	
	public String EncontraPrimeiroNegativoRecursivo(List<Integer> numeros) {
		if (numeros.isEmpty()) {
			return "-";
		}
		if (numeros.get(0) < 0){
			return Integer.toString(numeros.get(0));
		}
		if (numeros.size() == 1) {
			return "-";
		}
		return EncontraPrimeiroNegativoRecursivo(numeros.subList(1, numeros.size()));
	}
}
