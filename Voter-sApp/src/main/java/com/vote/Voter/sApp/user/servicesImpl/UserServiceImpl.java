package com.vote.Voter.sApp.user.servicesImpl;

import com.vote.Voter.sApp.user.dto.request.CreateUserRequest;
import com.vote.Voter.sApp.user.dto.response.CreateUserResponse;
import com.vote.Voter.sApp.user.exception.AlreadyExistException;
import com.vote.Voter.sApp.user.exception.NotFoundException;
import com.vote.Voter.sApp.user.models.UserModel;
import com.vote.Voter.sApp.user.repositories.UserRepository;
import com.vote.Voter.sApp.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        userExist(userRequest);

        return mapUserModelToResponse(userModel);
    }

    private void userExist(CreateUserRequest createUserRequest){
        boolean isUserExist = userRepository.existsByPvc(createUserRequest.getPvcNumber());
        if (isUserExist){
            throw new AlreadyExistException("User Already Exist");
        }
    }

    private UserModel createNewUser(CreateUserRequest createUserRequest){
        UserModel userModel = modelMapper.map(createUserRequest, UserModel.class);

    }

    private CreateUserResponse mapUserModelToResponse(UserModel userModel){
        return modelMapper.map(userModel, CreateUserResponse.class);
    }








    private UserModel getByPvc(String pvc){
        return userRepository.findByPvc(pvc).orElseThrow(
                ()-> new NotFoundException("User With The Provided PVC Number Not Found"));
    }
}
