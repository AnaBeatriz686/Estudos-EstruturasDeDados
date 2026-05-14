package Listas;

public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String elemento) {

        if (inicioEstaVazio()) {
            this.inicio.setConteudo(elemento);
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    public void exibir() {
        if (inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;
//            while(aux != null && aux.getConteudo() != null) {
//                System.out.println(aux.getConteudo());
//                aux = aux.getProx();
//            }

            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            //System.out.println(aux.getConteudo());
        }
    }

    private boolean inicioEstaVazio() {
        if (this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void removerElemento(String elemento) {
        if (inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
        } else {
            if (procurarElemento(elemento)) {
                //remover primeiro elemento isolado
                if (this.inicio.getProx() == null) {
                    System.out.println("Elemento + " + elemento + " removido!");
                    this.inicio.setConteudo(null);
                }
                //remover qualquer nó conectado
                else if (this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    while (aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            this.inicio = this.inicio.getProx();
                            return;
                        } else if (aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento + " + elemento + " removido!");
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public boolean procurarElemento(String elemento) {
        if (inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
        } else {
            No aux = this.inicio;
            while (aux != null) {
                if (aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado!");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento " + elemento + " não existe na lista.");
        }
        return false;
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
        int contador = 0;

        if(elemento == null){
            System.out.println("Elemento invalido!");
            return contador;
        }


        if (inicioEstaVazio()) {
            System.out.println("Não há elementos na lista!");
        }else{
            if(procurarElemento(elemento)){
                No aux = this.inicio;
                No anterior = null;

                if(aux.getConteudo().equals(elemento) && aux.getProx() == null){
                    inicio.setConteudo(null);
                    System.out.println("Elemento: " + elemento + " removido!");
                    contador ++;
                }else {
                    if(aux.getConteudo().equals(elemento) && aux.getProx() != null){
                        inicio = inicio.getProx();
                        contador++;
                    }
                    while ( aux != null) {
                        if (aux.getProx()!= null && aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx()) ;
                            contador++;

                        } else {
                            anterior = aux;
                            aux = aux.getProx();
                        }
                    }
                    return contador;
                }

            }else{
                System.out.println("Elemento não encontrado!");
                return contador;
            }
        }
        return contador;
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
        if (inicioEstaVazio()) {
            System.out.println("Não existem elementos para serem contados!");
        } else {
            int contador = 0;
            No aux = this.inicio;
            while (aux != null) {
                contador++;
                aux = aux.getProx();
            }
            return contador;
        }
        return 0;
    }

    /**
     * Adiciona múltiplos elementos à lista.
     *
     * No caso da lista baseada em vetor, deve respeitar o limite
     * de capacidade. Caso não haja espaço suficiente, apenas os
     * elementos possíveis deverão ser adicionados.
     *
     * @param elementos Vetor de Strings contendo os elementos a serem adicionados.
     * @return Quantidade de elementos que foram realmente adicionados.
     */

    @Override
    public int adicionarVarios(String[] elementos) {
        int qtdElementosAdd = 0 ;

        if(inicioEstaVazio()) {
            inicio = new No(elementos [0]);
            No aux = this.inicio;
            qtdElementosAdd++;

            for(int i = 1; i < elementos.length; i++) {
                No novosNos = new No(elementos[i]);
                aux.setProx(novosNos);
                aux = novosNos;
                qtdElementosAdd++;
            }
        } else {
            No aux = this.inicio;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            for (int i = 0; i < elementos.length; i++) {
                No novosNos = new No(elementos[i]);
                aux.setProx(novosNos);
                aux = novosNos;
                qtdElementosAdd++;
            }
            return qtdElementosAdd;
        }
        return qtdElementosAdd;
    }

    /**
     * Retorna o elemento armazenado em uma determinada posição da lista, no caso de uma lista dinâmica, simule um índice.
     *
     * Caso o índice seja inválido (menor que zero ou maior/igual ao tamanho),
     * a implementação pode lançar uma exceção ou retornar null,
     * conforme padrão definido no projeto.
     *
     * @param indice Posição desejada.
     * @return Elemento localizado na posição informada.
     */

    @Override
    public String obter(int indice) {
        No aux = inicio;
        if (inicioEstaVazio()){
            System.out.println("A lista está vazia.");
        } else {
            if (indice < 0) {
                System.out.println("Índice inválido.");
                return null;
            }
            for (int i = 0; i < indice; i++) {
                if (aux == null) {
                    System.out.println("Índice inválido.");
                    return null;
                } else {
                    aux = aux.getProx();
                }
            }
            if (aux == null) {
                return null;
            }
        }
        System.out.println("O elemento no índice " + indice + " é o " + aux.getConteudo());
        return aux.getConteudo();
    }

    /**
     * Insere um elemento em uma posição específica da lista.
     *
     * No caso de lista baseada em vetor, os elementos à direita devem
     * ser deslocados. Na lista dinâmica, deve-se ajustar corretamente
     * os encadeamentos entre os nós.
     *
     * @param indice Posição onde o elemento será inserido.
     * @param elemento Elemento a ser inserido.
     * @return true se a inserção foi realizada com sucesso, false caso contrário.
     */

    @Override
    public boolean inserir(int indice, String elemento) {
        No novo = new No(elemento);
        No aux  = this.inicio;
        No auxAnterior = null;

        if (elemento == null){
            System.out.println("Elemento inválido.");
            return false;
        }
        if (indice < 0){
            System.out.println("Índice inválido.");
            return false;
        }
        if (indice == 0) {
            novo.prox = inicio;
            inicio = novo;
            return true;
        }
        for (int i = 0; i < indice; i++) {
            if (aux == null) {
                return false;
            }
            auxAnterior = aux;
            aux = aux.getProx();
        }
        novo.prox = aux;
        auxAnterior.prox = novo;
        return true;
    }


    /**
     * Remove o elemento localizado em uma posição específica da lista.
     *
     * No vetor, os elementos à direita devem ser deslocados para
     * preencher o espaço. Na lista encadeada, deve-se ajustar os
     * ponteiros entre os nós.
     *
     * @param indice Posição do elemento a ser removido.
     * @return Elemento removido ou null caso o índice seja inválido.
     */

    @Override
    public String removerPorIndice(int indice) {
        String elementoRemovido;
        if (inicioEstaVazio()){
            System.out.println("Não existem elementos para remover.");
            return null;
        } else {
            No aux = inicio;
            No auxAnterior = null;
            if (indice < 0) {
                return null;
            }
            for (int i = 0; i < indice; i++) {
                auxAnterior = aux;
                aux = aux.getProx();
            }
            if (aux == null) {
                return null;
            }
            elementoRemovido = aux.getConteudo();
            if (indice == 0) {
                inicio = aux.getProx();
            } else {
                auxAnterior.setProx(aux.getProx());
            }
        }
        return elementoRemovido;
    }

    //
    //6 guardar conteúdo removido
    //
    //7 se indice == 0
    //      inicio = aux.prox
    //   senão
    //      anterior.prox = aux.prox
    //
    //8 retornar conteúdo removido

    /**
     * Remove todos os elementos da lista, deixando-a vazia.
     * No caso da lista baseada em vetor, apenas o tamanho lógico
     * deve ser resetado. Na lista dinâmica, os nós devem ser
     * desconectados para permitir a coleta de lixo.
     */

    @Override
    public void limpar() {
        if (this.inicio != null) {
            this.inicio.setConteudo(null);
            this.inicio.setProx(null);
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
        int indiceDaUltimaOcorrencia = -1;
        if(inicioEstaVazio()) {
            System.out.println("Não foi possivel achar o elemento pois a lista está vazia!");
            return -1;
        }else {
            No aux = this.inicio;
            int contadorDeIncide = 0;

            while (aux != null) {
                if (aux.getConteudo().equals(elemento)) {
                    indiceDaUltimaOcorrencia = contadorDeIncide;
                }
                aux = aux.getProx();
                contadorDeIncide++;
            }
            if (indiceDaUltimaOcorrencia == -1) {
                System.out.println("Elemento não encontrado!");
            } else {
                System.out.println("Indice da ultima ocorrencia: " + indiceDaUltimaOcorrencia);
            }
        }
        return indiceDaUltimaOcorrencia ;
    }

    /**
     * Conta quantas vezes um determinado elemento aparece na lista.
     *
     * @param elemento Elemento a ser contado.
     * @return Número de ocorrências do elemento.
     */

    @Override
    public int contarOcorrencias(String elemento) {
        int contarOcorrencias = 0;
        if (inicioEstaVazio()) {
            System.out.println("A lista está vazia!");
        } else {
            No atual = this.inicio;
            while (atual != null) {
                if (atual.getConteudo().equals(elemento)) {
                    contarOcorrencias++;
                }
                atual = atual.getProx();
            }
        }
        System.out.println("O elemento " + elemento + " aparece " + contarOcorrencias + " vezes.");
        return contarOcorrencias;
    }

    /**
     * Substitui todas as ocorrências de um elemento antigo por um novo elemento.
     * Exemplo:
     * Lista: ["Ana", "Carlos", "Ana"]
     * substituir("Ana", "Maria")
     * Resultado: ["Maria", "Carlos", "Maria"]
     *
     * @param antigo Elemento que será substituído.
     * @param novo Novo valor que substituirá o antigo.
     * @return Quantidade total de substituições realizadas.
     */

    @Override
    public int substituir(String antigo, String novo) {
        int quantidadeDeSubstituicoes = 0;

        if(inicioEstaVazio()){
            System.out.println("Não há o que substituir pois o inicio está vazio!");
        }else{
            No aux = this.inicio;
            while(aux != null ) {
                if (aux.getConteudo().equals(antigo)) {
                    aux.setConteudo(novo);
                    quantidadeDeSubstituicoes ++;
                }
                aux = aux.getProx();
            }
            if(quantidadeDeSubstituicoes == 0){
                System.out.println("Não foi encontrado o valor " + antigo + "!!");
            }
        }
        return quantidadeDeSubstituicoes;
    }
}