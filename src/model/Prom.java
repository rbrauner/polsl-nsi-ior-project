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

        @OneToMany(mappedBy = "prom")
        private Set<Misja> misja;

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

        public Integer getRokProdukcji() {
            return rokProdukcji;
        }

        public void setRokProdukcji(Integer rokProdukcji) {
            this.rokProdukcji = rokProdukcji;
        }

        public Integer getLadownosc() {
            return ladownosc;
        }

        public void setLadownosc(Integer ladownosc) {
            this.ladownosc = ladownosc;
        }

        public Integer getLiczbaCzlonkowZalogi() {
            return liczbaCzlonkowZalogi;
        }

        public void setLiczbaCzlonkowZalogi(Integer liczbaCzlonkowZalogi) {
            this.liczbaCzlonkowZalogi = liczbaCzlonkowZalogi;
        }

        public Set<Misja> getMisja() {
            return misja;
        }

        public void setMisja(Set<Misja> misja) {
            this.misja = misja;
        }

        @Override
        public String toString() {
            return "Prom{" +
                    "id=" + id +
                    ", nazwa='" + nazwa + '\'' +
                    ", rokProdukcji=" + rokProdukcji +
                    ", ladownosc=" + ladownosc +
                    ", liczbaCzlonkowZalogi=" + liczbaCzlonkowZalogi +
//                    ", misja=" + misja +
                    '}';
        }
    }
