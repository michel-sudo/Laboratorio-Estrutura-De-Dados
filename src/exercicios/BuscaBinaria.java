package exercicios;

public class BuscaBinaria {

	public int BuscaBinariaRecursiva(int[] v, int ini, int fim, int chave) {
        // TODO implementar
		int meio = ini + (fim - ini) / 2;
	
		if (ini >= fim) 
			return -1;

		if (v[meio] == chave)
			return meio;

		if (v[meio] < chave) 
			BuscaBinariaRecursiva(v, meio + 1, fim, chave);
		else
			BuscaBinariaRecursiva(v, ini, meio - 1, chave);
		return meio;
	}
    
	public int buscaBinariaIterativa(int[] v, int chave) {
        	int inicio = 0, fim = v.length - 1;

        	while (inicio <= fim) {
            		int meio = inicio + (fim - inicio) / 2;

            		if (v[meio] == chave)
                		return meio;

            		if (v[meio] < chave)
                		inicio = meio + 1;
            		else
                		fim = meio - 1;
        	}

        	return -1;
	}

}
