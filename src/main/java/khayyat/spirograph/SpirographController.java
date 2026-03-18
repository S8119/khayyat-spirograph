package khayyat.spirograph;

import javax.swing.*;

public class SpirographController
{
    private SpirographView spirographView;

    public SpirographController(SpirographView spirographView)
    {
        this.spirographView = spirographView;
    }

    public void updateView(double largeRad, double smallRad, double penDist, int numSteps, double angle)
    {
        spirographView.setSpirographModel(new SpirographModel(largeRad, smallRad, penDist, numSteps, angle));
    }
}
