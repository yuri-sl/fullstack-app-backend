package io.gith.quarkussocial.entidade;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="cliente")

public class Cliente extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "id_cliente" )
    private Long id_cliente;

    @Column(name = "nome_cliente")
    private String nome_cliente;

    @Column(name = "email_cliente")
    private String email_cliente;

    @Column(name = "senha_cliente")
    private String senha_cliente;
}
