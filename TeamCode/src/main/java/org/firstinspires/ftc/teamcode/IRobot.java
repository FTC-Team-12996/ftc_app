package org.firstinspires.ftc.teamcode;

public interface IRobot {
    public void driveForward(double power, long timeMs);

    public void driveBack(double power, long timeMs);

    public void turnRight(double power, long timeMs);

    public void turnLeft(double power, long timeMs);
}

