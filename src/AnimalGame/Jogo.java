package AnimalGame;

import javax.swing.*;
import java.util.List;

public class Jogo {
    private Node pai;
    List<Animal> animais;

    public Jogo() {
        this.animais = iniciaAnimais();
        this.pai = new Node(null, null, new Node(pai, new Animal("Tubarão"), null, null), new Node(pai, new Animal("Macaco"), null, null));
        pai.setPergunta(new Pergunta("O animal que você pensou vive na água?"));
    }

    private List<Animal> iniciaAnimais() {
        Animal tubarao = new Animal("Tubarão");
        Animal macaco = new Animal("Macaco");
        return List.of(tubarao, macaco);
    }

    public void iniciarJogo() {

        JOptionPane.showMessageDialog(null, "Pense em um animal", "Jogo dos Animais", JOptionPane.INFORMATION_MESSAGE);

        Node no = pai;

        while (true) {
            if (no.getPergunta() != null) {
                int ret = JOptionPane.showConfirmDialog(null, no.getPergunta().getDescricao(), "Jogo do Animais", JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_OPTION) {
                    no = no.getFilhoDireita();
                } else {
                    no = no.getFilhoEsquerda();
                }
            } else {
                int ret = JOptionPane.showConfirmDialog(null, "O animal que você pensou é " + no.getAnimal().getNome(), "Jogo dos Animais", JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Acertei de novo.");
                    break;
                } else {
                    Animal animalUsuario = new Animal(JOptionPane.showInputDialog(null, "Qual o animal que você pensou?"));
                    Pergunta pergunta = new Pergunta("O animal que você pensou tem " + JOptionPane.showInputDialog(null, "Um(a) " + animalUsuario.getNome() + "______ mas um(a) " + no.getAnimal().getNome() + " não."));
                    no.setPergunta(pergunta);
                    no.setFilhoEsquerda(new Node(no, no.getAnimal(), null, null));
                    no.setFilhoDireita(new Node(no, animalUsuario, null, null));
                    no.setAnimal(null);
                    break;
                }
            }
        }
    }
}