import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(5);
        list2.add(4);

        list1.stream()
                .filter(ele->list2.stream().noneMatch(e->e.equals(ele)))
                .forEach(System.out::println);
    }
}