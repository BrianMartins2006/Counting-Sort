package view.Console;

import model.SortObserver;

public class ConsoleSortObserver implements SortObserver {
    @Override
    public void aoComparar(int indice1, int indice2) {
        // System.out.println("Comparando indices: " + indice1 + " com " + indice2);
    }
    @Override
    public void aoTrocar(int indice1, int indice2) {
        // System.out.println("Trocando indices: " + indice1 + " com " + indice2);
    }
    @Override
    public void aoConcluir(long totalComparacoes, long totalTrocas) {
        System.out.println("Total de comparações: " + totalComparacoes + "\nTotal de trocas: " + totalTrocas);
    }
}