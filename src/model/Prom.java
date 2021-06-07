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
@Table(name = "PROM")
public class Prom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prom_id")
    private Integer id;
    private String nazwa;
    private Integer rokProdukcji;
    private Integer ladownosc;
    private Integer liczbaCzlonkowZalogi;

    @ToString.Exclude
    @OneToMany(mappedBy = "prom")
    private Set<Misja> misja = new HashSet<>();
}
