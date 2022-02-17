package me.dyatkokg.demo.exceptions;

public class FieldEmptiesException extends RuntimeException{

    public FieldEmptiesException(){
        super("Field personal data and contacts cannot be empty");
    }

}
