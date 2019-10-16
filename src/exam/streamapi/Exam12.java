package exam.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exam12 {
  public static void main(String[] args) {

    // 접시(Dish)에 담긴 음식들에 대한 리스트를 생성합니다.
    List<Dish> menu = Arrays.asList(
        new Dish("삼겹살",false,200, Dish.Type.MEAT)
        ,new Dish("사과",false,50, Dish.Type.OTHER)
        ,new Dish("치킨",false,250, Dish.Type.MEAT)
        ,new Dish("샐러드",true,0, Dish.Type.OTHER)
        ,new Dish("라면",false,150, Dish.Type.OTHER)
    );

    // 스트림의 칼로리가 100미만인 것중에서 야채인 경우가 있을 경우 true를 반환합니다.
    // anyMatch(Predicate) 는 Predicate 람다인터페이스를 받아들입니다.
    // Predicate는 boolean test(T t); 메소드를 가지는 인터페이스입니다. 값을 하나 받아들여 해당 값이 참인지 거짓인지를 반환합니다.
    // anyMatch( d -> { return d.isVegetarian(); } ) 코드를 줄이면 anyMatch(Dish::isVegetarian)으로 바꿀 수 있습니다.
    boolean b = menu.stream()
        .filter(d -> d.getCalories() < 100)
        .anyMatch(Dish::isVegetarian);
    System.out.println(b);
  }
}

/*
true
 */
