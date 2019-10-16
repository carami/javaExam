package exam.streamapi;

import java.util.stream.Stream;

public class Exam03 {
  public static void main(String[] args) {
    // Stream.of(가변형 파라미터) 를 이용하여 여러개의 문자열들을 스트림으로 변환하였습니다.
    Stream<String> stream = Stream.of("Using", "Stream", "API", "From", "Java8");

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
Java8
 */