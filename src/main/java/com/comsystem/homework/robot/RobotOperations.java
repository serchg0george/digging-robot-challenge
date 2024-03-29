package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     *
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     * algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     * number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     * days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        List<RobotAction> robotActions = new ArrayList<>();
        int numberOfStones = 2;
        if (days == 1) {
            robotActions.add(RobotAction.DIG);
            return new RobotPlan(1, 1, robotActions);
        } else if (days == 2) {
            robotActions.add(RobotAction.DIG);
            robotActions.add(RobotAction.DIG);
            return new RobotPlan(2, numberOfStones, robotActions);
        } else {
            robotActions.add(RobotAction.DIG);
            robotActions.add(RobotAction.DIG);
            for (int i = 0; i < days - 2; i++) {
                robotActions.add(RobotAction.CLONE);
                numberOfStones *= 2;
            }
        }

        return new RobotPlan(days, numberOfStones, robotActions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     *
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     * provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     * {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     * {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        List<RobotAction> robotActions = new ArrayList<>();
        int neededDays = 0;

        while (numberOfStones > 0) {
            if (numberOfStones == 1) {
                robotActions.add(RobotAction.DIG);
                numberOfStones--;
                neededDays++;
            } else if (numberOfStones % 2 == 0) {
                robotActions.add(RobotAction.CLONE);
                numberOfStones /= 2;
                neededDays++;
            } else {
                robotActions.add(RobotAction.DIG);
                numberOfStones--;
                neededDays++;
            }
        }

        return new RobotPlan(neededDays, numberOfStones, robotActions);
    }

}
