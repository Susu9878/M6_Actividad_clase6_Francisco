package com.backend.m6_activity.controllers;

import com.backend.m6_activity.services.BattleService;
import com.backend.m6_activity.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/battle")
public class BattleController {
    @Autowired
    private BattleService battleService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping("/listen/{battleId}")
    public String listen(@RequestParam String battleId){
        firebaseService.listenToBattle(battleId);
        return "Listening to batte " + battleId;
    }

    @PostMapping("/attack/{battleId}")
    public String attack(@RequestParam String battleId){
        battleService.attackBoss(battleId);
        return "Boss atacked";
    }
}