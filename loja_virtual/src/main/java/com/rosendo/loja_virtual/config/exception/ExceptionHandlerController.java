package com.rosendo.loja_virtual.config.exception;

import com.rosendo.loja_virtual.domain.usuario.exceptions.CredenciaisInvalidasException;
import com.rosendo.loja_virtual.domain.usuario.exceptions.ForbiddenException;
import com.rosendo.loja_virtual.domain.usuario.exceptions.IntegridadeDeSistemaException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> bindException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        ValidationError error = new ValidationError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                "Erro na validação de atributos");

        ex.getBindingResult().getFieldErrors().forEach(e ->
                error.addError(e.getField(), e.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                "Não encontrado",
                ex.getMessage() != null ? ex.getMessage() : "O recurso solicitado não foi encontrado."
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro de conversão de variável no path",
                "A variável no path não corresponde ao tipo esperado."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }


    @ExceptionHandler(IntegridadeDeSistemaException.class)
    public ResponseEntity<StandardError> integridadeDeSistemaException(IntegridadeDeSistemaException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Requisição inválida",
                ex.getMessage() != null ? ex.getMessage() : "A solicitação não pôde ser processada devido a uma violação de integridade do sistema."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<StandardError> invalidDataAccessApiUsageException(
            InvalidDataAccessApiUsageException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Requisição inválida",
                ex.getMessage() != null ? ex.getMessage() : "A solicitação não pôde ser processada devido a um uso inválido da API de acesso a dados."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> httpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Requisição inválida",
                ex.getMessage() != null ? ex.getMessage() : "Método HTTP não suportado para esta requisição."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> httpMessageNotReadableException(
            HttpMessageNotReadableException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Requisição inválida",
                ex.getMessage() != null ? ex.getMessage() : "A mensagem HTTP não pôde ser lida ou interpretada."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<StandardError> erroValidacaoCampos(ValidacaoException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Requisição inválida",
                ex.getMessage() != null ? ex.getMessage() : "Erro de validação dos campos."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<StandardError> usernameNotFoundException(UsernameNotFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.FORBIDDEN.value(),
                "Acesso negado",
                ex.getMessage() != null ? ex.getMessage() : "O usuário não foi encontrado."
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> expiredJwtException(AccessDeniedException ex, HttpServletRequest request) {
        StandardError error = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.UNAUTHORIZED.value(),
                "Não autorizado",
                ex.getMessage() != null ? ex.getMessage() : "Acesso negado."
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    @ExceptionHandler(CredenciaisInvalidasException.class)
    public ResponseEntity<StandardError> credenciaisInvalidasException(
            CredenciaisInvalidasException ex, HttpServletRequest request) {
        StandardError error = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                "Requisição inválida",
                ex.getMessage() != null ? ex.getMessage() : "Credenciais inválidas."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<StandardError> handleForbiddenException(
            ForbiddenException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.FORBIDDEN.value(),
                "Acesso proibido",
                ex.getMessage() != null ? ex.getMessage() : "Você não tem permissão para acessar este recurso."
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(standardError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex, HttpServletRequest request) {
        String message = "A operação não pode ser completada devido a um problema de integridade de dados.";

        // Verifica se a mensagem da exceção contém informação específica sobre a violação de chave única
        if (ex.getMessage() != null && ex.getMessage().contains("constraint")) {
            message = "Erro: O e-mail ou login já existe.";
        }

        StandardError error = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Entidade não processável",
                message
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<StandardError> handleInvalidDataAccessResourceUsageException(
            InvalidDataAccessResourceUsageException ex, HttpServletRequest request) {
        String message = "Erro no acesso ao recurso: ";

        // Verifica se a mensagem da exceção contém informação específica sobre a ausência da tabela "tb_role"
        if (ex.getMessage() != null && ex.getMessage().contains("relation \"tb_role\" does not exist")) {
            message += "A tabela 'tb_role' não existe no banco de dados.";
        } else {
            message += ex.getMessage();
        }

        StandardError error = new StandardError(
                LocalDateTime.now(),
                request.getRequestURI(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro Interno",
                message
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
