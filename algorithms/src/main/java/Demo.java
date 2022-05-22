import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {


    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Andrii");
        strings.add("Serhii");
        strings.add("Nazar");
        strings.add("Taras");
        strings.add("Stas");
        strings.add("Yurii");

        List<Integer> integers =new ArrayList<>();
        integers.add(5);
        integers.add(1);
        integers.add(2);
        integers.add(8);
        integers.add(4);
        integers.add(9);

        System.out.println("unsorted str`s -> " + strings);
        RecursiveMergeSortForGenericList.sort(strings);
        System.out.println("sorted str`s -> " + strings);

        System.out.println("---------------");

        System.out.println("unsorted int`s -> " + integers);
        RecursiveMergeSortForGenericList.sort(integers);
        System.out.println("sorted int`s -> " + integers);
    }
}
