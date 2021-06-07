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
import java.util.HashSet;
import java.util.Set;

/**
 * @author User
 */
@Data
@RequiredArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MISJA")
public class Misja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "misja_id")
    private Integer id;

    private MisjaCel cel;
    private String uwagi;

    @ToString.Exclude
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "MISJA_ASTRONAUTA", joinColumns = @JoinColumn(name = "misja_id"), inverseJoinColumns = @JoinColumn(name = "astronauta_id"), foreignKey = @javax.persistence.ForeignKey(name = "FK_MISJA_ASTRONAUTA"), inverseForeignKey = @javax.persistence.ForeignKey(name = "FK_ASTRONAUTA_MISJA"))
    private Set<Astronauta> astronauta = new HashSet<>();

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "prom_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_MISJA_PROM"))
    private Prom prom;
}
