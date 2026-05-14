package Generics;

public class No {
    String conteudo;
    Filas.No prox;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
    }
    public Filas.No getProx() {
        return prox;
    }

    public void setProx(Filas.No prox) {
        this.prox = prox;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}