import java.util.Arrays;

class NumberOfWaysScore
{
    // Returns number of ways to reach score n
    static int count(int n)
    {
        // table[i] will store count of solutions for 
        // value i. 
        int table[] = new int[n + 1], i;

        // Initialize all table values as 0 
        Arrays.fill(table, 0);

        // Base case (If given value is 0) 
        table[0] = 1;

        // One by one consider given 3, moves and update the table[]
        // values after the index greater, than or equal to the value of
        // the picked move 
        for (i = 3; i <= n; i++){
            table[i] += table[i - 3];
        }

        System.out.println(Arrays.toString(table));
        for (i = 5; i <= n; i++){
            table[i] += table[i - 5];
        }

        System.out.println(Arrays.toString(table));
        for (i = 10; i <= n; i++){
            table[i] += table[i - 10];
        }

        System.out.println(Arrays.toString(table));

        return table[n];
    }

    // Driver code 
    public static void main (String[] args)
    {
        int n = 6;
        System.out.println("Count for "+n+" is "+count(n));

        n = 13;
        System.out.println("Count for "+n+" is "+count(n));
    }
} 