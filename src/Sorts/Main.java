package Sorts;

public class Main {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();

        lista.adicionarElemento(3);
        lista.adicionarElemento(1);
        lista.adicionarElemento(2);
        lista.insertionSort();

        System.out.println("----------------");

        lista.adicionarElemento(4);
        lista.adicionarElemento(10);
        lista.adicionarElemento(5);
        lista.adicionarElemento(1);
        lista.selectionSort();


    }
}