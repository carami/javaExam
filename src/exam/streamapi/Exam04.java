package exam.streamapi;

import java.util.Arrays;
import java.util.stream.Stream;

public class Exam04 {
  public static void main(String[] args) {
    String[] wordArray = {"Using", "Stream", "API", "From", "Java8"};
    // Arrays.stream(배열, 시작index, 건수)
    // 를 이용해 배열의 일부를 스트림으로 변환합니다.
    Stream<String> stream = Arrays.stream(wordArray, 0, 4);

    stream.forEach(w->{
      System.out.println(w);
    });
  }
}

/*
Using
Stream
API
From
 */