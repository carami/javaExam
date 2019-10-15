package exam.thread.step01;

public class Exam01 {
  public static void main(String[] args){
    MyRunnable myRunnable1 = new MyRunnable("*");
    MyRunnable myRunnable2 = new MyRunnable("-");
    MyRunnable myRunnable3 = new MyRunnable("+");

    // Thread를 시작하는 것은 start()메소드이다.
    // Thread가 Runnable을 가지고 있을 경우 쓰레드가 실행될 준비가 끝난 후 가지고 있는 Runnable객체의 run()메소드를 호출한다.
    Thread t1 = new Thread(myRunnable1);
    Thread t2 = new Thread(myRunnable2);
    Thread t3 = new Thread(myRunnable3);

    t1.start();
    t2.start();
    t3.start();
  }
}

class MyRunnable implements Runnable{
  private String str;
  public MyRunnable(String str){
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