package utility;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Utility {

  public boolean isOnline() {
    try {
      int timeoutMs = 1500;
      Socket sock = new Socket();
      SocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53);
      sock.connect(socketAddress, timeoutMs);
      sock.close();
      return true;
    }
    catch (IOException e) {
      return false;
    }
  }
}
