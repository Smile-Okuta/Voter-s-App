package com.vote.Voter.sApp.ballot.exception;

public class BallotNotFoundException extends RuntimeException {
    public BallotNotFoundException(String message){
        super(message);
    }
}
