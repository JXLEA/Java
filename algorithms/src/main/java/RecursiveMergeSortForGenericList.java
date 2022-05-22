import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursiveMergeSortForGenericList {

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.size() == 1) {
            return list;
        }
        List<T> left = sort(new ArrayList<>(list.subList(0, list.size() / 2)));
        List<T> right = sort(new ArrayList<>(list.subList(list.size() / 2 , list.size())));
        return merge(list, left, right);
    }

    public static <T extends Comparable<T>> List<T> merge(List<T> mergedList, List<T> left, List<T> right) {
        mergedList.clear();
        int leftPointer = 0;
        int rightPointer = 0;
        int mergedPointer = 0;
        while (leftPointer < left.size() || rightPointer < right.size()) {
            if(leftPointer >= left.size() && rightPointer < right.size()) {
                mergedList.add(mergedPointer++, right.get(rightPointer++));
            } else if(rightPointer == right.size() && leftPointer < left.size()) {
                mergedList.add(mergedPointer++, left.get(leftPointer++));
            } else if (left.get(leftPointer).compareTo(right.get(rightPointer)) > 0) {
                mergedList.add(mergedPointer++, right.get(rightPointer++));
            } else if (left.get(leftPointer).compareTo(right.get(rightPointer)) < 0) {
                mergedList.add(mergedPointer++, left.get(leftPointer++));
            }
        }
        return mergedList;
    }
}
