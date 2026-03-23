package khayyat.spirograph;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent
{
    SpirographModel spirographModel;

    public SpirographView(SpirographModel spirographModel)
    {
        this.spirographModel = spirographModel;
    }

    public void setSpirographModel(SpirographModel spirographModel)
    {
        this.spirographModel = spirographModel;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.translate(0, getHeight());

        double time = 0;
        double prevX;
        double prevY;
        double x = spirographModel.getXPosition(0);
        double y = spirographModel.getYPosition(0);
        //initial values when time = 0. Should equal x and y values in first iteration of for loop.

        for (int i = 0; i < spirographModel.getNumSteps(); i++)
        {
            prevX = x;
            prevY = y;
            time = i * spirographModel.getAnglePerStep();
            x = spirographModel.getXPosition(time);
            y = spirographModel.getYPosition(time);
            g.drawLine((int) prevX + getWidth() / 2, (int) -prevY - getHeight() / 2,
                    (int) x + getWidth() / 2, (int) -y - getHeight() / 2);
        }
    }
}
