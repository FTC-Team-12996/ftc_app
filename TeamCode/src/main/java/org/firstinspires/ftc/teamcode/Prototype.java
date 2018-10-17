package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Prototype implements IRobot {

    private DcMotor motorleft;
    private DcMotor motorright;

    public Prototype (HardwareMap hardwareMap) {
        motorleft = hardwareMap.get(DcMotor.class, "motorleft");
        motorright = hardwareMap.get(DcMotor.class, "motorright");
        motorleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    //Drive Forwards
    public void driveForward(double power, long timeMs) {
        motorleft.setPower(power);
        motorright.setPower(power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorleft.setPower(0);
        motorright.setPower(0);
    }

    @Override
    //Drive Backwards
    public void driveBack(double power, long timeMs) {
        motorleft.setPower(-power);
        motorright.setPower(-power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorleft.setPower(0);
        motorright.setPower(0);
    }

    @Override
    //Turn Right
    public void turnRight(double power, long timeMs) {
        motorleft.setPower(power);
        motorright.setPower(-power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorleft.setPower(0);
        motorright.setPower(0);
    }

    @Override
    //Turn Left
    public void turnLeft(double power, long timeMs) {
        motorleft.setPower(-power);
        motorright.setPower(power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorleft.setPower(0);
        motorright.setPower(0);
    }

}
