import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GUI implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    private JTextField textMass, textRadius, textHeight;
    private JLabel labelMass, labelRadius, labelDensity, labelVolume, labelHeight, labelPotentialEnergy;
    private JLabel density, volume, potentialEnergy;
    private JButton calculate;

    private int mass;
    private int radius;

    public int getMass() {
        return mass;
    }

    public int getRadius() {
        return radius;
    }

    public GUI(String name, int width, int height) {
        initCalculator();
        frame.setTitle(name);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public void initCalculator() {
        // Initializing variables
        Object object = new Object(mass, radius);
        labelMass = new JLabel("Mass:");
        labelRadius = new JLabel("Radius:");
        labelDensity = new JLabel("Density: ");
        labelVolume = new JLabel("Volume: ");
        labelHeight = new JLabel("Height:");
        labelPotentialEnergy = new JLabel("Potential Energy:");

        density = new JLabel();
        volume = new JLabel();
        potentialEnergy = new JLabel();

        textMass = new JTextField("(kg)",5);
        textRadius = new JTextField("(m)", 5);
        textHeight = new JTextField("(m)", 5);

        calculate = new JButton("Calculate");

        final String[] previous = new String[1];

        // Visual
        frame.add(panel);

        panel.add(labelMass, gbc);
        panel.add(textMass, gbc);

        panel.add(labelRadius, gbc);
        panel.add(textRadius, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelDensity, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(density, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelVolume, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(volume, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelHeight, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(textHeight, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(labelPotentialEnergy, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(potentialEnergy, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(calculate, gbc);

        frame.pack();

        // Action listener
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textMass.getText().equals("")) {
                    object.setMass(Integer.parseInt(textMass.getText()));
                }
                if (!textRadius.getText().equals("")) {
                    object.setRadius(Float.parseFloat(textRadius.getText()));
                }
                if (object.getMass() > 0 && object.getRadius() > 0) {
                    density.setText(object.density() + "kg/m^3");
                    volume.setText((float) object.volume() + "m^3");
                } else if (object.getMass() == 0 || object.getRadius() == 0) {
                    density.setText("0kg/m^3");
                    volume.setText("0m^3");
                }
                if (!textHeight.getText().equals("") && object.getMass() > 0) {
                    object.setHeight(Integer.parseInt(textHeight.getText()));
                    potentialEnergy.setText(object.potentialEnergy(object.getHeight()) + "N");
                }
            }
        });
        textMass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                previous[0] = textMass.getText();
                textMass.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textMass.getText().equals("")) {
                    textMass.setText(previous[0]);
                }
            }
        });
        textRadius.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                previous[0] = textRadius.getText();
                textRadius.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textRadius.getText().equals("")) {
                    textRadius.setText(previous[0]);
                }
            }
        });
        textHeight.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                previous[0] = textHeight.getText();
                textHeight.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textHeight.getText().equals("")) {
                    textHeight.setText(previous[0]);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
