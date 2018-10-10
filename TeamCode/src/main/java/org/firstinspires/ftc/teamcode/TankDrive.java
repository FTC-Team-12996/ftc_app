package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class TankDrive extends LinearOpMode {
    //private Gyroscope imu;
    private DcMotor motorTest;
    private DcMotor motor2;
    private DcMotor motor3;
    //private DigitalChannel digitalTouch;
    //private DistanceSensor sensorColorRange;


    public void runOpMode() {
        //imu = hardwareMap.get(Gyroscope.class, "imu");
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPower = 0;
        double tgtPower2 = 0;
       while (opModeIsActive()) {
            tgtPower = -this.gamepad1.left_stick_y;
            motorTest.setPower(tgtPower);
           motor2.setPower(tgtPower);

            tgtPower2 = this.gamepad1.right_stick_y;
            motor3.setPower(tgtPower2);

           while(gamepad1.a){
                motorTest.setPower(-1);
                motor2.setPower(-1);
            }

            while(gamepad1.dpad_down){
                motorTest.setPower(1);
                motor2.setPower(-1);
            }
            while(gamepad1.dpad_up){
                motorTest.setPower(-1);
                motor2.setPower(1);
            }
           while (gamepad1.dpad_left) {
                motorTest.setPower(1);
                motor2.setPower(1);
            }
           while(gamepad1.dpad_right) {
                motorTest.setPower(-1);
                motor2.setPower(-1);
            }





            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("motorTest Power", motorTest.getPower());
            //motorTest for tank drive

            telemetry.addData("Target Power 2", tgtPower2);
            telemetry.addData("motor2 Power", motor2.getPower());
            //motor2 for tank drive

            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}




/* turn the motor so that the tank treads will roll in the direction we want.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// add more comments describing what each line of code does.
 */