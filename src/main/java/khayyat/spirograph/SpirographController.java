package khayyat.spirograph;

public class SpirographController
{
    private final SpirographView view;

    public SpirographController(SpirographView view)
    {
        this.view = view;
    }

    public void updateView(double largeRad, double smallRad, double penDist, int numSteps, double angle)
    {
        view.setModel(new SpirographModel(largeRad, smallRad, penDist, numSteps, angle));
    }
}
