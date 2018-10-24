package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;



@Autonomous
public class AutoZone extends LinearOpMode {
    // private DcMotor motorTest;
    //private DcMotor motor2;
    private DcMotor motorLeft;
    private DcMotor motorRight;




    @Override
    public void runOpMode() {

        //  motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        //motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        IRobot Robot= new Prototype(hardwareMap);

        //telemetry.addData("Status", "Initialized");
        //telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        telemetry.addData("Status", "Initilized");
        telemetry.update();



        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            Robot.turnLeft(1,1000);
            Robot.driveForward(1, 1000);

            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}