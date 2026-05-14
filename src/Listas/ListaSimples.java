package Listas;

public class ListaSimples implements ListaOperacoes {
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void adicionarElemento(String elemento) {
        if (!this.estaCheia()) {
            this.lista[encontrarPosicao()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }

    public boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }

    public boolean estaVazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }

    private int encontrarPosicao() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                break;
            }
        }
        return i;
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista [" + i + "] = " + this.lista[i]);
        }
    }

    public void removerElemento(String elemento) {
        boolean removido = false;
        if (!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if (removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if (!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    /**
     * Remove TODAS as ocorrências de um determinado elemento da lista.
     * <p>
     * Exemplo:
     * Lista: ["Ana", "Carlos", "Ana", "Pedro"]
     * removerTodas("Ana")
     * Resultado: ["Carlos", "Pedro"]
     *
     * @param elemento Elemento que deverá ter todas as ocorrências removidas.
     * @return Quantidade total de elementos removidos.
     */

    @Override
    public int removerTodas(String elemento) {
        int indice = 0;
        int elementosRemovidos =0 ;

        if (estaVazia()){
            System.out.println("Não existem elementos para remover.");
            return 0;
        }
        if (elemento == null){
            System.out.println("Elemento inválido.");
            return 0;
        }

        do {
            if(lista[indice].equals(elemento)){
                lista[indice] = null;
                elementosRemovidos += 1;
            }
            indice +=1;
        } while(indice < lista.length);
        System.out.println("Elementos removidos com sucesso!");

        return elementosRemovidos;
    }

    /**
     * Retorna a quantidade total de elementos atualmente armazenados na lista.
     * <p>
     * Esse método deve considerar apenas os elementos válidos,
     * ignorando posições vazias no caso da lista baseada em vetor.
     *
     * @return Número de elementos presentes na lista.
     */

    @Override
    public int contar() {
        if (estaVazia()){
            System.out.println("Não existem elementos para serem contados.");
        }
        int indice = 0;
        int qtdTotalValida = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (lista[i] != null) {
                qtdTotalValida++;
            }
        }
        return qtdTotalValida;
    }

    /**
     * Adiciona múltiplos elementos à lista.
     * <p>
     * No caso da lista baseada em vetor, deve respeitar o limite
     * de capacidade. Caso não haja espaço suficiente, apenas os
     * elementos possíveis deverão ser adicionados.
     *
     * @param elementos Vetor de Strings contendo os elementos a serem adicionados.
     * @return Quantidade de elementos que foram realmente adicionados.
     */

    @Override
    public int adicionarVarios(String[] elementos) {
        int elementosAdicionados = 0;
        if (elementos == null) {
            System.out.println("Elemento inválido.");
            return 0;
        }
        for (int i = 0; i < elementos.length; i++) {
            if (estaCheia()) {
                break;
            }
            lista[encontrarPosicao()] = elementos[i];
            elementosAdicionados += 1;
        }
        return elementosAdicionados;
    }

    /**
     * Retorna o elemento armazenado em uma determinada posição da lista, no caso de uma lista dinâmica, simule um índice.
     * <p>
     * Caso o índice seja inválido (menor que zero ou maior/igual ao tamanho),
     * a implementação pode lançar uma exceção ou retornar null,
     * conforme padrão definido no projeto.
     *
     * @param indice Posição desejada.
     * @return Elemento localizado na posição informada.
     */

    @Override
    public String obter(int indice) {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return null;
        }
        if (indice < 0 || indice >= lista.length) {
            System.out.println("Erro! O índice inserido é inválido!");
            return null;
        }
        if (lista[indice] == null){
            System.out.println("Não existe elemento neste índice.");
            return null;
        } else {
            System.out.println("O elemento no índice "+ indice + " é o " + lista[indice] );
            return this.lista[indice];
        }
    }

    /**
     * Insere um elemento em uma posição específica da lista.
     * <p>
     * No caso de lista baseada em vetor, os elementos à direita devem
     * ser deslocados. Na lista dinâmica, deve-se ajustar corretamente
     * os encadeamentos entre os nós.
     *
     * @param indice   Posição onde o elemento será inserido.
     * @param elemento Elemento a ser inserido.
     * @return true se a inserção foi realizada com sucesso, false caso contrário.
     */

    @Override
    public boolean inserir(int indice, String elemento) {

        if (indice < 0 || indice >= lista.length) {
            System.out.println("Índice inválido.");
            return false;
        }
        if (elemento == null) {
            System.out.println("Elemento inválido.");
            return false;
        }
        if (estaCheia()) {
            System.out.println("A lista está cheia!");
            return false;
        }
        for (int i = lista.length - 1; i > indice; i--) {
            lista[i] = lista[i - 1];
        }

        lista[indice] = elemento;

        return true;
    }

    /**
     * Remove o elemento localizado em uma posição específica da lista.
     * <p>
     * No vetor, os elementos à direita devem ser deslocados para
     * preencher o espaço. Na lista encadeada, deve-se ajustar os
     * ponteiros entre os nós.
     *
     * @param indice Posição do elemento a ser removido.
     * @return Elemento removido ou null caso o índice seja inválido.
     */

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= lista.length) {
            System.out.println("Índice inválido.");
            return null;
        }
        if (lista[indice] == null) {
            System.out.println("Esse índice não tem elementos para remover.");
            return null;
        }
        String elementoRemovido = lista[indice];
        for (int i = indice; i < lista.length - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[lista.length - 1] = null;
        return elementoRemovido;
    }

    /**
     * Remove todos os elementos da lista, deixando-a vazia.
     * <p>
     * No caso da lista baseada em vetor, apenas o tamanho lógico
     * deve ser resetado. Na lista dinâmica, os nós devem ser
     * desconectados para permitir a coleta de lixo.
     */

    @Override
    public void limpar() {
        if (estaVazia()){
            System.out.println("A lista já está vazia.");
        } else {
            for (int i = 0; i < this.lista.length; i++) {
                this.lista[i] = null;
            }
        }
    }

    /**
     * Retorna o índice da última ocorrência de um elemento na lista.
     *
     * @param elemento Elemento a ser buscado.
     * @return Índice da última ocorrência ou -1 caso não exista.
     */

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (estaVazia()){
            System.out.println("A lista está vazia!");
            return -1;
        }
        if (elemento == null) {
            System.out.println("Elemento inválido");
            return -1;
        }
        for (int i = lista.length - 1; i >= 0; i--) {
            if (lista[i] != null && lista[i].equals(elemento)){
                System.out.println("A última ocorrência do elemento " + elemento + " foi no índice " + i);
                return i;
            }
        }
        System.out.println("O elemento " + elemento + " não foi encontrado.");
        return -1;
    }

    /**
     * Conta quantas vezes um determinado elemento aparece na lista.
     *
     * @param elemento Elemento a ser contado.
     * @return Número de ocorrências do elemento.
     */

    @Override
    public int contarOcorrencias(String elemento) {
        if (estaVazia()){
            System.out.println("A lista está vazia.");
            return 0;
        }
        if (elemento == null) {
            System.out.println("Elemento inválido;");
            return 0;
        }
        int indice = 0;
        int qtdOcorrencias = 0;

        do{
            if(lista[indice] != null && lista[indice].equals(elemento)){
                qtdOcorrencias += 1;
            }
            indice += 1;
        } while(indice < lista.length);

        System.out.println("O elemento " + elemento + " aparece " + qtdOcorrencias + " vezes.");
        return qtdOcorrencias;

    }

    /**
     * Substitui todas as ocorrências de um elemento antigo por um novo elemento.
     * <p>
     * Exemplo:
     * Lista: ["Ana", "Carlos", "Ana"]
     * substituir("Ana", "Maria")
     * Resultado: ["Maria", "Carlos", "Maria"]
     *
     * @param antigo Elemento que será substituído.
     * @param novo   Novo valor que substituirá o antigo.
     * @return Quantidade total de substituições realizadas.
     */

    @Override
    public int substituir(String antigo, String novo) {

        int quantidadeSubstituir = 0;
        if (estaVazia()){
            System.out.println("A lista está vazia.");
            return 0;
        }
        if (antigo == null) {
            System.out.println("O elemento a ser substituído é inválido.");
            return 0;
        }
        if (novo == null) {
            System.out.println("O elemento de substituição é inválido.");
            return 0;
        }

        for (int  i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(antigo)) {
                lista[i] = novo;
                quantidadeSubstituir += 1;

            }
        }
        System.out.println(quantidadeSubstituir + " elementos foram substituídos");
        return quantidadeSubstituir;
    }
}