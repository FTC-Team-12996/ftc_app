package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TankBot implements IRobot {

    private DcMotor motorRight;
    private DcMotor motorLeft;
    private DcMotor slideMotor;

    //Bucket Raise Motor
    private DcMotor MoveBucket;

    //Raise Hook
    private DcMotor RaiseHook;
    private DcMotor LowerHook;

    //Encoders
    int TETRIX_TICKS_PER_REV = 1440;

    boolean BucketRaiseMax = false;
    boolean HookMax = false;

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

    //Encoders Forwards
    public void Driveforward(double power) {
        motorLeft.setPower(power);
        motorRight.setPower(power);
        motorLeft.setPower(0);
        motorRight.setPower(0);
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
        if (BucketRaiseMax)
        {
           //Do Nothing
        }
        else
        {EncodeMove(1,11115, MoveBucket);}
        BucketRaiseMax = true;
    }

    @Override
    public void LowerBucket() {
        if (BucketRaiseMax = false)
        {
            //Do Nothing
        }
        else
        {EncodeMove(-1,11115, MoveBucket);}
        BucketRaiseMax = false;
    }

    @Override
    public void RaiseHook() {
        if (HookMax)
        {
            //Do Nothing
        }
        else
        {EncodeMove(1,2280, RaiseHook);}
        HookMax = true;
    }

    @Override
    public void LowerHook() {
        if (HookMax = false)
        {
            //Do Nothing
        }
        else
        {EncodeMove(1,2280, RaiseHook);}
        HookMax = false;
    }
}
