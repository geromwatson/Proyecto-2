package sorts;

public class ShellSort {
    static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public int sort(int arr[]){
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){
                int temp = arr[i];
                int j = 0;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
                // aqui se printean los avances de las listas ordenandoce
            }           System.out.println("aqui va el proceso de la lista");
             printArray(arr);

        }

        return 0;
    }
    
    

    public static void main(String args[]){
        int arr[] = {12, 34, 54,2,23,34,346,6546,543,234,2345,23,4324,234,234,234,234,234,234,32};

        ShellSort ob = new ShellSort();
        ob.sort(arr);

        printArray(arr);
    }
}
