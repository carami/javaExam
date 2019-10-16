package exam.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exam11 {
  public static void main(String[] args) {

    // 접시(Dish)에 담긴 음식들에 대한 리스트를 생성합니다.
    List<Dish> menu = Arrays.asList(
        new Dish("삼겹살",false,200, Dish.Type.MEAT)
        ,new Dish("사과",false,50, Dish.Type.OTHER)
        ,new Dish("치킨",false,250, Dish.Type.MEAT)
        ,new Dish("샐러드",true,0, Dish.Type.OTHER)
    );

    // map은 Function 람다 인터페이스를 받아들입니다. Function은 파라미터를 받고, 값을 리턴합니다.
    // map은 스트림의 원소를 받아들여, 다른 값으로 변환한 값을 리턴합니다.
    // 칼로리를 구하는 getCalories()의 결과로 변환시키게 됩니다. 즉 Dish객체가 정수(Integer)로 변환되는 것입니다.
    // 파라미터가 가지는 메소드를 호출하여 바로 리턴할 경우 해당 원소의 클래스명::메소드명 으로 수정가능합니다.
    // menu.stream().map((d)->{return d.getCalories()}).reduce((a, b) -> a+b);
    // reduce는 스트림의 결과를 합치는 일을 합니다. 파라미터로는 첫번째 원소와 두번째 원소를 합합니다.
    // 그 다음엔 그 합한 결과와 그 다음 원소를 합합니다. 이것을 반복하여 만들어낸 결과를 반환합니다.
    // Optional<Integer>는 자바에서 null을 처리하기 위해 사용되는 문법입니다.
    // Optional<Integer>는 정수를 하나 값을 가지는데 null을 가질 수 없습니다. 해당 객체의 get()메소드를 호출할 때
    // 이 안의 값이 null이라면 Exception이 발생하게 됩니다.
    Optional<Integer> reduce = menu.stream().map(Dish::getCalories).reduce((a, b) -> a + b);
    System.out.println(reduce.get());
  }
}

/*
500
 */