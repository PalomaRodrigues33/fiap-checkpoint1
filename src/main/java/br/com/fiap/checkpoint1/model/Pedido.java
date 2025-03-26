package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório.")
    @Column(nullable = false)
    private String clienteNome;

    @Column(nullable = false)
    private LocalDate dataPedido = LocalDate.now();

    @Min(value = 0, message = "O valor total não pode ser negativo.")
    @Column(nullable = false)
    private double valorTotal;
}