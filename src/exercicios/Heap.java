package exercicios;

public class Heap {
    
    private int[] heap;
    private int tail;
    
    public Heap(int capacidade){
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public boolean isEmpty(){
        return tail == -1;
    }

    public void add(int value){
        if (isEmpty()) {
            this.heap[0] = value;
            tail = 0;
            return;
        }

        if (isFull()) throw new RuntimeException("Heap full!");
        
        tail += 1;
        heap[tail] = value;

        int i = tail;
        while (i > 0 && heap[i] > heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void swap(int index1, int index2){
        int aux = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = aux;
    }

    public boolean isValidIndex(int i){
        return i >= 0 && i <= tail;
    }

    public int parent(int index){
        if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
        return Math.floorDiv(index - 1, 2);
    }

    public int left(int index){
        if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
        return 2 * index + 1;
    }

    public int right(int index){
        if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
        return 2 * (index + 1);
    }

    public int remove(){
        if (isEmpty()) throw new RuntimeException("Empty heap!");
        swap(0, tail);
        tail -= 1;

    }

    public void heapfy(int index){
        if (isLeaf(index) || !isValidIndex(index)) return;

        int maxIndex = maxIndex(index, left(index), right(index));
        if(maxIndex != index){
            swap(maxIndex, index);
            heapfy(maxIndex);
        } 
    }

    public int maxIndex(int index, int left, int right){
        if(heap[index] > heap[right]){
            if(heap[index] > heap[left]) return index;
            else 
        } else {
            if(heap[index] > heap[left]){

            } else {
                return index;
            }
        }

    }

    public boolean isLeaf(int index){
        return !isValidIndex(right(index)) && !isValidIndex(left(index));
    }

    public boolean isFull(){
        return tail == heap.length - 1;
    }
}
