package exam.lambda.step01;

public class Exam01 {
  public static void main(String[] args){

    Thread t1 = new Thread(()->{
      for(int i = 0; i < 100; i++){
        System.out.print("A");
      } // for
    });
    t1.start();
  }
}
