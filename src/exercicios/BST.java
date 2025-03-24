package exercicios;

import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                        
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        if (this.isEmpty()) throw new RuntimeException("Empty BST");
        Node aux = this.root;
        
        while (aux != null){
            if(aux.value == element) return aux;
            if(element < aux.value) aux = aux.left;
            if(element > aux.value) aux = aux.right;
        }

        return null;
    }
    
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    public int height(Node node){
        if(node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }


    public boolean equals(BST outra) {
        ArrayList<Integer> currentBST = this.preOrder();
        ArrayList<Integer> ottBST = outra.preOrder();
        return currentBST.equals(ottBST);
    }

    public ArrayList<Integer> preOrder(){     
        ArrayList<Integer> listBst = new ArrayList<Integer>();
        this.preOrder(this.root, listBst);
        return listBst;
    }

    private void preOrder(Node node, ArrayList<Integer> listBst){
        if(node != null) {
            listBst.add(node.value);
            preOrder(node.left, listBst);
            preOrder(node.right, listBst);
        }
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        if(isEmpty()) return -1;
        return contaRecFolha(this.root);
    }

    private int contaRecFolha(Node node) {
        if (node == null) return 0;
        if (node.isLeaf()) return 1;
        return contaRecFolha(node.left) + contaRecFolha(node.right);  
    }

    
    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }
    
    public boolean isLeaf(){
        if(left == null && right == null) return true;
        return false;
    }
}
