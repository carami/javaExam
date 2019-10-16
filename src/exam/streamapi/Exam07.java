package exam.streamapi;

import java.util.stream.Stream;

public class Exam07 {
  public static void main(String[] args) {
    // Stream이 가지는 generate메소드는 Supplier 람다 인터페이스를 받아들입니다.
    // Supplier는 공급자란 의미입니다. 파라미터는 없고 값을 리턴하는 메소드를 가집니다.
    // generate는 람다 표현식이 리턴한 값을 계속해서 생성하는 스트림을 만들어냅니다.
    // 여기에서는 실수를 랜덤하게 생성하고 있습니다.
    //    Stream<Double> stream = Stream.generate(()->Math.random());
    //    위의 코드를 줄이면 아래와 같이 됩니다. 람다인터페이스를 구현한 코드가 클래스의 static한 메소드만 사용하고 있다면
    //    클래스명::메소드 로 변환 할 수 있습니다.

    Stream<Double> stream = Stream.generate(Math::random);

    stream.forEach(w->{
      System.out.println(w);
    });
  }
}

/*
0.8949449506594982
0.4107169577297243
0.6058099079214297
0.06659526035082208
0.7897709345858797
......
 */