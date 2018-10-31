package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp

public class SlideTest extends LinearOpMode {
    //private Gyroscope imu;
    private DcMotor motorRight;



    public void runOpMode() {
        //imu = hardwareMap.get(Gyroscope.class, "imu");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");

        waitForStart();
        while (opModeIsActive()) {
            while (gamepad1.a) {
                motorRight.setPower(-1);

            }
            while (gamepad1.b) {
                motorRight.setPower(-1);

            }
            
        }
    }
        // run until the end of the match (driver presses STOP)








        }







