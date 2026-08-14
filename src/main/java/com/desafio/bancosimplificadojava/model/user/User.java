package com.desafio.bancosimplificadojava.model.user;

import com.desafio.bancosimplificadojava.dtos.CreateUserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private String fullName;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType type;

    public User(CreateUserDTO dto) {
        setDocument(dto.document());
        setEmail(dto.email());
        setPassword(dto.password());
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
        setFullName(dto.firstName() + " " + dto.lastName());
        setBalance(new BigDecimal(1000));
        setType(dto.type());
    }

    public void decreaseBalance(BigDecimal amount) {
        this.setBalance(this.getBalance().subtract(amount));
    }

    public void increaseBalance(BigDecimal amount) {
        this.setBalance(this.getBalance().add(amount));
    }
}
