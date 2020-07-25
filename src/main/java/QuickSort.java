@SuppressWarnings("unused")
public class QuickSort {

    public static void main(String[] args) {
        int [] input = new int [] {1,4,2,6,4};
        sort(input, 0, input.length-1);
        for(int i =0; i < input.length;i++){
            System.out.print(input[i] + " ");
        }
    }

    public static void swap(int[] input, int from, int to){
        int temp = input[from];
        input[from] = input[to];
        input[to] = temp;
    }

    public static void sort(int [] input, int start, int end){
        if(end > start){
            int partition = partition(input, start, end);
            sort(input, start, partition-1);
            sort(input, partition+1, end);
        }

    }

    public static int partition(int[] input, int start, int last){
        int pivot = input[last];
        int i = start -1;

        for(int j=start; j < last-1 ; j++){ //1
            if(input[j] <= pivot){
                i = i +1; //2
                swap(input, i, j);
            }
        }
        swap(input, last, i+1);
        return i+1;
    }
}
