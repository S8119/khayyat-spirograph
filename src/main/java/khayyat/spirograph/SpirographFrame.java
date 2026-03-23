package khayyat.spirograph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpirographFrame extends JFrame
{
    public SpirographFrame()
    {
        final SpirographModel spirographModel = new SpirographModel(
                200, 75, 55, 8000, .007);

        setSize(800, 600);
        setTitle("Spirograph Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        final JLabel largeRadLabel = new JLabel("Large Radius");
        final JTextField largeRadField = new JTextField(String.valueOf(spirographModel.getLargeRadius()));
        final JLabel smallRadLabel = new JLabel("Small Radius");
        final JTextField smallRadField = new JTextField(String.valueOf(spirographModel.getSmallRadius()));
        final JLabel penDistLabel = new JLabel("Pen Distance");
        final JTextField penDistField = new JTextField(String.valueOf(spirographModel.getPenDistance()));
        final JLabel numStepsLabel = new JLabel("Number of Steps");
        final JTextField numStepsField = new JTextField(String.valueOf(spirographModel.getNumSteps()));
        final JLabel angLabel = new JLabel("Angle Per Step");
        final JTextField angField = new JTextField(String.valueOf(spirographModel.getAnglePerStep()));

        final JButton drawButton = new JButton("Draw");

        final SpirographView spirographView = new SpirographView(spirographModel);

        final SpirographController spirographController = new SpirographController(spirographView);

        drawButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                spirographController.updateView(
                        Double.parseDouble(largeRadField.getText()), Double.parseDouble(smallRadField.getText()),
                        Double.parseDouble(penDistField.getText()), Integer.parseInt(numStepsField.getText()),
                        Double.parseDouble(angField.getText())
                );
            }
        });

        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(largeRadLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(largeRadField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(smallRadLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(smallRadField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(penDistLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(penDistField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(numStepsLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(numStepsField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(angLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(angField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.NORTH;
        add(drawButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 6;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        add(spirographView, constraints);
    }

    public static void main(String[] args)
    {
        SpirographFrame spirographFrame = new SpirographFrame();
        spirographFrame.setVisible(true);
    }
}
