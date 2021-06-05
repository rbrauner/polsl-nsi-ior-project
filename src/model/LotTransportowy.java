    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package model;

    import org.hibernate.annotations.Cascade;

    import javax.persistence.*;
    import java.io.Serializable;
    import java.util.List;
    import java.util.Set;

    /**
     * @author User
     */
    @Entity
    @PrimaryKeyJoinColumn(name = "misja_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_LOT_TRANSPORTOWY_MISJA"))
    @Table(name = "LOT_TRANSPORTOWY")
    public class LotTransportowy extends Misja implements Serializable {
        @OneToMany(mappedBy = "misja")
        private Set<Ladunek> ladunek;

        public Set<Ladunek> getLadunek() {
            return ladunek;
        }

        public void setLadunek(Set<Ladunek> ladunek) {
            this.ladunek = ladunek;
        }

        @Override
        public String toString() {
            return "LotTransportowy{" +
//                    "ladunek=" + ladunek +
                    '}';
        }
    }
