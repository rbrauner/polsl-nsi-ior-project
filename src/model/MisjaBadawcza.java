/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author User
 */
@Data
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "misja_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_MISJA_BADAWCZA_MISJA"))
@Table(name = "MISJA_BADAWCZA")
public class MisjaBadawcza extends Misja {
    @ToString.Exclude
    @OneToMany(mappedBy = "misjaBadawcza")
    private Set<Zadanie> zadanie = new HashSet<>();
}
