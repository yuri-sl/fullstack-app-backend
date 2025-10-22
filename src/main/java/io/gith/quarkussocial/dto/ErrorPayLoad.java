package io.gith.quarkussocial.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorPayLoad {
    private String message;
    private int codigoErro;
}
