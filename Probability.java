public class Probability{
    public static void main(String[] args) {
        int[] dieA = new int[]{1, 2, 3, 4, 5, 6};
        int[] dieB = new int[]{1, 2, 3, 4, 5, 6};

        int[] Outcomes = calculateOutcomes(dieA, dieB);
        double[] Probabilities = calculateProbabilities(Outcomes);

        // Print the calculated probabilities
        printProbabilities(Outcomes, Probabilities);
    }

    public static int[] calculateOutcomes(int[] dieA, int[] dieB) {
        int[] outcomes = new int[2 * dieA.length + 1];

        for (int x : dieA) {
            for (int y : dieB) {
                int sum = x + y;
                outcomes[sum]++;
            }
        }

        return outcomes;
    }

    public static double[] calculateProbabilities(int[] outcomes) {
        int total = 0;

        for (int count : outcomes) {
            total += count;
        }

        double[] probabilities = new double[outcomes.length];

        for (int i = 0; i < outcomes.length; i++) {
            probabilities[i] = Math.round((double) outcomes[i] / total * 1000.0) / 1000.0;
        }

        return probabilities;
    }

    public static void printProbabilities(int[] outcomes, double[] probabilities) {
        System.out.println("Probability of Distribution:");

        for (int i = 0; i < outcomes.length; i++) {
            System.out.println(i + ": " + probabilities[i]);
        }
    }
}
