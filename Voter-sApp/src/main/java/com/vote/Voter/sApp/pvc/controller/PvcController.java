package com.vote.Voter.sApp.pvc.controller;

import com.vote.Voter.sApp.pvc.services.PvcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/pvc")
public class PvcController {
    private final PvcService pvcService;

    @PostMapping
    public String register(){

    }


}
