package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/robot/operation")
public final class RobotRestController {

    RobotOperations robotOperations;

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")
    public ResponseEntity<RobotPlan> excavateStones(@RequestParam Integer numberOfDays) {
        RobotPlan robotPlan = new RobotPlan(numberOfDays,
                robotOperations.excavateStonesForDays(numberOfDays).numberOfStones(),
                robotOperations.excavateStonesForDays(numberOfDays).robotActions());
        return new ResponseEntity<>(robotPlan, HttpStatus.OK);
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    public ResponseEntity<RobotPlan> approximateDays(@RequestParam Integer numberOfStones) {
        RobotPlan robotPlan = new RobotPlan(robotOperations.daysRequiredToCollectStones(numberOfStones).numberOfDays(),
                numberOfStones, robotOperations.daysRequiredToCollectStones(numberOfStones).robotActions());
        return new ResponseEntity<>(robotPlan, HttpStatus.OK);
    }

}
