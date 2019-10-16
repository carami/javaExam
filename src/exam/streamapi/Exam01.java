package exam.streamapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam01 {
  public static void main(String[] args){
    // 5개의 문자열로 구성된 리스트를 생성한다.
    List<String> words = Arrays.asList("hello", "hi", "world", "blue", "green");

    // 리스트로 부터 스트림을 구하고, 해당 스트림의 원소(w)의 길이가 2이상일 경우에만 카운트를 구한다.
    // parallelStream()은 스트림의 내용을 병렬적으로 처리한다. 병렬적으로 처리하는게 항상 속도가 빠른건 아니다.
    // 내부적으로 쓰레드를 사용한다.
    // 람다 표현식도 그렇고 스트림도 그렇고 처음부터 공부하자마자 바로 잘 사용하긴 어렵다.
    // 앞에서 배운 for, if 문을 이용하여 처리해도 문제 없는 경우가 대부분이다.
    // 하지만, 코딩에 익숙해질수록 짧은 코드가 편해질 수 있기 때문에 연습을 많이 해야합니다.
    long count1 = words.stream().filter(w -> w.length() > 2).count();
    long count2 = words.parallelStream().filter(w -> w.length() > 2).count();

    System.out.println(count1);
    System.out.println(count2);
  }
}

/*
4
4
 */