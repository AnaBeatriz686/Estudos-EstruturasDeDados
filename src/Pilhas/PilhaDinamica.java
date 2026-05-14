package Pilhas;

public class PilhaDinamica {
    No inicio;

    public PilhaDinamica() {
        this.inicio = null;
        System.out.println("Pilha dinâmica criada com sucesso!");
    }

    public void empilhar(String elemento) {
        if (elemento == null) {
            System.out.println("Elemento inválido.");
        } else {
            No novo = new No(elemento);
            novo.prox  = this.inicio;
            this.inicio = novo;
            System.out.println("O elemento " + elemento + " foi empilhado.");
        }
    }

    private boolean estaVazia() {
        if (this.inicio == null) {
            System.out.println("A pilha está vazia.");
            return true;
        } else {
            return false;
        }
    }

    public void exibir() {
        if (!estaVazia()) {
            No aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    public void desempilhar() {
        if (estaVazia()) {
            System.out.println("A pilha já está vazia.");
        } else {
            No removido = this.inicio;
            inicio = inicio.getProx();
            System.out.println("\nO elemento " + removido.getConteudo() + " foi desempilhado!.");

        }

    }
}
