package com.rosendo.loja_virtual.config.exception;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {


    private static final long serialVersionUID = 1L;

    private List<FieldError> erros = new ArrayList<>();

    public List<FieldError> getErros() {
        return erros;
    }

    public void setErros(List<FieldError> erros) {
        this.erros = erros;
    }

    ValidationError(LocalDateTime timestamp, String path, Integer status, String error, String message) {
        super(timestamp, path, status, error, message);
    }



    public void addError(String fieldName, String message) {
        this.erros.add(new FieldError(fieldName, message));
    }



    private static final class FieldError{
        private String fieldName;
        private String message;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public FieldError(String fieldName, String message) {
            this.fieldName = fieldName;
            this.message = message;
        }
    }


}