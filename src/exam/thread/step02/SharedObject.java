package exam.thread.step02;

public class SharedObject {

  // 공유객체에는 synchronized를 붙일 수 있다.
  // 모든 메소드에 synchronized를 붙이면 모두 동시에 실행될 수가 없다.
  // printA(), printB()에만 붙이면 2개의 메소드는 동시에 실행되지 않는다.
  // printC()는 동시에 실행되게 된다.
  // 이렇게 동시에 실행되면 안되는 메소드에 synchronized를 붙여준다.
  // 메소드가 길어지면, 메소드 안의 일부만 동시에 실행되지 않도록 synchronized블록을 사용할 수 있다.
  public void printA(){
    for(int i = 0; i < 10; i++){
      System.out.print("A");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } // for
  } // printA

  public void printB(){
    for(int i = 0; i < 10; i++){
      System.out.print("B");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } // for
  } // printA

  public void printC(){
    for(int i = 0; i < 10; i++){
      System.out.print("C");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } // for
  } // printA
}
