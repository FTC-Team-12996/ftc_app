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

    //Encoders Bucket Forwards
    public void DriveBucketForward(double power) {
        MoveBucket.setPower(power);
        MoveBucket.setPower(0);
    }

    //Encoders Hook Forwards
    public void DriveHookForward(double power) {
        RaiseHook.setPower(power);
        LowerHook.setPower(power);
        RaiseHook.setPower(0);
        LowerHook.setPower(0);
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

    public void EncodeBucketMove(double power, int distance, DcMotor Motor) {
        //Reset Encoders
        MoveBucket.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set Target Position
        MoveBucket.setTargetPosition(distance);

        //Set to RUN_TO_POSITION
        MoveBucket.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        DriveBucketForward(power);

    }

    public void EncodeHookMove(double power, int distance, DcMotor Motor) {
        //Reset Encoders
        RaiseHook.setMode(DcMotor.RunMode.RESET_ENCODERS);
        LowerHook.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set Target Position
        RaiseHook.setTargetPosition(distance);
        LowerHook.setTargetPosition(distance);

        //Set to RUN_TO_POSITION
        RaiseHook.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LowerHook.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        DriveHookForward(power);

    }

    @Override
    public void RaiseBucket(double power, long timeMs) {

    }

    @Override
    public void LowerBucket(double power, long timeMs) {

    }

    @Override
    public void RaiseHook(double power, long timeMs) {

    }

    @Override
    public void LowerHook(double power, long timeMs) {

    }


    public void RaiseBucket() {
        if (BucketRaiseMax)
        {
            //Do Nothing
        }
        else
        {EncodeBucketMove(1,11115, MoveBucket);}
        BucketRaiseMax = true;
    }


    public void LowerBucket() {
        if (BucketRaiseMax = false)
        {
            //Do Nothing
        }
        else
        {EncodeBucketMove(-1,11115, MoveBucket);}
        BucketRaiseMax = false;
    }


    public void RaiseHook() {
        if (HookMax)
        {
            //Do Nothing
        }
        else
        {EncodeHookMove(1,2280, RaiseHook);}
        HookMax = true;
    }


    public void LowerHook() {
        if (HookMax = false)
        {
            //Do Nothing
        }
        else
        {EncodeHookMove(-1,2280, LowerHook);}
        HookMax = false;
    }
}
