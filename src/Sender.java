import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Sender implements ActionListener {

    InetAddress myOwnAddress;
    int port;
    DatagramSocket socket;
    String message;
    JTextArea chatArea;

    public Sender(String myOwnAddress, int port, JTextField textField, JTextArea chatArea) throws UnknownHostException {
        this.myOwnAddress = InetAddress.getByName(myOwnAddress);
        this.port = port;
        this.message = textField.getText();
        this.chatArea = chatArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            chatArea.append(message);
            socket = new DatagramSocket();
            byte[] messageInBytes = message.getBytes();
            DatagramPacket packet = new DatagramPacket(messageInBytes, messageInBytes.length, myOwnAddress, port);
            socket.send(packet);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
