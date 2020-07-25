public class SolutionSortByParity {

        public static int[] sortArrayByParity(int[] A) {
            int []  B = new int [A.length];
            int left = 0;
            int right = A.length -1;
            for(int i =0 ; i < A.length ; i++){
                if(A[i] % 2 ==0){
                    B[left] = A[i];
                    left++;
                }else{
                    B[right] = A[i];
                    right--;
                }

            }
            return B;

        }

    public static void main(String[] args) {
        //    [1,0,3,5,7]
        sortArrayByParity(new int [] {3,1,2,4});
    }
}
