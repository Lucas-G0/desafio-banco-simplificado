package com.desafio.bancosimplificadojava.model.transaction;

import com.desafio.bancosimplificadojava.dtos.CreateTransactionDTO;
import com.desafio.bancosimplificadojava.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private BigDecimal amount;

    @ManyToOne
    private User receiver;
    @ManyToOne
    private User sender;

    public Transaction(CreateTransactionDTO dto) {
        this.amount = dto.value();
        this.receiver = dto.payee();
        this.sender = dto.payer();
        this.date = LocalDateTime.now();
    }
}
