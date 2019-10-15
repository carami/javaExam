package exam.lambda.step02;


import java.util.function.IntBinaryOperator;

public class OperatorExam {

  private static int[] scores = {100, 92, 81, 78, 88, 96, 55, 94};

  public static int maxOrMin(IntBinaryOperator operator) {
    int result = scores[0];

    for (int score : scores) {
      result = operator.applyAsInt(result, score);
    }

    return result;
  }

  public static void main(String[] args) {
    int max = maxOrMin(
        (a, b) -> {
          if (a >= b) {
            return a;
          } else {
            return b;
          }
        }
    );
    System.out.println("최대 값 : " + max);
    int min = maxOrMin(
        (a, b) -> {
          if (a <= b) {
            return a;
          } else {
            return b;
          }
        }
    );
    System.out.println("최소 값 : " + min);
  }
}