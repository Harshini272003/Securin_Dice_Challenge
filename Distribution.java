public class Distribution{
    public static void main(String[] args) {
        int[] dieA = new int[]{1, 2, 3, 4, 5, 6};
        int[] dieB = new int[]{1, 2, 3, 4, 5, 6};

        printCombinations(dieA, dieB);
    }

    public static void printCombinations(int[] dieA, int[] dieB) {
        for (int x : dieA) {
            System.out.print(x + ": ");

            for (int y : dieB) {
                System.out.print(x + y + ", ");
            }

            System.out.println();
        }
    }
}
