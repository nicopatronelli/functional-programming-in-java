package lazyevaluation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LazyEvaluationPractice {
    public static void main(String[] args) {
        mImperativo();
//        m1();
//        m2();
//        int num = 25;
//        System.out.println(num + " es primo: " + esPrimo(num));;
    }

    private static void m1Declarativo() {
        Optional<Integer> first = Arrays.asList(15, 12, 11, 20, 22, 35, 41, 45, 77, 68, 15, 25)
                .stream()
                .map(num -> {
                    System.out.println("Map executed for num " + num);
                    return num * 2;
                }) // some expensive operation
                .filter(num -> {
                    System.out.println("Filter executed for num " + num);
                    return num > 50;
                })
                .map(num -> {
                    System.out.println("Second map for num " + num);
                    return num + 1;
                })
                .findFirst();

        System.out.println("First value is ... " + first.get());
    }

    public static void m1Imperativo() {
        List<Integer> l = List.of(15, 12, 11, 20, 22, 35, 41, 45, 77, 68, 15, 25);
        int result = 0;
        for (Integer num:l) {
           int aux = num * 2; // first map
           if (aux > 50) { // filter
               result = aux + 1; // second map
               break;
           }
        }
        System.out.println("Result is " + result);
    }

    public static void m() {
        Stream<Integer> infinityStream = Stream.iterate(0, i -> i + 1);
        infinityStream
                .filter(num -> esPrimo(num))
                .limit(10)
                .forEach(System.out::println);
    }

    public static void mImperativo() {
        int maxPrimosAImprimir = 10;
        int aux = 0;
        for (int i = 0; aux < maxPrimosAImprimir; i++) {
          if (esPrimo(i)) {
              aux++;
              System.out.println(i);
          }
        }
    }

    public static boolean esPrimo(int num) {
        int otrosDivisores = 0;
        if (num == 0 || num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) otrosDivisores++;
            if (otrosDivisores >= 1) break;
        }
        return otrosDivisores == 0;
    }

}
