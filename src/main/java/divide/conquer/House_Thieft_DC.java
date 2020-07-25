package divide.conquer;

public class House_Thieft_DC {

    public int maxMoney(String level, int[] HouseNetWorth) {
        return maxMoneyRecursive(print(level), HouseNetWorth, 0);
    }//end of method

    public static String print(String level){
        return level + level;
    }

    private int maxMoneyRecursive(String level, int[] HouseNetWorth, int currentIndex) {
        if (currentIndex >= HouseNetWorth.length)
            return 0;

        System.out.println(level + currentIndex);

        int stealCurrentHouse = HouseNetWorth[currentIndex] + maxMoneyRecursive(print(level), HouseNetWorth, currentIndex + 2);
        int skipCurrentHouse = maxMoneyRecursive(print(level), HouseNetWorth, currentIndex + 1);

        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }//end of method

    public static void main(String[] args) {
        House_Thieft_DC ht = new House_Thieft_DC();
        int[] HouseNetWorth = {6, 7, 1, 30, 8, 2, 4};
        String level = "--";
        System.out.println(ht.maxMoney(level, HouseNetWorth));
        HouseNetWorth = new int[]{20, 5, 1, 13, 6, 11, 40};
        System.out.println(ht.maxMoney(level, HouseNetWorth));
    }
}// end of class