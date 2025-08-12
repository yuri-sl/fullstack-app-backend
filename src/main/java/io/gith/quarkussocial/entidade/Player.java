package io.gith.quarkussocial.entidade;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "player")

public class Player extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long player_id;

    @Column(name = "player_name")
    private String player_name;

    @Column(name = "player_mail")
    private String player_mail;

    @Column(name = "hire_date")
    private LocalDate hire_date;

    @Column (name = "experience_points")
    private float experience_points;


}
