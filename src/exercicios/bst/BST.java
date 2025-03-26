package exercicios.bst;

public class BST {

    private Node root;
    
    /**
     * Função externa para adicioção de um elemento na BST
     * @param value Valor do elemento
     */
    public void add(int value){
        Node newNode = new Node(value);
        addNode(newNode);
        
    }

    /**
     * Função interna para adição com acesso ao nó. 
     * @param newNode Nó a ser adicionado.
     */
    private void addNode(Node newNode){
        
        if (isEmpty()) { // Se a arvore estiver vázia, apenas adiciona no início
            this.root = (newNode);
            return;
        }

        Node auxNode = this.root;
        while (true) {  
            if (newNode.value < auxNode.value){      // Verifica se o valor do nó atual é maior do que o novo nó.  
                if (auxNode.left == null){   // Se o nó a esquerda for nulo, adiciona o novo nó
                    auxNode.left = newNode;  
                    newNode.parent = auxNode;
                    break;
                }

                auxNode = auxNode.left;     // Se o nó a esquerda não for nulo, repete o algoritmo para ele.
            } else {
                if (auxNode.rigth == null) {  // Mesmo processo para a direita.
                    auxNode.rigth = newNode;
                    newNode.parent = auxNode;
                    break;
                }

                auxNode = auxNode.rigth;
            }
        }
    }

    private Node remove(Node remNode){
        if(remNode.getGrau() == 2) {

        }
    }
    
    public int remove(int value){
        Node node = new Node(value);
        return remove(node).value;
    }

    public int search(int value){
        Node node = new Node(value);
        return search(node).value;
    }
    
    private Node search(Node node){
        if (isEmpty()) throw new RuntimeException("Empty BST");

        Node auxNode = this.root;

        while (auxNode != null){
            if (node.equals(auxNode)) return auxNode;
            if (node.value < auxNode.value) {
                auxNode = auxNode.left;
            } else {
                auxNode = auxNode.rigth;
            }
        }
        
        return auxNode;
    }

    public Node sucessor(Node node){
        if (node.rigth != null){
            return min(node.rigth);
        } else {
            Node auxNode = node.parent;

            while(auxNode != null && auxNode.value < node.value){
                auxNode = auxNode.parent;
            }

            return auxNode;
        }
    }

    public Node preDescessor(Node node){

    } 

    private Node min(Node node){
        if (node.left == null) return node;
        else return min(node.left);
    }

    public Node min(){
        if (isEmpty()) return null;
        return min(this.root);
    }

    private Node max(Node node){
        if (node.rigth == null) return node;
        else return max(node);
    }

    public Node max(){
        if(isEmpty()) return null;
        return max(this.root);
    }
    
    public boolean isEmpty(){
        return root == null;
    }
}

class Node {

    Node parent;
    Node rigth;
    Node left;
    int value;
    
    Node(int value){
        this.value = value;
    }
    
    public boolean isLeaf(){
        return rigth == null && left == null;
    }
    
    public boolean equals(Node node){
        return node.value == this.value;
    }
    
    public int getGrau(){
        int count = 0;
        if (rigth != null) count++;
        if (left != null) count++;
        return count;
    }
}
