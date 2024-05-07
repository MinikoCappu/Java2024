package edu.phystech.hw4.stepper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kzlv4natoly
 */

public class Stepper {

    public enum Side {
        LEFT, RIGHT
    }

    private final List<Side> history = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isLeftTurn = true;

    public synchronized void leftStep() {

        try {
            while (!isLeftTurn) {
                wait();
            }
            history.add(Side.LEFT);
            isLeftTurn = false;
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void rightStep()  {
        try {
            while (isLeftTurn) {
                wait();
            }
            history.add(Side.RIGHT);
            isLeftTurn = true;
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public List<Side> getHistory() {
        return new ArrayList<>(history);
    }
}
