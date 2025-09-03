package model;
public interface SortObserver {
    void aoComparar(int indice1, int indice2);
    void aoTrocar(int indice1, int indice2);
    void aoConcluir(long totalComparacoes, long totalTrocas);
}
