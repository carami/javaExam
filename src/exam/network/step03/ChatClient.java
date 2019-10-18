package exam.network.step03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatClient {

  /**
   * @param args
   */
  public static void main(String[] args) {

    BufferedReader keybaord = null;// 데이터 읽기
    String ipNumber ="127.0.0.1";// 연결할 IP
    int portNumber = 3000;
    String msg ="";// BufferedReader 를 사용하여 받은 메시지 저장

    try(
        Socket socket =new Socket(ipNumber, portNumber);
        BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter bw =new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {


      // 백그라운드에서 서버가 보내는 데이터를 읽기 위해 쓰레드를 선언하였다.
      ChatClientThread chatClientThread = new ChatClientThread(br);
      chatClientThread.start();

      keybaord =new BufferedReader(new InputStreamReader(System.in));

      System.out.println("이름을 입력하세요.");
      String name = keybaord.readLine();

      while(true) {
        // 서버에게 메시지를 전송한다.
        // 서버가 quit를 받으면 서버쪽 쓰레드도 종료된다.
        msg = keybaord.readLine();
        bw.println(name + " : " + msg);
        bw.flush();// 출력 버퍼를 비우는 메서드(반드시 사용해 줘야 함)

        if("quit".equals(msg)){
          System.out.println("프로그램을 종료합니다.");
          break;
        }
      }
    }catch (UnknownHostException e) {
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }

  } // main

}

class ChatClientThread extends Thread{
  private BufferedReader br = null;
  public ChatClientThread(BufferedReader br){
    this.br = br;
  }

  public void run(){
    String line = null;
    try {
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    }catch (Exception ex){
      // 서버 접속이 끊어졌을 때 Exception이 발생한다.
    }
  }
}
