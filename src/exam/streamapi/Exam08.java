package exam.streamapi;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Exam08 {
  public static void main(String[] args){
    // Stream.iterate(시작값, 값을 변경하는 람다식) 을 사용해 스트림을 생성합니다.
    // BigInteger는 큰 정수를 다룰때 사용하는 객체입니다.
    // BigInteger.ZERO 는 숫자 0을 의미합니다.
    // 0부터 시작한후, 그 다음 값은 해당 0에 1을 추가하게 됩니다. BigInteger에 값을 더하기 위해선 add() 메소드를 사용해야 합니다.
    // 0이 1이 된 후, 해당 1이 또 람다식에 의해 1이 증가되게 됩니다.
    // 이런식으로 계속 1씩 증가하는 스트림이 만들어지게 됩니다.
    Stream<BigInteger> stream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

    stream.forEach(w->{
      System.out.println(w);
      try{ Thread.sleep(500);}catch(Exception ex){} // 너무 빨리 값이 출력되는 것을 막기 위해 Thread.sleep()을 사용
    });
  }
}

/*
0
1
2
3
4
......
 */