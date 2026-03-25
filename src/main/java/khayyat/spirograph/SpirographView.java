package khayyat.spirograph;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent
{
    private SpirographModel model;

    public SpirographView(SpirographModel model)
    {
        this.model = model;
    }

    public void setModel(SpirographModel model)
    {
        this.model = model;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.translate(getWidth() / 2, getHeight() / 2);

        double time = 0;
        double prevX;
        double prevY;
        double x = model.getX(0);
        double y = model.getY(0);
        //initial values when time = 0. Should equal x and y values in first iteration of for loop.

        for (int i = 1; i < model.getNumSteps(); i++)
        {
            prevX = x;
            prevY = y;
            time = i * model.getAnglePerStep();
            x = model.getX(time);
            y = model.getY(time);
            g.drawLine((int) prevX, (int) prevY,
                    (int) x, (int) y);
        }
    }
}
