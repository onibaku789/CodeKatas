import java.util.Arrays;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy {
    private static final int NUMBER_OF_DICE = 5;
    private final int[] dice;
    private final Map<Integer, Long> frequencyMap;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[] { d1, d2, d3, d4, d5 };
        frequencyMap = stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int chance() {
        return calculateSum();
    }

    public int fullHouse() {
        OptionalInt first = getNumberOfHouse(2);
        OptionalInt second = getNumberOfHouse(3);
        if (first.isPresent() && second.isPresent()) {
            return first.getAsInt() * 2 + second.getAsInt() * 3;
        }
        return 0;
    }

    private OptionalInt getNumberOfHouse(int i) {
        return frequencyMap.entrySet()
            .stream().filter(e -> e.getValue() == i).mapToInt(Map.Entry::getKey).findFirst();
    }

    public int smallStraight() {
        if (stream().distinct().filter(integer -> integer < 6).count() == NUMBER_OF_DICE) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        if (stream().filter(integer -> integer > 1).distinct().count() == NUMBER_OF_DICE) {
            return 20;
        }
        return 0;
    }

    public int fourOfAKind() {
        return getPointsForKinds(4);
    }

    public int threeOfAKind() {
        return getPointsForKinds(3);
    }

    public int twoPairs() {
        return getPointsForKinds(2);
    }

    public int scorePair() {
        OptionalInt max = frequencyMap
            .entrySet()
            .stream()
            .filter(e -> e.getValue() >= 2)
            .mapToInt(Map.Entry::getKey)
            .max();
        return max.orElse(0) * 2;
    }

    public int sixes() {
        return getPointsFor(6);
    }

    public int fives() {
        return getPointsFor(5);
    }

    public int fours() {
        return getPointsFor(4);
    }

    public int threes() {
        return getPointsFor(3);
    }

    public int twos() {
        return getPointsFor(2);
    }

    public int ones() {
        return getPointsFor(1);
    }

    public int yatzy() {
        if (stream().distinct().count() == 1) {
            return 50;
        }
        return 0;
    }

    private int getPointsForKinds(int i) {
        return frequencyMap.entrySet()
            .stream()
            .filter(e -> e.getValue() >= i)
            .mapToInt(Map.Entry::getKey)
            .map(operand -> operand * i)
            .sum();
    }

    private int getPointsFor(int i) {
        return stream().filter(integer -> integer == i).mapToInt(Integer::intValue).sum();
    }

    private int calculateSum() {
        return Arrays.stream(dice).sum();
    }

    private Stream<Integer> stream() {
        return Arrays.stream(dice).boxed();
    }
}
