package exercicios;

public class Teste1 {

    public static void main(String[] args) {
        // Exemplo de uso
        int base = 2;
        int expoente = -3;

        int resultado = potencia(base, expoente);

        System.out.println(base + " elevado a " + expoente + " é igual a " + resultado);
    }

    /**
     * Calcula a potência de um número usando recursão.
     * 
     * @param base      A base da potência.
     * @param expoente  O expoente da potência.
     * @return O resultado de base elevado ao expoente.
     */
    public static int potencia(int base, int expoente) {
        // Caso base: qualquer número elevado a 0 é 1
        if (expoente == 0) {
            return 1;
        }
        // Caso base: expoente negativo (opcional, para suportar negativos)
        if (expoente < 0) {
            return 1 / potencia(base, -expoente); // Supondo resultado em double para bases reais.
        }
        // Chamada recursiva
        return base * potencia(base, expoente - 1);
    }
}

