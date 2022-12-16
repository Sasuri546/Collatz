package CharlieJacobson;

public class MainCollatzProgram {

    int row = 3;

    public static void main(String[] args) {
        MainCollatzProgram main = new MainCollatzProgram();
        long total = 0;
        long[] maxPower = new long[]{3, 4};
        for (int i = 0; i < Math.pow(2, main.row)/4; i++) {
            long start = 4*i + 3;
            long[] n = new long[]{start, 0};
            int k = 0;
            while ((Math.pow(3, k) >= Math.pow(2, n[1]))) {
                n = main.successor(n);
                k++;
            }
            long power = n[1];
            while (Math.pow(3, k) < Math.pow(2, power)) {
                power--;
            }
            power++;
            if (power > main.row) {
                total++;

            }
            System.out.println("Number: " + start + ", Divisible by: 2^" + power);
            if (Math.max(maxPower[1], power) != maxPower[1]) {
                maxPower = new long[]{start, power};
            }

        }
        System.out.println("For divisibility " + Math.pow(2,main.row) + ": " + total + "/" + Math.pow(2,main.row) + " unknown cases remain");
        System.out.println(((double) total)/Math.pow(2,main.row));
    }

    private long[] successor(long[] n) {
        long twofac = n[1];
        long suc;
        if (n[0] % 2 == 0) {
            suc = n[0]/2;
            twofac++;
        } else {
            suc = 3*n[0] + 1;
        }
        while (suc % 2 == 0) {
            twofac++;
            suc = suc/2;
        }
        return new long[]{suc, twofac};
    }

}
