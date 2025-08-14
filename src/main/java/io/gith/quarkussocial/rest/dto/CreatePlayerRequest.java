package io.gith.quarkussocial.rest.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatePlayerRequest {
    private String player_name;
    private String player_mail;
    private LocalDate hire_date;
    private float experience_points;
}
