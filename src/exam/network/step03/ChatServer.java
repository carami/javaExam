package exam.network.step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {

  public static void main(String[] args) {

    try (
        ServerSocket serverSocket = new ServerSocket(3000);
    ) {

      System.out.println("Server 준비 완료");
      List<PrintWriter> printWriters = Collections.synchronizedList(new ArrayList<>());
      while (true) {
        Socket socket = serverSocket.accept();
        ChatThread chatThread = new ChatThread(socket, printWriters);
        chatThread.start();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

class ChatThread extends Thread {

  private Socket socket;
  private List<PrintWriter> printWriters;

  public ChatThread(Socket socket, List<PrintWriter> printWriters) {
    this.socket = socket;
    this.printWriters = printWriters;
  }

  public void run() {
    System.out.println("Client가 연결되었습니다.");

    try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    ) {

      printWriters.add(pw); // 브로드케스팅하기 위해추가한다.

      try {
        while (true) {
          String msg = br.readLine();
          if ("quit".equals(msg) || msg == null) // 사용자가 "quit"를 보내면 종료된다.
            break;
          System.out.println("Client 에서 보낸 메시지 : " + msg);
          // 접속한 모든 클라이언트에게 메시지를 전송한다.
          for(PrintWriter out: printWriters){
            out.println(msg);
            out.flush(); // 출력 버퍼를 비우는 메서드. 해당 메소드를 호출하지 않으면 클라이언트가 메시지를 안받을 수 있다.
          }

        }
      }finally {
        printWriters.remove(pw); //반복문을 종료할 때 pw을 삭제한다.
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
