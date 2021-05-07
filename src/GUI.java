import javax.swing.*;

public class GUI {

    public GUI(String name, int width, int height) {
        JFrame frame = new JFrame(name);
        JPanel panel = new JPanel();
        JTextField mass = new JTextField("Enter mass:");
        frame.setSize(width, height);
        frame.add(panel);
        panel.add(mass);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
