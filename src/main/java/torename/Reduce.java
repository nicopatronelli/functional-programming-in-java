package torename;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reduce {
    private static List<Integer> numsA = Arrays.asList(1,2,3,4);
    private static List<Integer> numsB = Arrays.asList(5,6,7,8);

    public static void main(String[] args) {
//        System.out.println(imperativeWay());
//        System.out.println(declarativeWay());

//        Integer first = numsA.stream()
//                .filter(num -> num > 2)
//                .map(num -> num * 2)
//                .findFirst()
//                .get();

//        System.out.println(first);

    }

    private static int imperativeWay() {
        int result = 0;

        for (Integer currentNum : numsA) {
            if (currentNum % 2 == 0) { // filter
                int doubleValue = currentNum * 2; // map
                result += doubleValue; // reduce
            }
        }

        return result;
    }

    private static int declarativeWay() {
        return numsA.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num * 2)
                .reduce(0, (numA, numB) -> numA + numB);
    }

    private static int flatMap() {
        List<List<Integer>> listOfLists = Arrays.asList(numsA, numsB);
        return listOfLists.stream()
                .flatMap(List::stream)
                .reduce(0, (x, y) -> x + y);
    }
}
