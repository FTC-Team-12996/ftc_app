package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.tools.javac.comp.Lower;

@TeleOp

public class TankDrive extends LinearOpMode {
    //private Gyroscope imu;
    private DcMotor motorRight;
    private DcMotor motorLeft;
    private DcMotor collectorMotor;
    private DcMotor slideMotor;
    private Servo servo1;
    private DcMotor MoveBucket;
    private DcMotor RaiseHook;
    private DcMotor LowerHook;

    //Encoders
    int TETRIX_TICKS_PER_REV = 1440;

    boolean BucketRaiseMax = false;
    boolean HookMax = false;


    public void runOpMode() {
        //imu = hardwareMap.get(Gyroscope.class, "imu");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        collectorMotor = hardwareMap.get(DcMotor.class, "collectorMotor");
        slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");
        RaiseHook = hardwareMap.get(DcMotor.class, "RaiseHook");
        LowerHook = hardwareMap.get(DcMotor.class, "LowerHook");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPower = 0;
        double tgtPower2 = 0;
        while (opModeIsActive()) {
            tgtPower = -this.gamepad2.left_stick_y;
            motorRight.setPower(tgtPower);
            motorLeft.setPower(-tgtPower);


            tgtPower2 = this.gamepad2.right_stick_y;
            collectorMotor.setPower(tgtPower2);

            while (gamepad2.right_stick_button) {
                collectorMotor.setPower(1);
            }
            while (gamepad2.left_stick_button) {
                collectorMotor.setPower(-1);
            }


            while (gamepad2.y) {
                slideMotor.setPower(.7);
                while (gamepad2.x) {
                    slideMotor.setPower(-.7);
                }
                while (gamepad2.b) {
                    slideMotor.setPower(0);
                }
                while (gamepad2.left_bumper) {
                    RaiseHook.setPower(.7);
                }
                while (gamepad2.right_bumper) {
                    LowerHook.setPower(-.7);
                }


                    while (gamepad1.dpad_down) {
                        motorLeft.setPower(1);
                        motorRight.setPower(-1);
                    }
                    while (gamepad1.dpad_up) {
                        motorRight.setPower(-1);
                        motorLeft.setPower(1);
                    }
                    while (gamepad1.dpad_left) {
                        motorRight.setPower(1);
                        motorLeft.setPower(1);
                    }
                    while (gamepad1.dpad_right) {
                        motorRight.setPower(-1);
                        motorLeft.setPower(-1);
                    }
                    while (gamepad2.dpad_down) {
                        servo1.setPosition(1);
                    }
                    while (gamepad2.dpad_left) {
                        servo1.setPosition(-1);
                    }
                    //1140


                    telemetry.addData("Target Power", tgtPower);
                    telemetry.addData("motorTest Power", motorRight.getPower());
                    //motorTest for tank drive

                    telemetry.addData("Target Power 2", tgtPower2);
                    telemetry.addData("motor2 Power", motorLeft.getPower());
                    //motor2 for tank drive

                    telemetry.addData("Status", "Running");
                    telemetry.update();

                }
            }
        }
    }





