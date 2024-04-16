package com.vote.Voter.sApp.pvc.services;

import com.vote.Voter.sApp.pvc.dto.request.LoginRequest;
import com.vote.Voter.sApp.pvc.dto.request.RegisterRequest;
import com.vote.Voter.sApp.pvc.dto.response.LoginResponse;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;

public interface PvcService {
    RegisterResponse registerPvc (RegisterRequest createPvcRequest);


}
