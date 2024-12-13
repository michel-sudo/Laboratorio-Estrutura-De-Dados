package exercicios;
import java.util.Scanner;

public class PotenciaRecursiva {
	public static void main(String[] args) {
		PotenciaRecursiva pr = new PotenciaRecursiva();
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int potencia = sc.nextInt();
		if (potencia == 0 ){
			System.out.println(1);
		} else {
			System.out.println(pr.potenciaRecursiva(base, potencia));
		}
	}
	
	public int potenciaRecursiva(int base, int potencia) {
		if (potencia == 0) {
			return 1;
		} 
		if (potencia < 0) {
			return base * 1/potenciaRecursiva(base, -potencia);
		}
		return base * potenciaRecursiva(base, potencia - 1);
	}
}
