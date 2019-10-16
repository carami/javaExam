package exam.streamapi;

import java.util.Arrays;
import java.util.stream.Stream;

public class Exam05 {
  public static void main(String[] args) {
    // 요소가 없는 Stream을 생성합니다.
    // 스트림을 리턴하는 메소드를 만든다고 생각해 보겠습니다.
    // 스트림을 반환하고자 하는데, 조건에 맞는 데이터가 없을 경우 해당 코드를 이용해 요소가 없는 스트림을 반환할 수 있습니다.
    Stream<String> stream = Stream.empty();


    stream.forEach(w->{
      System.out.println(w);
    });
  }
}

/*

 */