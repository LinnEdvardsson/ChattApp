import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.List;

public class Listener implements ActionListener{

    InetAddress myOwnAddress;
    int port;
    DatagramSocket socket;
    String message;
    JTextArea chatArea;

    public Listener(String myOwnAddress, int port, JTextField textField, JTextArea chatArea) throws UnknownHostException {
        this.myOwnAddress = InetAddress.getByName(myOwnAddress);
        this.port = port;
        this.message = textField.getText();
        this.chatArea = chatArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            DatagramSocket socket = new DatagramSocket();
            socket = new DatagramSocket(1234, myOwnAddress);
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);
            }
        } catch (SocketException e1) {
            throw new RuntimeException(e1);
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }

    }
}

