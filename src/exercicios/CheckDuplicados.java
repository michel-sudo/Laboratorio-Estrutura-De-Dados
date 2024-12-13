package exercicios;
import java.util.Scanner;
import java.util.HashSet;

public class CheckDuplicados {
    
    public static void main(String[] args){ 	
    	CheckDuplicados check = new CheckDuplicados();
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();
        int[] entradaInt = new int[entrada.length];
        int i = 0;
        for(String e: entrada){
            entradaInt[i] = Integer.parseInt(e);
        }
        check.checkDuplicadosSemMemoriaAuxiliar(entradaInt);
        check.checkDuplicadosComMemoriaAuxiliar(entradaInt);
    }

    public boolean checkDuplicadosSemMemoriaAuxiliar(int[] v) {
        for(int i = 0; i < v.length; i++){
            for(int j = i + 1; j < v.length; j++){
                if(v[i] == v[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDuplicadosComMemoriaAuxiliar(int[] v) {
        HashSet<Integer> conjunto = new HashSet<Integer>();
        for(int i = 0; i < v.length; i++){
            if(conjunto.contains(v[i])){
                return true;
            }
            conjunto.add(v[i]);
        }
        return false;
    }

}
