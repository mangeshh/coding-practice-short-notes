public class FireCodeSelectionSort {

    public static int[] selectionSortArray(int[] arr){

        for(int i =0 ; i < (arr.length - 1) ; i++){
            int minIndex = -1;
            int min = arr[i];

            for(int j = i + 1; j < arr.length ; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }

            if(minIndex > 0){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {4,12,4,78,7,-1};
         selectionSortArray(arr);
    }
}
