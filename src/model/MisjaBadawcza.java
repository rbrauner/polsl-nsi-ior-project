    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package model;

    import org.hibernate.annotations.Cascade;
    import org.hibernate.annotations.CascadeType;

    import javax.persistence.*;
    import java.util.List;
    import java.util.Set;

    /**
     * @author User
     */
    @Entity
    @PrimaryKeyJoinColumn(name = "ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_MISJA_BADAWCZA_MISJA"))
    @Table(name = "MISJA_BADAWCZA")
    public class MisjaBadawcza extends Misja {
        @OneToMany(mappedBy = "misja")
        private Set<Zadanie> zadanie;

        public Set<Zadanie> getZadanie() {
            return zadanie;
        }

        public void setZadanie(Set<Zadanie> zadanie) {
            this.zadanie = zadanie;
        }

        @Override
        public String toString() {
            return "MisjaBadawcza{" +
//                    "zadanie=" + zadanie +
                    '}';
        }
    }
