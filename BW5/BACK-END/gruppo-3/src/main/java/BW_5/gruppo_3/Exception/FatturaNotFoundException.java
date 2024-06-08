package BW_5.gruppo_3.Exception;

public class FatturaNotFoundException extends RuntimeException{
    public FatturaNotFoundException(String message){
        super(message);
    }
}
