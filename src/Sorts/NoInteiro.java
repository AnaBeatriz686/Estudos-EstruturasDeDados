package Sorts;

public class NoInteiro {
    Integer conteudo;
    NoInteiro prox;
    NoInteiro anterior;

    public NoInteiro(Integer conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
        this.anterior = null;
    }

    public NoInteiro getProx() {
        return prox;
    }

    public void setProx(NoInteiro prox) {
        this.prox = prox;
    }

    public NoInteiro getAnterior() {
        return anterior;
    }

    public void setAnterior(NoInteiro anterior) {
        this.anterior = anterior;
    }

    public int getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }
}