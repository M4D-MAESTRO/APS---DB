package com.pdv.model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codCli;
    private String nome;
    private Long bonus;
    private Character perfil;
    private Character condicao;

    public Cliente() {
    }

    public Cliente(Integer codCli, String nome, Long bonus, Character perfil, Character condicao) {
        this.codCli = codCli;
        this.nome = nome;
        this.bonus = bonus;
        this.perfil = perfil;
        this.condicao = condicao;
    }

    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
        this.codCli = codCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Character getPerfil() {
        return perfil;
    }

    public void setPerfil(Character perfil) {
        this.perfil = perfil;
    }

    public Character getCondicao() {
        return condicao;
    }

    public void setCondicao(Character condicao) {
        this.condicao = condicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codCli);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.codCli, other.codCli)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente " + nome + "\n"
                + "Código: " + codCli + "\n"
                + "Bónus atual: " + bonus + "\n"
                + "Perfil: " + perfil + "\n"
                + "Condição: " + (condicao == 'A' ? "Ativo" : "Inativo") + "\n";
    }

}
