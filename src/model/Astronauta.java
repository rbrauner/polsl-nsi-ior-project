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
public class Astronauta {
    private Integer id;
    private String imie;
    private String nazwisko;
    private String stopien;
    private Integer liczbaMisji;
    private Integer liczbaSpacerowKosmicznych;

    public Integer getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getStopien() {
        return stopien;
    }

    public Integer getLiczbaMisji() {
        return liczbaMisji;
    }

    public Integer getLiczbaSpacerowKosmicznych() {
        return liczbaSpacerowKosmicznych;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setStopien(String stopien) {
        this.stopien = stopien;
    }

    public void setLiczbaMisji(Integer liczbaMisji) {
        this.liczbaMisji = liczbaMisji;
    }

    public void setLiczbaSpacerowKosmicznych(Integer liczbaSpacerowKosmicznych) {
        this.liczbaSpacerowKosmicznych = liczbaSpacerowKosmicznych;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Astronauta{id=").append(id);
        sb.append(", imie=").append(imie);
        sb.append(", nazwisko=").append(nazwisko);
        sb.append(", stopien=").append(stopien);
        sb.append(", liczbaMisji=").append(liczbaMisji);
        sb.append(", liczbaSpacerowKosmicznych=").append(liczbaSpacerowKosmicznych);
        sb.append('}');
        return sb.toString();
    }
}
