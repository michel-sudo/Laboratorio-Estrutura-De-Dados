package exercicios;

import java.util.NoSuchElementException;

public class FIFOArray {
	private String[] array;
	private int head;
	private int tail;
	private int size;
	
	public static void main(String[] args) {
		FIFOArray fila = new FIFOArray(3);
		System.out.println(fila.toString());
		fila.addLast("a");
		System.out.println(fila.toString());
		fila.addLast("b");
		System.out.println(fila.toString());
		fila.addLast("c");
		System.out.println(fila.toString());
		fila.removeFirst();
		System.out.println(fila.toString());
		
	}
	
	public FIFOArray(int capacidade) {
		this.array = new String[capacidade];
		this.head = -1;
		this.tail = -1;
		this.size = 0;
	}
	
	public void shiftLeft(int indice) {
		for(int i = indice; i < this.tail; i++) {
			array[i] = array[i + 1];
		}
	}
	
	public void addLast(String element) {
		if(tail + 1 > array.length - 1) {
			resize(array.length * 2);
		}
		
		if(size == 0) {
			this.head = 0;
		}
		
		tail++;
		size++;
		this.array[tail] = element; 
	}
	
	public String removeFirst() {
		if(size == 0) {
			throw new NoSuchElementException("Array vazio");
		}
		
		if(this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		}
		
		String element = this.array[0];
		shiftLeft(0);
		size--;
		tail--;
		
		return element;
	}
	
	public void resize(int novaCapacidade) {
		String[] novoArray = new String[novaCapacidade];
		for(int i = 0; i < this.array.length; i++) {
			novoArray[i] = this.array[i];
		}
		this.array = novoArray;
	}
	
	public String toString() {
		if(size == 0) {
			return "";
		}
		String elemento = this.array[0];
		for(int i = 1; i <= this.tail; i++) {
			elemento = elemento + ", " + this.array[i];
		}
		
		return elemento;
	}
}
