/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author User
 */
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

    @ManyToMany(mappedBy = "misja")
    private Set<Astronauta> astronauta;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "prom_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_MISJA_PROM"))
    private Prom prom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MisjaCel getCel() {
        return cel;
    }

    public void setCel(MisjaCel cel) {
        this.cel = cel;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public Set<Astronauta> getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Set<Astronauta> astronauta) {
        this.astronauta = astronauta;
    }

    public Prom getProm() {
        return prom;
    }

    public void setProm(Prom prom) {
        this.prom = prom;
    }

    @Override
    public String toString() {
        return "Misja{" +
                "id=" + id +
                ", cel=" + cel +
                ", uwagi='" + uwagi + '\'' +
//                ", astronauta=" + astronauta +
//                ", prom=" + prom +
                '}';
    }
}
