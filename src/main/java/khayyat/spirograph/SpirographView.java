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
        double x = (spirographModel.getLargeRadius() - spirographModel.getSmallRadius())
                * Math.cos(time); //initial value when time = 0
        double y = (spirographModel.getLargeRadius() - spirographModel.getSmallRadius())
                * Math.sin(time); //initial value when time = 0
        for (int i = 0; i < spirographModel.getNumSteps(); i++)
        {
            time = i * spirographModel.getAnglePerStep();
            prevX = x;
            prevY = y;
            x = (spirographModel.getLargeRadius() - spirographModel.getSmallRadius()) * Math.cos(time)
                    + spirographModel.getPenDistance() * Math.cos((spirographModel.getLargeRadius()
                    - spirographModel.getSmallRadius()) * time / spirographModel.getSmallRadius());
            y = (spirographModel.getLargeRadius() - spirographModel.getSmallRadius()) * Math.sin(time)
                    - spirographModel.getPenDistance() * Math.sin((spirographModel.getLargeRadius()
                    - spirographModel.getSmallRadius()) * time / spirographModel.getSmallRadius());
            g.drawLine((int) prevX + getWidth() / 2, (int) -prevY - getHeight() / 2,
                    (int) x + getWidth() / 2, (int) -y - getHeight() / 2);
        }
    }
}
