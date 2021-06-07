/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author User
 */
@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "ZADANIE")
public class Zadanie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zadanie_id")
    private Integer id;
    private String nazwa;
    private String opis;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "misja_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_ZADANIE_MISJA"))
    private MisjaBadawcza misjaBadawcza;
}
