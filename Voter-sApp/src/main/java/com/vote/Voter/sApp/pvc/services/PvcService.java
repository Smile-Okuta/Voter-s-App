package com.vote.Voter.sApp.pvc.services;

import com.vote.Voter.sApp.pvc.dto.request.LoginRequest;
import com.vote.Voter.sApp.pvc.dto.request.Register;
import com.vote.Voter.sApp.pvc.dto.response.LoginResponse;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;

public interface PvcService {
    RegisterResponse register (Register createPvcRequest);

    LoginResponse loginMessage(LoginRequest loginRequest);

}
