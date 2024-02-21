package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotOperationsTest {

    @Test
    public void testExcavateStonesForDays() {
        RobotOperations robotOperations = new RobotOperations();

        RobotPlan robotPlan1Day = robotOperations.excavateStonesForDays(1);
        assertEquals(1, robotPlan1Day.numberOfStones());

        RobotPlan robotPlan2Days = robotOperations.excavateStonesForDays(2);
        assertEquals(2, robotPlan2Days.numberOfStones());

        RobotPlan robotPlan5Days = robotOperations.excavateStonesForDays(5);
        assertEquals(16, robotPlan5Days.numberOfStones());
    }

    @Test
    public void testDaysRequiredToCollectStone() {
        RobotOperations robotOperations = new RobotOperations();

        RobotPlan robotPlan1Stone = robotOperations.daysRequiredToCollectStones(1);
        assertEquals(1, robotPlan1Stone.numberOfDays());

        RobotPlan robotPlan2Stones = robotOperations.daysRequiredToCollectStones(2);
        assertEquals(2, robotPlan2Stones.numberOfDays());

        RobotPlan robotPlan5Stones = robotOperations.daysRequiredToCollectStones(5);
        assertEquals(4, robotPlan5Stones.numberOfDays());

        RobotPlan robotPlan15Stones = robotOperations.daysRequiredToCollectStones(15);
        assertEquals(7, robotPlan15Stones.numberOfDays());

        RobotPlan robotPlan41Stones = robotOperations.daysRequiredToCollectStones(41);
        assertEquals(8, robotPlan41Stones.numberOfDays());

        RobotPlan robotPlan401Stones = robotOperations.daysRequiredToCollectStones(401);
        assertEquals(12, robotPlan401Stones.numberOfDays());
    }
}
