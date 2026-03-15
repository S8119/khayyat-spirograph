package khayyat.spirograph;

public class SpirographModel
{
    private double largeRadius;
    private double smallRadius;
    private double penDistance;
    private int numSteps;
    private double anglePerStep;

    public SpirographModel(
            double largeRadius, double smallRadius, double penDistance,
            int numSteps, double anglePerStep
    )
    {
        this.largeRadius = largeRadius;
        this.smallRadius = smallRadius;
        this.penDistance = penDistance;
        this.numSteps = numSteps;
        this.anglePerStep = anglePerStep;
    }
}
