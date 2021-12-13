package CharlieJacobson;

public class MainCollatzProgram {

    static int row = 24;

    public static void main(String[] args) {
        int total = 0;
        int[] maxPower = new int[]{3, 4};
        for (int i = 0; i < Math.pow(2, row)/4; i++) {
            int start = 4*i + 3;
            int[] n = new int[]{start, 0};
            int k = 0;
            while ((Math.pow(3, k) >= Math.pow(2, n[1]))) {
                n = successor(n);
                k++;
            }
            int power = n[1];
            while (Math.pow(3, k) < Math.pow(2, power)) {
                power--;
            }
            power++;
            System.out.println("Number: " + start + ", Divisible by: 2^" + power);
            if (Math.max(maxPower[1], power) != maxPower[1]) {
                maxPower = new int[]{start, power};
            }
            if (power > row) total++;
        }
        System.out.println("For divisibility " + Math.pow(2,row) + ": " + total + "/" + Math.pow(2,row) + " unknown cases remain");
        System.out.println(total/Math.pow(2,row));
        /*
        int[] n = new int[]{82261083, 0};
        while (successor(n)[1] < 135) {
            n = successor(n);
        }
        System.out.println(n[0]);

         */
    }

    //Takes in a 2-tuple of integers
    private static int[] successor(int[] n) {
        int suc = 3*n[0] + 1;
        int twofac = n[1];
        while (suc % 2 == 0) {
            twofac++;
            suc = suc/2;
        }
        return new int[]{suc, twofac};
    }

    /*for (int i = 0; i < 50; i++) {
            int n = 64*i + 21;
            int[] suc = successor(new int[]{n, 0});
            System.out.println("Number: " + n + ", Successor: " + suc[0] + ", Factors of Two: " + suc[1]);
        }*/

}
