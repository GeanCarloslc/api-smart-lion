package io.github.geancarloslc.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Column(name = "quantidade")
    private Long quantidade;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "valor_unitario", precision = 5, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "valor_unitario_estimado_venda", precision = 5, scale = 2)
    private BigDecimal valorUnitarioEstimadoVenda;

}
