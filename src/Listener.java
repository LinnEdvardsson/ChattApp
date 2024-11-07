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

        try(DatagramSocket socket = new DatagramSocket(1234, myOwnAddress);
        ){
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}

