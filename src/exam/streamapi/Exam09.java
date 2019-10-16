package exam.streamapi;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Exam09 {
  public static void main(String[] args){
    Stream<String> stream = Stream.of("hello!!", "hi!!", "green!!");

    // stream의 내용을 필터링 합니다. 스트림에 있는 원소(w)의 길이가 5초과인 경우에만 필터링하는 스트림을 만들어냅니다.
    // filter가 사용되었다고 해서 그때 결과가 만들어지는 것이 아닙니다.
    // 초종연산이 일어날때 결과가 출력됩니다.
    // Exam10에서 확인해보도록 하겠습니다.
    Stream<String> longStream = stream.filter(w -> w.length() > 5);

    longStream.forEach(w->{
      System.out.println(w);
    });
  }
}

/*
hello!!
green!!
 */