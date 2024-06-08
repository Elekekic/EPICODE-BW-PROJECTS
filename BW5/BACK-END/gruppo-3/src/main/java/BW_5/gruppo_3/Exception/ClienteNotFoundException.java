package BW_5.gruppo_3.Exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String message){
        super(message);
    }
}
