package Pilhas;

public class MainPilhaSimples {
    public static void main(String[] args) {
        PilhaSimples pilhaSimples = new PilhaSimples(5);

        pilhaSimples.desempilhar();
        pilhaSimples.empilhar("Arroz");
        pilhaSimples.empilhar("Feijão");
        pilhaSimples.empilhar("Macarrão");
        pilhaSimples.empilhar("Peixe");
        pilhaSimples.empilhar("Frango");
        pilhaSimples.empilhar("Batata");
        pilhaSimples.exibir();
        System.out.println("\n===========================================");
        pilhaSimples.desempilhar();
        pilhaSimples.exibir();
        pilhaSimples.desempilhar();
        pilhaSimples.exibir();
        pilhaSimples.desempilhar();
        pilhaSimples.exibir();
        pilhaSimples.desempilhar();
        pilhaSimples.exibir();
        pilhaSimples.desempilhar();
        pilhaSimples.exibir();

    }
}
