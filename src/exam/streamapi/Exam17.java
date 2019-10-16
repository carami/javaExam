package exam.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exam17 {
  public static void main(String[] args) {
    // 정수로 된 스트림을 생성합니다.
    // 0에 첫번째 스트림의 값을 더한 결과를 만듭니다.
    // 그 결과에 두번째 값을 더한 결과를 만듭니다.
    // 그리고 그 결과에 계속 누적한 결과를 만듭니다.
    // 0대신에 숫자값을 100으로 변경해보세요.
    Integer reduce = Arrays.asList(6, 2, 1, 4, 2, 6)
        .stream()
        .reduce(0, (a, b) -> a + b);
    System.out.println(reduce);
  }
}
/*
21
 */
