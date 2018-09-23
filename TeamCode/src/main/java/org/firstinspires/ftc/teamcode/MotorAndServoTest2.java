package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class MotorAndServoTest2 extends LinearOpMode {
    // private Gyroscope imu;
    private DcMotor motorTest;
    private DcMotor motor2;
    // private DigitalChannel digitalTouch;
    // private DistanceSensor sensorColorRange;
    private Servo servoTest;


    @Override
    public void runOpMode() {
        //  imu = hardwareMap.get(Gyroscope.class, "imu");
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        //  digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        //  sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)

        double tgtPower = 0; // Uses y-value on gamepad-leftStick to control DC Motor
        double tgtPower2 = 0;

        while (opModeIsActive()) {
            tgtPower = -this.gamepad1.left_stick_y;
            motorTest.setPower(tgtPower);

            tgtPower2 = -this.gamepad1.right_stick_y;
            motor2.setPower(tgtPower2);

            if(gamepad1.a){
                motorTest.setPower(1);
                motor2.setPower(1);
            }
            else if(gamepad1.dpad_down){
                motorTest.setPower(-1);
                motor2.setPower(-1);
            }

//            if(gamepad1.y) {
//                // move to 0 degrees.
//                servoTest.setPosition(0);
//            } else if (gamepad1.x || gamepad1.b) {
//                // move to 90 degrees.
//                servoTest.setPosition(0.5);
//            } else if (gamepad1.a) {
//                // move to 180 degrees.
//                servoTest.setPosition(1);
//            }

            telemetry.addData("Target Power 1", tgtPower);
            telemetry.addData("Motor  1 Power", motorTest.getPower());
            telemetry.addData("Status", "Running");
            telemetry.addData("Servo Position", servoTest.getPosition());
            telemetry.addData("Target Power 2", tgtPower);
            telemetry.addData("Motor 2 Power", motor2.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

        }


    }
}