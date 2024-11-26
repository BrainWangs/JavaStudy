// Java recursive program to solve tower of hanoi puzzle
 
class HanoiTower
{
    // Java recursive function to solve tower of hanoi puzzle
    static void towerOfHanoi(int n, String from_rod, String to_rod, String aux_rod)
    {
        if (n == 1)
        {
            System.out.println("Disk 1 " +  from_rod + " => " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Disk " + n + " " +  from_rod + " => " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }
     
    //  Driver method
    public static void main(String args[])
    {
        int n = 4; // Number of disks
        // 将n个盘子，从A柱移动到C柱，借助辅助柱B
        towerOfHanoi(n, "A","C","B");  // A, B and C are names of rods
    }
}