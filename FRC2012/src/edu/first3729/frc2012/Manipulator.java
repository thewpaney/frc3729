/*  ______ ______ ______ ______
 * |__    |      |__    |  __  |
 * |__    |_     |    __|__    |
 * |______| |____|______|______|
 */
package edu.first3729.frc2012;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @class Manipulator @brief Class that abstracts manipulator
 *
 * Manages assorted motor controllers to put balls in nets.
 */
public class Manipulator {

    private Talon shooter;
    private Talon climber;
    protected Relay loader;
    protected Relay tail;
    protected Relay wheel;
    protected Relay intake;

    public Manipulator() {
        shooter = new Talon(Params.shooter_victor_port);
        climber = new Talon(Params.climber_port);
        loader = new Relay(Params.loader_relay_port);
        tail = new Relay(Params.tail_relay_port);
        intake = new Relay(Params.intake_relay_port);
        wheel = new Relay(Params.wheel_relay_port);
    }

    public void init() {
        loader.setDirection(Relay.Direction.kBoth);
        loader.set(Relay.Value.kOff);
        tail.setDirection(Relay.Direction.kBoth);
        tail.set(Relay.Value.kOff);
        intake.setDirection(Relay.Direction.kBoth);
        intake.set(Relay.Value.kOff);
    }

    public void shoot(boolean state) {
        if (state) {
            shooter.set(Params.shooter1_speed);
        } else {
            shooter.set(0.0);
        }

    }

    public void load(boolean state) {
        if (state) {
            loader.set(Relay.Value.kForward);
        } else {
            loader.set(Relay.Value.kOff);
        }
    }

    public void intake(boolean state) {
        // Turn on until limit switch is pressed, then off
        if (state) {
            intake.set(Relay.Value.kForward);
        } else {
            intake.set(Relay.Value.kOff);
        }

    }

    public void tail(Relay.Value state) {
        tail.set(state);
    }

    public void wheel(Relay.Value state) {
        wheel.set(state);
    }
}
