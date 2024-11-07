import javax.swing.*;
import java.io.IOException;
import java.net.*;

public class Listener implements Runnable {

    InetAddress myOwnAddress;
    int port;
    DatagramSocket socket;
    JTextArea chatArea;

    public Listener(String myOwnAddress, int port, JTextArea chatArea) throws UnknownHostException {
        this.myOwnAddress = InetAddress.getByName(myOwnAddress);
        this.port = port;
        this.chatArea = chatArea;
    }

    @Override
    public void run() {

        try {
            socket = new DatagramSocket(1234, InetAddress.getLocalHost());
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                chatArea.append(message + "\n");
            }
        } catch (SocketException e1) {
            throw new RuntimeException(e1);
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }

    }
}

