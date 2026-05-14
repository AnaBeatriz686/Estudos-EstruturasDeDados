package Listas;

public class MainListaDinamica {
    public static void main(String[] args) {

        ListaDinamica listaDinamica = new ListaDinamica();

        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Batata");
        listaDinamica.adicionarElemento("Alho");
        listaDinamica.adicionarElemento("Cebola");
        listaDinamica.removerElemento("Alho");
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.exibir();

        System.out.println("======================================");

        listaDinamica.exibir();
        listaDinamica.removerTodas("Arroz");
        listaDinamica.exibir();

        System.out.println("======================================");

        listaDinamica.exibir();
        System.out.println("A lista possui " + listaDinamica.contar() + " elementos.");

        System.out.println("======================================");

        String[] alimentos = {"Pepino", "Repolho", "Tomate", "Banana"};
        listaDinamica.adicionarVarios(alimentos);
        listaDinamica.exibir();
        listaDinamica.obter(4);

        System.out.println("======================================");

        listaDinamica.inserir(4, "Maionese");
        listaDinamica.exibir();
        System.out.println("O elemento " + listaDinamica.removerPorIndice(1) + " foi removido.");
        listaDinamica.exibir();

        System.out.println("======================================");

        listaDinamica.exibir();
        listaDinamica.limpar();
        listaDinamica.exibir();

        System.out.println("======================================");

        listaDinamica.adicionarElemento("Tomate");
        listaDinamica.adicionarElemento("Pepino");
        listaDinamica.adicionarElemento("Macarrão");
        listaDinamica.adicionarElemento("Pepino");
        listaDinamica.exibir();
        listaDinamica.ultimoIndiceDe("Pepino");
        listaDinamica.contarOcorrencias("Pepino");

        System.out.println("======================================");

        listaDinamica.substituir("Pepino", "Abóbora");
        listaDinamica.exibir();
    }
}