    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Prom {
    private Integer id;
    private String nazwa;
    private Integer rokProdukcji;
    private Integer ladownosc;
    private Integer liczbaCzlonkowZalogi;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prom{id=").append(id);
        sb.append(", nazwa=").append(nazwa);
        sb.append(", rokProdukcji=").append(rokProdukcji);
        sb.append(", ladownosc=").append(ladownosc);
        sb.append(", liczbaCzlonkowZalogi=").append(liczbaCzlonkowZalogi);
        sb.append('}');
        return sb.toString();
    }
}
