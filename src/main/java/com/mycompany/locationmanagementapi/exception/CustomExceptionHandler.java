package com.mycompany.locationmanagementapi.exception;

import com.mycompany.locationmanagementapi.constant.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException be){

        for(ErrorModel errorModel: be.getErrorList()){
            logger.debug("Inside handleBusinessException: {},{}", errorModel.getCode(), errorModel.getMessage());
        }

        return new ResponseEntity<>(be.getErrorList(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<List<ErrorModel>> handleAllException(Exception ex){


        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(ErrorType.UNKNOWN_SERVER_ERROR.toString());
        errorModel.setMessage("Some unknown error occurred");

        logger.debug("Inside handleAllException: {},{}", errorModel.getCode(), errorModel.getMessage());
        errorModelList.add(errorModel);

        logger.error("Inside handleAllException: {},{}", ex.getMessage());
        return new ResponseEntity<>(errorModelList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
