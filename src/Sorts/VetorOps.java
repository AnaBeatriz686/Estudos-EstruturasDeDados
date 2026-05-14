package Sorts;

import java.util.Scanner;

public class VetorOps {
    int [] vetor = new int[8];
    int aux;

    public VetorOps() {

    }
    public void preencherVetor() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.vetor.length; i++) {
            System.out.print("Vetor[" + i + "] = ");
            vetor[i] = scanner.nextInt();
        }
    }

    public void exibirVetor() {
        System.out.println("EXIBINDO Vetor:");
        for (int i = 0; i < this.vetor.length; i++) {
            System.out.println("Vetor[" + i + "] = " + vetor[i]);
        }
        System.out.println("=======");
    }

    public void bubbleSort() {
        for (int i = 0; i < this.vetor.length; i++) {
            System.out.println("Valor de i: " + i);
            for (int j = 0; j < this.vetor.length-1-i; j++) {
                System.out.println("Valor de j: " + j);
                if(this.vetor[j] > this.vetor[j+1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < this.vetor.length; i++) {
            if(this.vetor[i] < this.vetor[i-1]) {
                for (int j = i; j > 0; j--) {
                    this.aux = this.vetor[j];
                    this.vetor[j] = this.vetor[j-1];
                    this.vetor[j-1] = aux;
                    if(j == 1 || this.vetor[j-1] > this.vetor[j-2]) {
                        break;
                    }
                }
            }
        }
    }

    public void selectionSort() {
        int menor;
        int indiceMenorElemento = 0;
        for (int i = 0; i < this.vetor.length-1; i++) {
            menor = this.vetor[i];
            indiceMenorElemento = i;
            //Encontrando o menor elemento da rodada e sua posição
            for (int j = i; j < this.vetor.length; j++) {
                if(this.vetor[j] < menor) {
                    menor = this.vetor[j];
                    indiceMenorElemento = j;
                }
            }
            this.aux = this.vetor[i];
            this.vetor[i] = menor;
            this.vetor[indiceMenorElemento] = aux;
        }
    }

    public void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, meio, fim);
        }
    }

    public void merge(int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] I = new int[n1];
        int[] F = new int[n2];

        for (int i = 0; i < n1; i++)
            I[i] = this.vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            F[j] = this.vetor[meio + 1 + j];

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (I[i] <= F[j]) {
                this.vetor[k++] = I[i++];
            } else {
                this.vetor[k++] = F[j++];
            }
        }

        while (i < n1) {
            this.vetor[k++] = I[i++];
        }
        while (j < n2) {
            this.vetor[k++] = F[j++];
        }
    }

    public void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int pi = particao(inicio, fim);
            quickSort(inicio, pi - 1);
            quickSort(pi + 1, fim);
        }
    }

    public int particao(int inicio, int fim) {
        int pivo = this.vetor[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (this.vetor[j] < pivo) {
                i++;
                int aux = this.vetor[i];
                this.vetor[i] = this.vetor[j];
                this.vetor[j] = aux;
            }
        }
        int aux = this.vetor[i + 1];
        this.vetor[i + 1] = this.vetor[fim];
        this.vetor[fim] = aux;
        return i + 1;
    }
}