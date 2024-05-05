package sber.assignment.shoppinglist.service.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponseException {
    private LocalDateTime timestamp;
    private int status;
}
