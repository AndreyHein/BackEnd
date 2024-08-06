import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> p1 = (String s) -> s.startsWith("a");



        printIf(List.of("anna", "tanya", "alex"), p1);
        System.out.println("-------------------");
        printIf(List.of("anna", "tanya", "alex"), s -> s.length() >= 5);

        List<String> list = List.of("anna", "igor", "valentina", "john");
        System.out.println("-------------- 1");
        List<String> list1 = list.stream()
                .filter(s -> s.length() > 4)
                .toList();
        System.out.println(list1);

        System.out.println("-------------- 2");
        List<String> list2 = list.stream()
                .filter(s -> s.length() > 4)
                .map(s -> s.toUpperCase())
                .toList();
        System.out.println(list2);
    }

    public static void printIf(List<String> list, Predicate<String> predicate) {
        for (String str : list) {
            if (predicate.test(str)) {
                System.out.println(str);
            }
        }
    }
}