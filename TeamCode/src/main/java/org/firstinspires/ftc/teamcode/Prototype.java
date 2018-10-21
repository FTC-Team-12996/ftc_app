package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Prototype implements IRobot {

    private DcMotor motorLeft;
    private DcMotor motorRight;

    public Prototype (HardwareMap hardwareMap) {
        motorLeft = hardwareMap.get(DcMotor.class, "motorleft");
        motorRight = hardwareMap.get(DcMotor.class, "motorright");
        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    //Drive Forwards
    public void driveForward(double power, long timeMs) {
        motorLeft.setPower(power);
        motorRight.setPower(power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorLeft.setPower(0);
        motorRight.setPower(0);
    }

    @Override
    //Drive Backwards
    public void driveBack(double power, long timeMs) {
        motorLeft.setPower(-power);
        motorRight.setPower(-power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorLeft.setPower(0);
        motorRight.setPower(0);
    }

    @Override
    //Turn Right
    public void turnRight(double power, long timeMs) {
        motorLeft.setPower(power);
        motorRight.setPower(-power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorLeft.setPower(0);
        motorRight.setPower(0);
    }

    @Override
    //Turn Left
    public void turnLeft(double power, long timeMs) {
        motorLeft.setPower(-power);
        motorRight.setPower(power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorLeft.setPower(0);
        motorRight.setPower(0);
    }

}
