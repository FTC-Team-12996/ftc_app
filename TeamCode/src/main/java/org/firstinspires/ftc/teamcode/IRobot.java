package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public interface IRobot {
    public void driveForward(double power, long timeMs);

    public void driveBack(double power, long timeMs);

    public void turnRight(double power, long timeMs);

    public void turnLeft(double power, long timeMs);

    public void EncodeHookMove(double power, int distance, DcMotor Motor);

    public void EncodeBucketMove(double power, int distance, DcMotor Motor);

    public void RaiseBucket();

    public void LowerBucket();

    public void RaiseHook();

    public void LowerHook();
}

