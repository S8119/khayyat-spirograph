package khayyat.spirograph;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent
{
    private double largeRadius;
    private double smallRadius;
    private double penDistance;
    private int numSteps;
    private double anglePerStep;

    public SpirographView(
            double largeRadius, double smallRadius, double penDistance, int numSteps, double anglePerStep)
    {
        this.largeRadius = largeRadius;
        this.smallRadius = smallRadius;
        this.penDistance = penDistance;
        this.numSteps = numSteps;
        this.anglePerStep = anglePerStep;
    }

    public void setLargeRadius(double largeRadius)
    {
        this.largeRadius = largeRadius;
        repaint();
    }

    public void setSmallRadius(double smallRadius)
    {
        this.smallRadius = smallRadius;
        repaint();
    }

    public void setPenDistance(double penDistance)
    {
        this.penDistance = penDistance;
        repaint();
    }

    public void setNumSteps(int numSteps)
    {
        this.numSteps = numSteps;
        repaint();
    }

    public void setAnglePerStep(double anglePerStep)
    {
        this.anglePerStep = anglePerStep;
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
        double x = (largeRadius - smallRadius) * Math.cos(time); //initial value when time = 0
        double y = (largeRadius - smallRadius) * Math.sin(time); //initial value when time = 0
        for (int i = 0; i < numSteps; i++)
        {
            time = i * anglePerStep;
            prevX = x;
            prevY = y;
            x = (largeRadius - smallRadius) * Math.cos(time) + penDistance *
                    Math.cos((largeRadius - smallRadius) * time / smallRadius);
            y = (largeRadius - smallRadius) * Math.sin(time) - penDistance *
                    Math.sin((largeRadius - smallRadius) * time / smallRadius);
            g.drawLine((int) prevX + getWidth() / 2, (int) -prevY - getHeight() / 2,
                    (int) x + getWidth() / 2, (int) -y - getHeight() / 2);
        }
    }
}
