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
        private Misja misja;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public LadunekTyp getTyp() {
            return typ;
        }

        public void setTyp(LadunekTyp typ) {
            this.typ = typ;
        }

        public String getUwagi() {
            return uwagi;
        }

        public void setUwagi(String uwagi) {
            this.uwagi = uwagi;
        }

        public Misja getMisja() {
            return misja;
        }

        public void setMisja(Misja misja) {
            this.misja = misja;
        }

        @Override
        public String toString() {
            return "Ladunek{" +
                    "id=" + id +
                    ", typ=" + typ +
                    ", uwagi='" + uwagi + '\'' +
//                    ", misja=" + misja +
                    '}';
        }
    }
