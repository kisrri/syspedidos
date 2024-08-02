package br.com.itilh.sistema.syspedidos.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "tb_produtos")
public class Produtos {

    @Id
    @SequenceGenerator(name = "produtos_id_seq", 
        sequenceName = "tb_produtos_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
        generator = "produtos_id_seq")
    private BigInteger id;

    @Column(name = "tx_descricao")
    private String descricao;

    @Column(name = "dbl_quantidade_estoq")
    private Double quantidadeEstoque;

    @Column(name = "nu_pre_un_atual")
    private BigDecimal precoUnidadeAtual;

    @Column(name = "bo_aitvo")
    private Boolean ativo;
}
