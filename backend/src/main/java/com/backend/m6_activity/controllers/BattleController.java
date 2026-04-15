package com.backend.m6_activity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.backend.m6_activity.models.Boss;
import com.backend.m6_activity.services.BattleConsultService;
import com.backend.m6_activity.services.BattleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BattleController {
    @Autowired
    private BattleService battleService;

    @GetMapping("/battle/stream")
    public SseEmitter streamBatalla() {
        return battleService.agregarCliente();
    }

    @Autowired
    private BattleConsultService battleConsultService;

    @GetMapping("/api/boss/vida")
    public String getBossLife() throws Exception {
        return BattleConsultService.getVidaBoss();
    }
    
    @PostMapping("/api/addBoss")
    public Boss postBoss(@RequestBody Boss boss) throws Exception{
        //TODO: process POST request
        
        return battleConsultService.saveBoss(boss);
    }
    
}
