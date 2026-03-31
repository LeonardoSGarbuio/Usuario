package com.javanauta.Usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telefones")
@Builder

public class Telefones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", length = 12)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;

}
