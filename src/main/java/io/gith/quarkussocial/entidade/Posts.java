package io.gith.quarkussocial.entidade;

import io.gith.quarkussocial.domain.module.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="posts")
@Data
public class Posts extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="post_text")
    private String post_text;

    @Column(name="date_time")
    private LocalDateTime date_time;

    @ManyToOne//N postagens para 1 usuários
    @JoinColumn(name="user_id")
    private User user;

}
