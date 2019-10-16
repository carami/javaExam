package exam.streamapi;

import java.util.Arrays;

public class Exam18 {
  public static void main(String[] args) {
    // reduce는 앞의 값에 뒤의 값을 계속 연산을  합니다.
    // (a, b)->{ return Integer.max(a,b); }
    // 와 같은 경우는 Integer::max 로 변경가능합니다.
    // 즉 앞의 값과 그 다음 값을 비교하여 큰 값을 반환합니다.
    // 처음엔 0과 6을 비교하여 큰값을 반환하고
    // 두번째엔 6과 2를 비교하여 큰값을 반환하게 됩니다.
    Integer reduce = Arrays.asList(6, 2, 1, 4, 2, 6)
        .stream()
        .reduce(0, Integer::max);
    System.out.println(reduce);
  }
}
/*
6
 */
