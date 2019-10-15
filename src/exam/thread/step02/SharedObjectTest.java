package exam.thread.step02;

public class SharedObjectTest {
  public static void main(String[] args){
    // 1) 공유객체인 SharedObject는 인스턴스를 1개만 만들었다.
    SharedObject sharedObject = new SharedObject();

    // 2) Thread객체를 3개 만들었는데, 생성자에게 SharedObject를 넣어줬다. 같은 객체를 참조하게 한다.
    MyThread myThread1 = new MyThread(sharedObject, 1);
    MyThread myThread2 = new MyThread(sharedObject, 2);
    MyThread myThread3 = new MyThread(sharedObject, 3);

    myThread1.start();
    myThread2.start();
    myThread3.start();
  }

}

class MyThread extends Thread{
  private int type;
  private SharedObject sharedObject;

  public MyThread(SharedObject sharedObject, int type){
    this.type = type;
    this.sharedObject = sharedObject;
  }

  public void run(){
    if(type == 1)
      sharedObject.printA();
    else if(type == 2)
      sharedObject.printB();
    else if(type == 3)
      sharedObject.printC();
  }
}
