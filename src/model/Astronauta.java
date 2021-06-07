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
@Table(name = "ASTRONAUTA")
public class Astronauta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "astronauta_id")
    private Integer id;
    private String imie;
    private String nazwisko;
    private String stopien;
    private Integer liczbaMisji;
    private Integer liczbaSpacerowKosmicznych;
    private AstronautaRola rola;

    @ToString.Exclude
    @ManyToMany(mappedBy = "astronauta")
    private Set<Misja> misja = new HashSet<>();
}
