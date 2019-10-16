package exam.streamapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Exam02 {
  public static void main(String[] args) {
    String contents = "hello World test code ! q1! q2";
    // 문자열이 가지고 있는 split메소드는 정규표현식으로 그 결과를 분해합니다.
    // "[\\P{L}]+" 정규표현식은 숫자 특수문자 공백등을 기준으로 문자열을 분해하여 문자열 배열을 반환합니다.
    // Stream.of(배열) 은 배열을 스트림 형태로 변환합니다.
    Stream<String> stream = Stream.of(contents.split("[\\P{L}]+"));

    // Stream이 가지고 있는 forEach는 Consumer 람다 표현식을 받아들입니다. Consumer는 소비자입니다.
    // Stream이 가지고 있는 원소 하나하나를 소비하는 역할을 합니다. 스트림의 값(w)를 출력하게 됩니다.
    stream.forEach(w->{
      System.out.println(w);
    });

  }
}

/*
hello
World
test
code
q
q
 */