package exam.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exam15 {
  public static void main(String[] args) {

    // 접시(Dish)에 담긴 음식들에 대한 리스트를 생성합니다.
    List<Dish> menu = Arrays.asList(
        new Dish("삼겹살",false,200, Dish.Type.MEAT)
        ,new Dish("사과",false,50, Dish.Type.OTHER)
        ,new Dish("치킨",false,250, Dish.Type.MEAT)
        ,new Dish("샐러드",true,0, Dish.Type.OTHER)
        ,new Dish("라면",false,150, Dish.Type.OTHER)
    );

    //칼로리가 200미만인 Dish중에 임의의 하나를 반환합니다.
    //랜덤하게 값을 구하는 것은 아니기 때문에 매번 같은 값이 나올 수 있습니다.
    Optional<Dish> any = menu.stream()
        .filter(d -> d.getCalories() < 200)
        .findAny();
    System.out.println(any.get());
  }
}
/*
Dish [name=사과, vegetarian=false, calories=50, type=OTHER]
 */
