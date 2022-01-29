package com.example.IBAN;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
public class Iban {

    @Id
    @SequenceGenerator(
            name = "iban_sequence",
            sequenceName = "iban_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "iban_sequence"
    )
    private Long id;
    private String iban;
    private Integer valid;

    public Iban() {
    }

    public Iban(Long id, String iban, Integer valid) {
        this.id = id;
        this.iban = iban;
        this.valid = valid;
    }

    public Iban(String iban, Integer valid) {
        this.iban = iban;
        this.valid = valid;
    }

    public Iban(String iban) {
        this.iban = iban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Iban{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", valid=" + valid +
                '}';
    }
}
