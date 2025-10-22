package io.gith.quarkussocial.dto.Post;

import io.gith.quarkussocial.domain.module.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CreatePostRequest {
    @NotBlank(message="Insira um texto para a mensagem")
    private String post_text;
    private Long post_id;
    private LocalDateTime date_time;
    private User user;
}
