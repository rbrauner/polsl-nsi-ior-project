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
import java.util.Set;

/**
 * @author User
 */
@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "LADUNEK")
public class Ladunek implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ladunek_id")
    private Integer id;
    private LadunekTyp typ;
    private String uwagi;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "misja_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_LADUNEK_MISJA"))
    private LotTransportowy lotTransportowy;
}
