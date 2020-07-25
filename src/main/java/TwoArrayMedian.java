@SuppressWarnings("unused")
public class TwoArrayMedian {

    public static double findMedianSortedArrays(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2) {

        Integer medianNums1;
        int median1Index = 0;
        Integer medianNums2 = 0;
        int median2Index;
        int n1Length = e1 - s1;
        int n2Length = e2 - s2;


        if(e2 -s1 <= 3) {
            System.out.println(s1+ ", " + e1 + ", " + s2 + ", " + e2);
        }

        median1Index = (n1Length-1)/2;
        if (n1Length % 2 != 0) {
            medianNums1 = nums1[median1Index];
        } else {
            if(n1Length < 1){
                median1Index = 0;
                medianNums1 = nums2[0];
            }else{
                medianNums1 = (nums1[(n1Length)/2] + nums1[n1Length/2 - 1]) / 2;
            }
        }

        median2Index = n2Length/2;
        if (n2Length % 2 != 0) {
            medianNums2 = nums2[median2Index];
        } else {
            if(n2Length < 1){
                median2Index = 0;
            }else{
                median2Index = n2Length/2;
                medianNums2 = nums2[0];
            }

        }

        if (medianNums1 < medianNums2) {
            findMedianSortedArrays(nums1, median1Index, e1, nums2, s2, median2Index);
        } else if (medianNums2 < medianNums1) {
            findMedianSortedArrays(nums1, s1, median1Index, nums2, median2Index, e2);
        }
        System.out.println(medianNums1);
        return medianNums1;
    }

    public static void main(String[] args) {
        int nums1[] = new int[]{1, 2, 3};
        int nums2[] = new int[]{4, 5};
        findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
    }
}
