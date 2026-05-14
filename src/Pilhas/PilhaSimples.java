package Pilhas;

public class PilhaSimples {
    String[] pilha;
    int topo = -1;

    public PilhaSimples(int tamanho){
        this.pilha = new String[tamanho];
        System.out.println("Pilha criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    public void empilhar(String elemento){
        if (elemento == null){
            System.out.println("Elemento inválido.");
        } else if (this.estaCheia()) {
            System.out.println("A pilha está cheia.");
        } else {
            topo++;
            this.pilha[topo] = elemento;
            System.out.println("O elemento " + elemento + " foi empilhado.");
        }
    }

    private boolean estaCheia() {
        if (topo == pilha.length - 1) {
            System.out.println("Não há mais espaço disponível na pilha.");
            return true;
        }
        return false;
    }

    private boolean estaVazia() {
        if (this.topo == -1) {
            return true;
        }
        return false;
    }

    public void exibir(){
        for (int i = topo; i >= 0; i--){
            System.out.println(this.pilha[i]);
        }
    }

    public void desempilhar(){
        if (this.estaVazia()) {
            System.out.println("A pilha já está vazia.");
        } else {
            System.out.println("\nO elemento " + pilha[this.topo] + " foi desempilhado." );
            this.pilha[this.topo] = null;
            topo--;
        }
    }
}