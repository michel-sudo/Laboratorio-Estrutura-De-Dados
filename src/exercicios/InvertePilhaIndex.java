package exercicios;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InvertePilhaIndex {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int numElements = sc.nextInt();
        String[] arrayStrings = sc.nextLine().split(" ");
        int index = sc.nextInt();
        sc.close();

        ArrayDeque<Integer> arrayInt = new ArrayDeque<Integer>(numElements);
        
        for(int i = 0; i < numElements; i++){
            arrayInt.push(Integer.parseInt(arrayStrings[i]));
        }

        System.out.println("-");

        ArrayDeque<Integer> pilhaInvertida = invertePilhaIndex(numElements, arrayInt, index);
        for(int i = 0; i < numElements; i++){
            System.out.println(pilhaInvertida.pop());
        }
    }

    public static ArrayDeque<Integer> invertePilhaIndex(int numElements, ArrayDeque<Integer> arrayInt, int index){
        ArrayDeque<Integer> auxFila = new ArrayDeque<Integer>(numElements);
        
        for(int i = 0; i < index + 1; i++){
            auxFila.addLast(arrayInt.pop());
        }

        for(int i = 0; i < index + 1; i++){
            arrayInt.push(auxFila.removeFirst());
        }

        return arrayInt;
    }

    
}
