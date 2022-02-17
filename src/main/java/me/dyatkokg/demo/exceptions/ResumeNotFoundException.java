package me.dyatkokg.demo.exceptions;

public class ResumeNotFoundException extends RuntimeException{

    public ResumeNotFoundException(String id) {
        super(String.format("Resume with id %s was not found", id));
    }

    public ResumeNotFoundException(){
        super("Resume was not found");
    }
}
