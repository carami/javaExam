package exam.thread.step01;

public class Exam02 {
  public static void main(String[] args){
    // Thread를 시작하는 것은 start()메소드이다.
    // Thread의 start()메소드가 실행되었을 때 Thread가 실행할 준비를 한 후 Runnable객체를 가지고 있지 않다면, 자신의 run메소드를 호출한다.
    MyThread t1 = new MyThread("*");
    MyThread t2 = new MyThread("-");
    MyThread t3 = new MyThread("+");

    t1.start();
    t2.start();
    t3.start();
  }
}

class MyThread extends Thread{
  private String str;
  public MyThread(String str){
    this.str = str;
  }
  @Override
  public void run() {
    for(int i = 0; i < 100; i++){
      // 문자를 출력하고 0~99 사이의 밀리세컨드만큼 쉰다.
      System.out.print(str);
      try {
        Thread.sleep((int)(Math.random() * 100));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } // for
  }
}