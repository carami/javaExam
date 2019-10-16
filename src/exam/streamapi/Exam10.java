package exam.streamapi;

import java.util.stream.Stream;

public class Exam10 {
  public static void main(String[] args){
    Stream<String> stream = Stream.of("hello!!", "hi!!", "green!!");

    // 필터에서 w값을 출력하도록 코드를 변경했습니다.
    // 람다 구현코드가 2줄 이상이 되었기 때문에 중괄호 안에 코드를 넣어줬고, 각 줄마다 ; 로 끝나게 코드를 작성했습ㄴ다.
    Stream<String> longStream = stream.filter(w -> {
      System.out.println("w : " + w);
      return w.length() > 5;
    });

    // 아래 줄이 언제 실행되는지 확인하세요.
    System.out.println("-----------------------");

    // forEach는 최종연산을 행하는 메소드입니다.
    longStream.forEach(w->{
      System.out.println(w);
    });
  }
}

/*
-----------------------
w : hello!!
hello!!
w : hi!!
w : green!!
green!!

 */