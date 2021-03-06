package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class AutoZone extends LinearOpMode {
        private DcMotor motorRight;
        private DcMotor motorLeft;




        @Override
        public void runOpMode() {
            IRobot Robot= new Prototype(hardwareMap);
            motorRight = hardwareMap.get(DcMotor.class, "motorRight");
            motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
           // motor3 = hardwareMap.get(DcMotor.class, "motor3");
            //telemetry.addData("Status", "Initialized");
            //telemetry.update();
            // Wait for the game to start (driver presses PLAY)
            waitForStart();
        //  motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        //motor2 = hardwareMap.get(DcMotor.class, "motor2")


            Robot.driveForward(1, 4000);

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {
                telemetry.addData("Status", "Running");
                telemetry.update();


            }

        }
    }
