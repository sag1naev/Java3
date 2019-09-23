package lesson1;

public class BitOperation {
    public static void main(String[] args) {
        long a = -12, b = 7;
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);

        int [] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int mask = 0; mask < (1 << 7); mask++) {
            for (int bit = 0; bit < 7; bit++) {
                if((mask & (1 << bit)) != 0){
                    System.out.print(array[bit] + " ");
                }
            }
            System.out.println();
        }


        if((b & 1) == 0){
            System.out.println("Четно");
        }
        for (int i = 62; i >= 0; i--) {
            System.out.print((a & (1L << i)) >> i);
        }
    }
}
