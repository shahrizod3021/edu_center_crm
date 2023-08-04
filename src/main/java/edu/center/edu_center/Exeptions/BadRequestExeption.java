package edu.center.edu_center.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class  BadRequestExeption  extends RuntimeException{
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public BadRequestExeption(String message) {
        super(message);
    }
}
