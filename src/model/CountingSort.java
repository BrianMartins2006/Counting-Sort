package model;

import java.util.ArrayList;

// A classe agora herda de ObservableSort
public class CountingSort extends ObservableSort<Integer> {
    public ArrayList<Integer> countsort(int arr[]) {
        int n = arr.length;

        // Encontra o maior elemento e notifica as comparações
        int maxval = 0;
        if (n > 0) {
            maxval = arr[0];
        }
        for (int i = 1; i < n; i++) {
            // Notifica a comparação para encontrar o valor máximo
            notificarComparacao(i - 1, i);
            if (arr[i] > maxval) {
                maxval = arr[i];
            }
        }

        // Cria e inicializa o array de contagem
        int[] count = new int[maxval + 1];

        // Conta a frequência de cada elemento
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Calcula a soma prefixada
        for (int i = 1; i <= maxval; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída e notifica os posicionamentos
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int originalIndex = i;
            int finalIndex = count[arr[i]] - 1;
            
            ans[finalIndex] = arr[originalIndex];
            
            // Notifica o "posicionamento" do elemento
            notificarTroca(originalIndex, finalIndex);
            
            count[arr[i]]--;
        }

        // Converte para ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : ans) {
            result.add(x);
        }

        // Notifica a conclusão
        notificarConclusao();
        
        return result;
    }
}