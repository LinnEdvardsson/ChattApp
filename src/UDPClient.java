import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public UDPClient() throws IOException {

        InetAddress serverAddress = InetAddress.getByName("25.16.11.103");
        int serverPort = 1234;

        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String message;
        //String ping = "Type...";

        while ((message = in.readLine()) != null) {
            System.out.println(" ");
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
            clientSocket.send(packet);
            System.out.println("Ping message sent!");
        }
    }
    public static void main(String[] args) throws IOException {
        UDPClient udpClient = new UDPClient();
    }
}