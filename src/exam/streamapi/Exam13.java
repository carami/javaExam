package exam.streamapi;

import java.util.Arrays;
import java.util.List;

public class Exam13 {
  public static void main(String[] args) {

    // 접시(Dish)에 담긴 음식들에 대한 리스트를 생성합니다.
    List<Dish> menu = Arrays.asList(
        new Dish("삼겹살",false,200, Dish.Type.MEAT)
        ,new Dish("사과",false,50, Dish.Type.OTHER)
        ,new Dish("치킨",false,250, Dish.Type.MEAT)
        ,new Dish("샐러드",true,0, Dish.Type.OTHER)
        ,new Dish("라면",false,150, Dish.Type.OTHER)
    );

    // 칼로리가 100미만인 음식이 모두 야채일 경우에만 true가 나옵니다.
    // 사과는 카롤리가 50이하인데 야채는 아니죠. 그래서 결과는 false가 나옵니다.
    boolean b = menu.stream()
        .filter(d -> d.getCalories() < 100)
        .allMatch(Dish::isVegetarian);
    System.out.println(b);
  }
}
/*
false
 */
