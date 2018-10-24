package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.internal.android.dx.rop.type.Prototype;


@Autonomous
public class AutoZone extends LinearOpMode {
       // private DcMotor motorTest;
        //private DcMotor motor2;
        //private DcMotor motor3;



        @Override
        public void runOpMode() {

          //  motorTest = hardwareMap.get(DcMotor.class, "motorTest");
            //motor2 = hardwareMap.get(DcMotor.class, "motor2");
           // motor3 = hardwareMap.get(DcMotor.class, "motor3");
IRobot Robot=new Prototype();

            //telemetry.addData("Status", "Initialized");
            //telemetry.update();
            // Wait for the game to start (driver presses PLAY)
            waitForStart();

Robot.driveForward();



            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {
                telemetry.addData("Status", "Running");
                telemetry.update();

            }
        }
    }
