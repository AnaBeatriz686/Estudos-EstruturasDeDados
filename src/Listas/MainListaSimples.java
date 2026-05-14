package Listas;

public class MainListaSimples {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        System.out.println("======================================");
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Sabão em Pó");
        listaSimples.adicionarElemento("Papel Higiênico");
        listaSimples.adicionarElemento("Óleo");
        System.out.println("======================================");
        listaSimples.buscarElemento("Óleo");
        listaSimples.removerElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.exibirElementos();
        System.out.println("======================================");
        listaSimples.adicionarElemento("Arroz");
        listaSimples.removerTodas("Arroz");
        listaSimples.exibirElementos();
        System.out.println("A lista possui " + listaSimples.contar() + " elementos.");
        System.out.println("======================================");
        listaSimples.inserir(1, "Tomate");
        listaSimples.inserir(-1, "Abóbora");
        listaSimples.inserir(2, null);
        listaSimples.exibirElementos();
        System.out.println("======================================");
        listaSimples.inserir(3, "Repolho");
        listaSimples.exibirElementos();
        System.out.println("======================================");
        listaSimples.adicionarVarios(null);
        String[] alimentos = {"Macarrão", "Farinha", "Alface"};
        listaSimples.adicionarVarios(alimentos);
        listaSimples.exibirElementos();
        listaSimples.obter(4);
        listaSimples.obter(-1);
        listaSimples.obter(2);
        System.out.println("======================================");
        listaSimples.removerPorIndice(-1);
        listaSimples.removerPorIndice(2);
        listaSimples.exibirElementos();
        System.out.println("======================================");
        listaSimples.limpar();
        listaSimples.exibirElementos();
        listaSimples.limpar();
        System.out.println("======================================");
        listaSimples.exibirElementos();
        System.out.println("Elementos adicionados: ");
        String[] alimentos2 = {"Refrigerante", "Pasta de Amendoim", "Refrigerante", "Peixe"};
        listaSimples.adicionarVarios(alimentos2);
        listaSimples.exibirElementos();
        listaSimples.ultimoIndiceDe(null);
        listaSimples.ultimoIndiceDe("Refrigerante");
        listaSimples.ultimoIndiceDe("Tomate");
        listaSimples.contarOcorrencias("Refrigerante");
        System.out.println("======================================");
        listaSimples.exibirElementos();
        listaSimples.substituir("Refrigerante", "Energético");
        listaSimples.exibirElementos();
        System.out.println("======================================");

    }
}