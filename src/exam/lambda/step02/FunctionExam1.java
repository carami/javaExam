package exam.lambda.step02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExam1 {

  private static List<Student> list = Arrays.asList(
      new Student("Jackie", 90, 65),
      new Student("Jolie", 100, 100)
  );

  public static void printString(Function<Student, String> function) {

    for (Student std : list) {
      System.out.print(function.apply(std) + " ");
    }
    System.out.println();
  }

  public static void printInt(ToIntFunction<Student> function) {
    for (Student std : list) {
      System.out.print(function.applyAsInt(std) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("학생 이름: ");
    printString(t -> t.getName());
    System.out.println("영어 점수: ");
    printInt(t -> t.getEnglishScore());
    System.out.println("수학 점수: ");
    printInt(t -> t.getMathScore());
  }
}
