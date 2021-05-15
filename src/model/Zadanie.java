    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package model;

    import org.hibernate.annotations.Cascade;

    import javax.persistence.*;
    import java.io.Serializable;

    /**
     * @author User
     */
    @Entity
    @Table(name = "ZADANIE")
    public class Zadanie implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "zadanie_id")
        private Integer id;
        private String nazwa;
        private String opis;

        @ManyToOne
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        @JoinColumn(name = "misja_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_ZADANIE_MISJA"))
        private Misja misja;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNazwa() {
            return nazwa;
        }

        public void setNazwa(String nazwa) {
            this.nazwa = nazwa;
        }

        public String getOpis() {
            return opis;
        }

        public void setOpis(String opis) {
            this.opis = opis;
        }

        public Misja getMisja() {
            return misja;
        }

        public void setMisja(Misja misja) {
            this.misja = misja;
        }

        @Override
        public String toString() {
            return "Zadanie{" +
                    "id=" + id +
                    ", nazwa='" + nazwa + '\'' +
                    ", opis='" + opis + '\'' +
//                    ", misja=" + misja +
                    '}';
        }
    }
