import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new GridBagLayout());
    private JTextField textMass;
    private JTextField textRadius;
    private JButton calculate;

    private int mass;
    private int radius;

    public GUI(String name, int width, int height) {
        initCalculator();
        frame.setTitle(name);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Action listener
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textMass.getText().equals("")) {
                    mass = Integer.parseInt(textMass.getText());
                }
                if (!textRadius.getText().equals("")) {
                    radius = Integer.parseInt(textRadius.getText());
                }
            }
        });
    }

    public void initCalculator() {
        // Initializing variables
        JLabel labelMass = new JLabel("Mass:");
        JLabel labelRadius = new JLabel("Radius:");
        textMass = new JTextField(5);
        textRadius = new JTextField(5);
        calculate = new JButton("Calculate");

        // Visual
        frame.add(panel);
        panel.add(labelMass);
        panel.add(textMass);
        panel.add(labelRadius);
        panel.add(textRadius);
        panel.add(calculate);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
