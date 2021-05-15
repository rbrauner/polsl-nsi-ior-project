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

        @ManyToMany
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        @JoinTable(name = "MISJA_ASTRONAUTA", joinColumns = @JoinColumn(name = "misja_id"), inverseJoinColumns = @JoinColumn(name = "astronauta_id"), foreignKey = @javax.persistence.ForeignKey(name = "FK_MISJA_ASTRONAUTA"))
        private Set<Misja> misja;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        public String getStopien() {
            return stopien;
        }

        public void setStopien(String stopien) {
            this.stopien = stopien;
        }

        public Integer getLiczbaMisji() {
            return liczbaMisji;
        }

        public void setLiczbaMisji(Integer liczbaMisji) {
            this.liczbaMisji = liczbaMisji;
        }

        public Integer getLiczbaSpacerowKosmicznych() {
            return liczbaSpacerowKosmicznych;
        }

        public void setLiczbaSpacerowKosmicznych(Integer liczbaSpacerowKosmicznych) {
            this.liczbaSpacerowKosmicznych = liczbaSpacerowKosmicznych;
        }

        public AstronautaRola getRola() {
            return rola;
        }

        public void setRola(AstronautaRola rola) {
            this.rola = rola;
        }

        public Set<Misja> getMisja() {
            return misja;
        }

        public void setMisja(Set<Misja> misja) {
            this.misja = misja;
        }

        @Override
        public String toString() {
            return "Astronauta{" +
                    "id=" + id +
                    ", imie='" + imie + '\'' +
                    ", nazwisko='" + nazwisko + '\'' +
                    ", stopien='" + stopien + '\'' +
                    ", liczbaMisji=" + liczbaMisji +
                    ", liczbaSpacerowKosmicznych=" + liczbaSpacerowKosmicznych +
                    ", rola=" + rola +
//                    ", misja=" + misja +
                    '}';
        }
    }
