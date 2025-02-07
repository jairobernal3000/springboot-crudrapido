package com.example.crudrapido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Data
@NoArgsConstructor  // 🔹 Agregado para permitir la deserialización
@AllArgsConstructor
@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String firstName;

    private String lastName;

    @Column(name = "email_address", unique = true, nullable = false)
    private String email;
}
