package khayyat.spirograph;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent
{
    private SpirographModel spirographModel;

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

        g.translate(getWidth() / 2, getHeight() / 2);

        double time = 0;
        double prevX;
        double prevY;
        double x = spirographModel.getX(0);
        double y = spirographModel.getY(0);
        //initial values when time = 0. Should equal x and y values in first iteration of for loop.

        for (int i = 0; i < spirographModel.getNumSteps(); i++)
        {
            prevX = x;
            prevY = y;
            time = i * spirographModel.getAnglePerStep();
            x = spirographModel.getX(time);
            y = spirographModel.getY(time);
            g.drawLine((int) prevX, (int) prevY,
                    (int) x, (int) y);
        }
    }
}
