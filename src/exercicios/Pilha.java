package exercicios;

public class Pilha {
	
	private static int DEFAULT_CAPACITY;
	private int[] stack;
	private int top;

    public Pilha(int capacidade) {
        this.stack = new int[capacidade];
        this.top = -1;
    }
    
    public Pilha() {
    	this.stack = new int[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == stack.length - 1;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull()) throw new RuntimeException("Full Stack!");
        this.stack[++top] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty()) throw new RuntimeException("Empty Stack!");
        int v = this.stack[top--];
        return v;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
    	if(isEmpty()) throw new RuntimeException("Empty Stack!");
        return this.stack[top];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
    	String text = "";
    	Pilha aux = new Pilha(top + 1);
    	int element = this.pop();
    	text += Integer.toString(element);
    	aux.push(element);
    	while(!aux.isFull()) {
    		element = this.pop();
    		aux.push(element);
    		text += ", " + Integer.toString(element);
    	}
    	
    	while(!aux.isEmpty()) {
    		this.push(aux.pop());
    	}
        return text;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
    	Pilha aux = new Pilha(this.top + 1);
    	int element = this.pop();
    	int index = 0;
    	while(this.top > -1 && element != valor) {
    		element = this.pop();
    		index++;
    		aux.push(element);
    	}
    	
    	while(!aux.isEmpty()) {
    		this.push(aux.pop());
    	}
        return index;
    }

    public int size() {
        return this.top + 1;
    }

}

