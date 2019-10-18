package exam.network.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client01 {

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


      keybaord =new BufferedReader(new InputStreamReader(System.in));

      while(true) {
        // 서버에게 메시지를 전송한다.
        // 서버가 quit를 받으면 서버쪽 쓰레드도 종료된다.
        System.out.print("Client send message (종료 : quit): ");
        msg = keybaord.readLine();
        bw.println(msg);
        bw.flush();// 출력 버퍼를 비우는 메서드(반드시 사용해 줘야 함)

        if("quit".equals(msg)){
          System.out.println("프로그램을 종료합니다.");
          break;
        }

        System.out.print("Server send message : " + br.readLine());
        System.out.println("");

      }
    }catch (UnknownHostException e) {
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }

  }

}
