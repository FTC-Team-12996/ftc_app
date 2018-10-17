package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TankBot implements IRobot {

    private DcMotor motorRight;
    private DcMotor motorLeft;


    public TankBot( HardwareMap hardwareMap){
        super();
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void driveForward(double power, long timeMs) {
        motorRight.setPower(power);
        motorLeft.setPower(-power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorRight.setPower(0);
        motorLeft.setPower(0);
    }

    @Override
    public void driveBack(double power, long timeMs) {
        motorRight.setPower(-power);
        motorLeft.setPower(power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorRight.setPower(0);
        motorLeft.setPower(0);

    }

    @Override
    public void turnRight(double power, long timeMs) {
        motorRight.setPower(-power);
        motorLeft.setPower(-power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorRight.setPower(0);
        motorLeft.setPower(0);
    }

    @Override
    public void turnLeft(double power, long timeMs) {
        motorRight.setPower(power);
        motorLeft.setPower(power);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        motorRight.setPower(0);
        motorLeft.setPower(0);

    }
}