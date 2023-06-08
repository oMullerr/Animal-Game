package AnimalGame;

public class Node {
    private final Node pai;
    private Node filhoEsquerda;
    private Node filhoDireita;
    private Pergunta pergunta;
    private Animal animal;
    public Node(Node pai, Animal animal, Node filhoDireita, Node filhoEsquerda){
        this.pai = pai;
        this.filhoDireita = filhoDireita;
        this.filhoEsquerda = filhoEsquerda;
        this.animal = animal;
    }
    public void setPergunta(Pergunta pergunta){
        this.pergunta = pergunta;
    }
    public void setFilhoDireita(Node node){
        this.filhoDireita = node;
    }
    public void setFilhoEsquerda(Node node){
        this.filhoEsquerda = node;
    }
    public Node getFilhoEsquerda() {
        return filhoEsquerda;
    }
    public Node getFilhoDireita() {
        return filhoDireita;
    }
    public Pergunta getPergunta(){
        return pergunta;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}