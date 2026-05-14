package Sorts;

public class ListaDinamica {
    NoInteiro inicio;

    public ListaDinamica() {
        this.inicio = null;
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(int elemento) { //
        if (inicioEstaVazio()) {
            this.inicio = new NoInteiro(elemento);
        } else {
            NoInteiro aux = this.inicio;
            NoInteiro novoNo = new NoInteiro(elemento);
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            novoNo.setAnterior(aux);
            aux.setProx(novoNo);
        }
    }

    public void exibir() { //
        if (inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            NoInteiro aux = this.inicio;

            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    public void exibirAnterior(ListaDinamica lista) {
        if (inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            NoInteiro aux = this.inicio;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getAnterior();
            }
        }
    }

    private boolean inicioEstaVazio() {
        return this.inicio == null;
    }

    public void removerElemento(int elemento) { //
        if (inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
        } else {
            if (procurarElemento(elemento)) {
                //remover primeiro elemento isolado
                if (this.inicio.getProx() == null) {
                    System.out.println("Elemento " + elemento + " removido!");
                    this.inicio.setConteudo(null);
                }
                //remover qualquer nó conectado
                else if (this.inicio.getProx() != null) {
                    NoInteiro aux = this.inicio;
                    while (aux != null) {
                        if (this.inicio.getConteudo() == elemento) {
                            System.out.println("Elemento " + elemento + " removido!");
                            this.inicio = this.inicio.getProx();
                            this.inicio.setAnterior(null);
                            return;
                        } else if (aux.getProx().getConteudo() == elemento) {
                            System.out.println("Elemento " + elemento + " removido!");
                            aux.getProx().setAnterior(null);
                            if (aux.getProx().getProx() != null) {
                                aux.getProx().getProx().setAnterior(aux);
                                aux.setProx(aux.getProx().getProx());
                            } else {
                                aux.setProx(aux.getProx().getProx());
                            }
                            return;
                        }
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public boolean procurarElemento(int elemento) {
        if (inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
        } else {
            NoInteiro aux = this.inicio;
            while (aux != null) {
                if (aux.getConteudo() == elemento) {
                    System.out.println("Elemento " + elemento + " encontrado!");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento " + elemento + " não existe na lista.");
        }
        return false;
    }

    public void insertionSort() {
        if (inicioEstaVazio()) {
            System.out.println("Não há o que ordenar pois a lista está vazia!");
        } else if (this.inicio.getProx() == null) {
            System.out.println("Só há um elemento na lista, não há o que ordenar!");
        } else {
            NoInteiro aux = this.inicio;
            while (aux.getProx() != null) {
                aux = aux.getProx();
                while (aux.getAnterior() != null && aux.getAnterior().getConteudo() > aux.getConteudo()) {
                    int menorNumero = aux.getConteudo();
                    aux.setConteudo(aux.getAnterior().getConteudo());
                    aux.getAnterior().setConteudo(menorNumero);
                    aux = aux.getAnterior();
                }
            }
        }
        exibir();
    }


/* Prevencão de quebra de código
        } else if (this.inicio.getProx().getProx() == null) {
            NoInteiro aux = this.inicio.getProx();
            if (aux.getConteudo() < aux.getAnterior().getConteudo()) {
                int menorNumero = aux.getConteudo();
                aux.setConteudo(aux.getAnterior().getConteudo());
                aux.getAnterior().setConteudo(menorNumero);
            }
 */

    public void selectionSort(){
        if (inicioEstaVazio()) {
            System.out.println("Não há o que ordenar pois a lista está vazia!");
        } else if (this.inicio.getProx() == null) {
            System.out.println("Só há um elemento na lista, não há o que ordenar!");
        } else {
            NoInteiro aux = this.inicio;

            while(aux != null) {
                NoInteiro aux2 = aux.getProx();
                NoInteiro menorNumero = aux;
                int valorAux = aux.getConteudo();
                while (aux2 != null) {
                    if(menorNumero.getConteudo() > aux2.getConteudo()){
                        menorNumero = aux2;
                    }
                    aux2 = aux2.getProx();
                }
                aux.setConteudo(menorNumero.getConteudo());
                menorNumero.setConteudo(valorAux);
                aux = aux.getProx();
            }
        }
        exibir();
    }
}