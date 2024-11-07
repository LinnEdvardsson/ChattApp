import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class ChattUI extends JFrame {

    JTextArea chatArea;
    JScrollPane chatScroll;
    JButton connectButton;
    JTextField messageField;

    public ChattUI() throws UnknownHostException {
        super("Chat App");
        this.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        chatScroll = new JScrollPane(chatArea);

        connectButton = new JButton("Connect");
        messageField = new JTextField();


        connectButton.addActionListener(new Listener("25.16.11.103", 1234, messageField, chatArea));

        this.add(connectButton, BorderLayout.NORTH);
        this.add(chatScroll, BorderLayout.CENTER);
        this.add(messageField, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(ChattUI.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
