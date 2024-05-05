package sber.assignment.shoppinglist.service.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *  ErrorResponseException представляет объект, который используется для представления
 *   ошибок, возникающих в приложении, включая время возникновения ошибки и ее статус.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseException {
    private LocalDateTime timestamp;
    private int status;
}
