package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Prototype implements IRobot {

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor slideMotor;

    public Prototype (HardwareMap hardwareMap) {
        motorLeft = hardwareMap.get(DcMotor.class, "motorleft");
        motorRight = hardwareMap.get(DcMotor.class, "motorright");
<<<<<<< HEAD
       \
=======
        slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");
        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
>>>>>>> 8b3e9a51adf740810ce1daf7b9d256758e7e6eb9
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

    //Encoders Forwards
    public void Driveforward(double power) {
        motorLeft.setPower(power);
        motorRight.setPower(power);
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

    @Override
    public void EncodeMove(double power, int distance, DcMotor Motor) {
        //Reset Encoders
       slideMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);
       motorRight.setMode(DcMotor.RunMode.RESET_ENCODERS);
       motorLeft.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set Target Position
       slideMotor.setTargetPosition(distance);
       motorRight.setTargetPosition(distance);
       motorLeft.setTargetPosition(distance);

        //Set to RUN_TO_POSITION
       slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
       Driveforward(power);

    }
    @Override
    public void RaiseBucket() {

    }

    @Override
    public void LowerBucket() {

    }

    @Override
    public void RaiseHook() {

    }

    @Override
    public void LowerHook() {

    }
}
