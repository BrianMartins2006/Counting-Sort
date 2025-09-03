package view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.BubbleSort;
import model.CountingSort;
import model.InsertionSort;
import model.Pessoa;
import model.SelectionSort;
import model.SortObserver;
import view.Console.ConsoleSortObserver;

public class Main {

	 public static Pessoa[] vetorDePessoas() {
	        return new Pessoa[]{
	            new Pessoa("João", LocalDate.of(1990, 1, 1)),
	            new Pessoa("Ana", LocalDate.of(1992, 2, 2)),
	            new Pessoa("Maria", LocalDate.of(1995, 5, 5)),
	            new Pessoa("Pedro", LocalDate.of(1993, 4, 4)),
	            new Pessoa("Lucas", LocalDate.of(1991, 6, 6)),
	            new Pessoa("Carlos", LocalDate.of(1988, 3, 3))
	        };
	    }

	    public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
	        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
	        Integer[] numeros = new Integer[linhas.size()];
	        for (int i = 0; i < linhas.size(); i++) {
	            numeros[i] = Integer.parseInt(linhas.get(i).trim());
	        }
	        return numeros;
	    }
	    public static void main(String[] args) throws Exception {
	        int tamanho;
	        long inicio, fim;
	        Scanner leia = new Scanner(System.in);
	        System.out.println("Tamanho do vetor:");
	        tamanho = leia.nextInt();
	        Integer[] vetorInteiros = new Integer[tamanho];
	        Random rand = new Random();
	        for(int i=0;i<tamanho;i++)
	            vetorInteiros[i] = rand.nextInt(100);
	        
	        // Bubble Sort
	        Integer[] vetorBubble = vetorInteiros.clone();
	        BubbleSort bubbleSort = new BubbleSort();
	        bubbleSort.setObserver(new ConsoleSortObserver());
	        inicio = System.currentTimeMillis();
	        bubbleSort.sort(vetorBubble);
	        fim = System.currentTimeMillis();
	        System.out.println("Bubble Sort Tempo em ms:" + (fim - inicio) + "\n");
	        
	        // Selection Sort
	        Integer[] vetorSelection = vetorInteiros.clone();
	        SelectionSort selectionSort = new SelectionSort();
	        selectionSort.setObserver(new ConsoleSortObserver());
	        inicio = System.currentTimeMillis();
	        selectionSort.sort(vetorSelection);
	        fim = System.currentTimeMillis();
	        System.out.println("Selection Sort Tempo em ms:" + (fim - inicio) + "\n");
	        
	        // Insertion Sort
	        Integer[] vetorInsertion = vetorInteiros.clone();
	        InsertionSort insertionSort = new InsertionSort();
	        insertionSort.setObserver(new ConsoleSortObserver());
	        inicio = System.currentTimeMillis();
	        insertionSort.sort(vetorInsertion);
	        fim = System.currentTimeMillis();
	        System.out.println("Insertion Sort Tempo em ms:" + (fim - inicio) + "\n");
	        
        // Counting Sort
        // Converter Integer[] para int[]
        int[] vetorCounting = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorCounting[i] = vetorInteiros[i];
        }
        CountingSort countingSort = new CountingSort();
        countingSort.setObserver(new ConsoleSortObserver());
        inicio = System.currentTimeMillis();
        ArrayList<Integer> sortedCounting = countingSort.countsort(vetorCounting);
        fim = System.currentTimeMillis();
        System.out.println("Counting Sort Tempo em ms:" + (fim - inicio) + "\n");

        // Opcional: imprimir resultado do Counting Sort
        System.out.println("Counting Sort resultado: " + sortedCounting);

        leia.close();
    }
}