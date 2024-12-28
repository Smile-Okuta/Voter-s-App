package com.vote.Voter.sApp.pvc.services;

import com.vote.Voter.sApp.pvc.dto.request.CreatePvc;
import com.vote.Voter.sApp.pvc.dto.request.UpdateRequest;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;
import com.vote.Voter.sApp.pvc.models.PvcModel;

import java.util.List;

public interface PvcService {
    RegisterResponse registerPvc (CreatePvc createPvcRequest);
    List<PvcModel> getAllPvc();
    RegisterResponse getPvcById(Long id);

    RegisterResponse updatePvc(UpdateRequest updateRequest);


}
