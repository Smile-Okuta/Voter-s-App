package com.vote.Voter.sApp.pvc.services;

import com.vote.Voter.sApp.pvc.dto.request.LoginRequest;
import com.vote.Voter.sApp.pvc.dto.request.RegisterRequest;
import com.vote.Voter.sApp.pvc.dto.request.UpdateRequest;
import com.vote.Voter.sApp.pvc.dto.response.LoginResponse;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;
import com.vote.Voter.sApp.pvc.models.PvcModel;

import java.util.List;

public interface PvcService {
    RegisterResponse registerPvc (RegisterRequest createPvcRequest);
    List<PvcModel> getAllPvc();
    RegisterResponse getPvcById(Long id);

    RegisterResponse updatePvc(UpdateRequest updateRequest);


}
