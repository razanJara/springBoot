package management.device.Advisor;

import lombok.extern.log4j.Log4j2;
import management.device.Exception.BusinessException;
import management.device.Exception.TechnicalException;
import management.device.dto.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice
public class DeviceManagementAdvisor {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {
        log.error(ex);

        var response = ErrorResponse.builder()
                .time(LocalDateTime.now())
                .massage("Can not handle the request!!!!!")
                .details(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ErrorResponse> handleTechnicalException(TechnicalException ex) {
        log.error(ex);
        var response = ErrorResponse.builder()
                .time(LocalDateTime.now())
                .massage("Failed to handle the request")
                .build();
        return ResponseEntity.badRequest()
                .body(response);
    }
}
