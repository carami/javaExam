package exam.streamapi;

import java.util.Arrays;
import java.util.stream.Stream;

public class Exam19 {
  public static void main(String[] args) {
    // sorted(Comparator) 는 Comparator 람다 인터페이스르 받습니다.
    // Comparator는 2개의 값을 비교하는 int compare(T o1, T o2); 메소드를 가집니다.
    // 2개의 값을 비교하여 앞의 값이 클경우엔 양수를 뒤의 값이 클경우엔 음수를 2개의 값이 같을 경우엔 0을 반환합니다.
//    Stream<Integer> sorted = Arrays.asList(6, 2, 1, 4, 2, 6)
//        .stream()
//        .sorted((a1, a2)->{
//          return a1.compareTo(a2); // 정수(Integer)는 값을 비교하기 위한 compareTo메소드를 가집니다.
//        });
//  위의 코드는 아래와 같이 짧게 변경될 수 있습니다.
    Stream<Integer> sorted = Arrays.asList(6, 2, 1, 4, 2, 6)
        .stream()
        .sorted(Integer::compareTo);
    sorted.forEach(w ->
      System.out.println(w)
    );
  }
}
/*
1
2
2
4
6
6
 */
