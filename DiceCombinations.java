public class DiceCombinations{
    public static void main(String[] args) {
        int[] dieA = new int[]{1, 2, 3, 4, 5, 6};
        int[] dieB = new int[]{1, 2, 3, 4, 5, 6};

        int numOutcomes = calculateOutcomes(dieA, dieB);

        // Count the number of different outcomes
        System.out.println(numOutcomes);
    }

    public static int calculateOutcomes(int[] dieA, int[] dieB) {
        int Outcomes = 0;

        // Using boolean array to track unique outcomes
        boolean[] unique = new boolean[2 * dieA.length + 1];

        for (int x : dieA) {
            for (int y : dieB) {
                int sum = x + y;
                if (!unique[sum]) {
                    unique[sum] = true;
                    Outcomes++;
                }
            }
        }

        return Outcomes;
    }
}
