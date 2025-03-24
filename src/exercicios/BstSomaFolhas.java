package exercicios;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BstSomaFolhas {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BST2 bst = new BST2();

        String[] in = sc.nextLine().split(" ");
        sc.close();
        
        for (int i = 0; i < in.length; i++){
            bst.add(Integer.parseInt(in[i]));
        }

        int out = bst.somaFolhas();
        System.out.println(out);
    }

}

class BST2 {
    
    private Node2 root;
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
        this.root = new Node2(element);
        else {
            
            Node2 aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node2 newNode = new Node2(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                        
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node2 newNode = new Node2(element);
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
    public Node2 search(int element) {
        if (this.isEmpty()) throw new RuntimeException("Empty BST");
        Node2 aux = this.root;
        
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

    public int height(Node2 node){
        if(node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

    
    public boolean equals(BST2 outra) {
        ArrayList<Integer> currentBST = this.preOrder();
        ArrayList<Integer> ottBST = outra.preOrder();
        return currentBST.equals(ottBST);
    }
     

    public ArrayList<Integer> preOrder(){     
        ArrayList<Integer> listBst = new ArrayList<Integer>();
        this.preOrder(this.root, listBst);
        return listBst;
    }
    
    private void preOrder(Node2 node, ArrayList<Integer> listBst){
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
    
    private int contaRecFolha(Node2 node) {
        if (node == null) return 0;
        if (node.isLeaf()) return 1;
        return contaRecFolha(node.left) + contaRecFolha(node.right);  
    }

    public int somaFolhas() {
        if (isEmpty()) return -1;
        return somaFolhasRec(root);
    }

    private int somaFolhasRec(Node2 node){
        if (node == null) return 0;
        if (node.isLeaf()) return node.value;
        return somaFolhasRec(node.left) + somaFolhasRec(node.right);
    }
    
    public ArrayList<Integer> bsfDireita(){
        Queue<Node2> fila = new ArrayDeque<Node2>();
        ArrayList<Integer> out = new ArrayList<Integer>(this.size());
        fila.add(this.root);
        
        while (!fila.isEmpty()){
            if (fila.peek().left != null) fila.add(fila.peek().left);
            if (fila.peek().right != null) fila.add(fila.peek().right);
            out.add(fila.remove().value);
        }

        return out;
    }
    
    public ArrayList<Integer> predescessor(int value){
        Node2 aux = search(value);
        return maxBst(aux);
    }

    private ArrayList<Integer> maxBst(Node2 node){
        ArrayList<Integer> listNode = new ArrayList<Integer>();
        listNode.add(node.value);
        Node2 aux = node.left;
        
        if (aux == null){
            if(node.parent == null){
                return listNode;
            } else {
                aux = node.parent;

                while (aux != null){
                    listNode.add(aux.value);
                    if (aux.value < node.value) break;
                    aux = aux.parent;
                }
            }

        } else {

            while (aux.right != null){
                listNode.add(aux.right.value);
                aux = aux.right;
            }

        }
    
    
        return listNode;
    }
    
    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node2 {
    
    int value;
    Node2 left;
    Node2 right;
    Node2 parent;
    
    Node2(int v) {
        this.value = v;
    }
    
    public boolean isLeaf(){
        if(left == null && right == null) return true;
        return false;
    }
}
