package exam.streamapi;

import java.util.stream.Stream;

public class Exam06 {
  public static void main(String[] args) {
    // Stream이 가지는 generate메소드는 Supplier 람다 인터페이스를 받아들입니다.
    // Supplier는 공급자란 의미입니다. 파라미터는 없고 값을 리턴하는 메소드를 가집니다.
    // generate는 람다 표현식이 리턴한 값을 계속해서 생성하는 스트림을 만들어냅니다.
    // 여기에서는 고정된 문자열 "Stream"만 생성해내고 있습니다.
    Stream<String> stream = Stream.generate(() -> "Stream");

    stream.forEach(w->{
      System.out.println(w);
    });
  }
}

/*
Stream
Stream
Stream
Stream
Stream
......
 */