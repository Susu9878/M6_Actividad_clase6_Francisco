package com.backend.m6_activity.controllers;

import com.backend.m6_activity.services.BattleService;
import com.backend.m6_activity.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/battle")
public class BattleController {
    @Autowired
    private BattleService battleService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping("/{battleId}")
    public Object getBattle(@PathVariable String battleId) {
        return firebaseService.getBattle(battleId);
    }

    @PostMapping("/reset/{battleId}")
    public String reset(@PathVariable String battleId) {
        battleService.resetBattle(battleId);
        return "Battle reset";
    }

    @PostMapping("/attack/{battleId}/{type}")
    public String attack(@PathVariable String battleId, @PathVariable String type) {
        battleService.attackBoss(battleId, type);
        return type + " atack";
    }
}