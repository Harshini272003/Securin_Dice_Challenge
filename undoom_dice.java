import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class undoom_dice{
    public static void main(String[] args) {
       List<Integer> dieA = Arrays.asList(1, 2, 3, 4, 5, 6);
       List<Integer> dieB = Arrays.asList(1, 2, 3, 4, 5, 6);
       

        List<Integer> newDieA = Arrays.asList(1, 2, 2, 3, 3, 4);
        Map<Integer, Integer> desiredOutcome = calculateOutcomes(dieA,dieB);
        List<Integer> newDieB = undoomDice(newDieA, desiredOutcome);

        System.out.println("New Die A: " + newDieA);
        System.out.println("New Die B: " + newDieB);
    }

    public static List<Integer> undoomDice(List<Integer> dieA, Map<Integer, Integer> desiredOutcome) {
        List<Integer> newDieB = new ArrayList<>();

        for (int pos : desiredOutcome.keySet()) {
            while (desiredOutcome.get(pos) > 0) {
                newDieB.add(pos - 1);
                Map<Integer, Integer> cur = calculateOutcomes(Arrays.asList(pos - 1), dieA);
                subtractOutcomes(desiredOutcome, cur);
            }
        }

        return newDieB;
    }

    public static Map<Integer, Integer> calculateOutcomes(List<Integer> dieA, List<Integer> dieB) {
        Map<Integer, Integer> outcomes = new HashMap<>();

        for (int x : dieA) {
            for (int y : dieB) {
                int sum = x + y;
                outcomes.put(sum, outcomes.getOrDefault(sum, 0) + 1);
            }
        }

        return outcomes;
    }

    public static void subtractOutcomes(Map<Integer, Integer> desiredOutcome, Map<Integer, Integer> curOutcome) {
        for (int out : curOutcome.keySet()) {
            desiredOutcome.put(out, desiredOutcome.get(out) - curOutcome.get(out));
        }
    }
}
