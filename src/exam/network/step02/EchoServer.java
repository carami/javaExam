package exam.network.step02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

  public static void main(String[] args) {

    ServerSocket serverSocket = null;

    try {
      // ServerSocket 생성
      serverSocket = new ServerSocket(3000);

      System.out.println("Server 준비 완료");
      while(true) {
        // Socket을 대기한다. 동시에 여러개의 클라이언트를 받을 수는 없다.
        // 그럴려면 해당 부분이 Thread로 작성되야 한다.
        try(
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter bw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        ){
          while(true) {
            String msg = br.readLine();
            if("quit".equals(msg)) // 사용자가 "quit"를 보내면 종료된다.
              break;
            System.out.println("Client 에서 보낸 메시지 : " + msg);
            bw.write(msg + "\n"); // \n : 줄바꿈
            bw.flush(); // 출력 버퍼를 비우는 메서드. 해당 메소드를 호출하지 않으면 클라이언트가 메시지를 안받을 수 있다.
          }
        }catch(IOException e){
          e.printStackTrace();
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
