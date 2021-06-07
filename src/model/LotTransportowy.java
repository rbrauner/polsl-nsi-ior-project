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
import java.util.List;
import java.util.Set;

/**
 * @author User
 */
@Data
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "misja_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_LOT_TRANSPORTOWY_MISJA"))
@Table(name = "LOT_TRANSPORTOWY")
public class LotTransportowy extends Misja implements Serializable {
    @ToString.Exclude
    @OneToMany(mappedBy = "lotTransportowy")
    private Set<Ladunek> ladunek = new HashSet<>();
}
