package exam.lambda.step01;

public class Exam02 {
  public static void main(String[] args){
    // 이름없는 객체를 전달하는 것처럼, 람다를 전달할 수 있다.
    method1(new LambdaIf01() {
      @Override
      public String exec(int n, String str) {
        return str + n;
      }
    }); // 이름없는 객체를 이용했다. new LambdaIf01(){ 부터 메소드 이름까지 지운다. 괄호닫고 뒤에 -> 를 붙인다.
    // 이렇게 하면 아래와 같은 람다표기식이 된다.
    method1((int n, String str) -> { return str + n;});
    // 코드가 한줄일 경우 return을 생략할 수 있다.
    method1((int n, String str) -> str + n);
    // 매개변수의 타입을 생략할 수 있다. 타입을 추정할 수 있다.
    method1((n, str) -> str + n);
    method2(str -> str + 11);
    method3(()-> "Hello, World");
    method4(()->{});
  }

  // 람다 인터페이스를 받는 메소드를 선언한다.
  public static void method1(LambdaIf01 lambdaIf01){
    System.out.println(lambdaIf01.exec(5, "hello"));
  }

  public static void method2(LambdaIf02 lambdaIf02){
    System.out.println(lambdaIf02.exec("hello"));
  }

  public static void method3(LambdaIf03 lambdaIf03){
    System.out.println(lambdaIf03.exec());
  }

  public static void method4(LambdaIf04 lambdaIf04){
    lambdaIf04.exec();
  }
}

// 람다 인터페이스를 선언한다.
interface LambdaIf01{
  public String exec(int n, String str);
}

interface LambdaIf02{
  public String exec(String str);
}

interface LambdaIf03{
  public String exec();
}

interface LambdaIf04{
  public void exec();
}