package preparecodinginterview.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라.
 */
public class 중복없애기 {
    public List<Integer> solve(List<Integer> data) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : data) {
            set.add(num);
        }

        return set.stream().collect(Collectors.toList());
    }

    @Test
    void test() {
        System.out.println(solve(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 5, 6, 4, 7, 5)));
    }
}
