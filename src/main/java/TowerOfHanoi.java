class GFG {
    // Java recursive function to solve tower of hanoi puzzle
    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        System.out.println("--------> calling [n:" + n + "] calling FROM " + from_rod + " TO rod " + to_rod + " aux " + aux_rod);
        if (n == 1) {
            System.out.println("Moved disk [n:1] FROM rod " + from_rod + " TO rod " + to_rod);
            return;

        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("*Moved disk [n:" + n + "] FROM rod " + from_rod + " TO rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    //  Driver method
    public static void main(String args[]) {
        int n = 3; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods 
    }
}