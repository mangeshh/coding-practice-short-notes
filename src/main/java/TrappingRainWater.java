public class TrappingRainWater {

    public static void main(String[] args) {
        int[] heights = {1, 2, 4, 0, 1, 5, 2, 1, 3};
        //System.out.println(bruteForce(heights));
        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxleft = 0, maxright = 0;
        int result = 0;
        System.out.print("[");
        for(int i=0; i < height.length; i++){
            if(i==height.length-1)
            System.out.print(height[i]);
            else System.out.print(height[i] +",");
        }
        System.out.println("]");
        while (left <= right) {
            System.out.println(">> left " + left + " right " + right);
            if (height[left] < height[right]) {
                System.out.println("[MIN:LEFT < RIGHT] : height[left("+left+")] " + height[left] + " & " + " height[("+right+")] " + height[right] + " & maxleft " + maxleft);
                if (height[left] >= maxleft) {
                    System.out.println("height[left("+left+")] >= maxleft  meaning " + height[left] + " >= " + maxleft);
                    maxleft = height[left];
                    System.out.println("so maxleft is now " + maxleft);
                } else {
                    System.out.println("height[("+left+")] < maxleft meaning " + height[left] + " < " + maxleft);
                    System.out.println("old result " + result);
                    result += maxleft - height[left];
                    System.out.println("----> result is [result+maxleft-height[left]]" + result);

                }
                left++;
                System.out.println("increased left by 1 so : "+ left );
            } else {
                System.out.println("[MIN:RIGHT < LEFT] : height[("+right+")] >= maxright meaning " + height[right] + " >= " + maxright);
                if (height[right] >= maxright) {
                    System.out.println("height[("+right+")] >= maxright meaning " + height[right] + " >= " + maxright);
                    maxright = height[right];
                    System.out.println("so maxright is now " + maxright);

                }

                else {
                    System.out.println("height[("+right+")] < maxright meaning " + height[right] + " < " + maxright);
                    System.out.println("old result " + result);
                    result += maxright - height[right];
                    System.out.println("----> result is [result+maxright-height[right]] " + result);
                }
                right--;
                System.out.println("decreased right by 1 so : "+ right);

            }
        }
        return result;
    }

    public static int bruteForce(int[] heights) {
        int result = 0, maxleft = 0, maxright = 0;
        int size = heights.length;
        for (int i = 1; i < size - 1; i++) {
            System.out.println("we are referring  " + heights[i] + " at index " + i);
            maxleft = 0;
            maxright = 0;
            for (int j = i; j >= 0; j--) {
                maxleft = Math.max(maxleft, heights[j]);
            }
            for (int j = i; j < size - 1; j++) {
                maxright = Math.max(maxright, heights[j]);
            }
            System.out.println("getting between " + Math.min(maxleft, maxright) + " and " + heights[i]);
            result += Math.min(maxleft, maxright) - heights[i];
            System.out.println("result is " + result);
        }

        return result;
    }

}