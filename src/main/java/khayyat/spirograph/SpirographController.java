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
        spirographView.setLargeRadius(largeRad);
        spirographView.setSmallRadius(smallRad);
        spirographView.setPenDistance(penDist);
        spirographView.setNumSteps(numSteps);
        spirographView.setAnglePerStep(angle);
    }
}
