/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author User
 */
public class Misja {

    private Integer id;
    private MisjaCel cel;
    private String uwagi;
    private List<Astronauta> astronauta;
    private List<Prom> prom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MisjaCel getCel() {
        return cel;
    }

    public void setCel(MisjaCel cel) {
        this.cel = cel;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public List<Astronauta> getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(List<Astronauta> astronauta) {
        this.astronauta = astronauta;
    }

    public List<Prom> getProm() {
        return prom;
    }

    public void setProm(List<Prom> prom) {
        this.prom = prom;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Misja{id=").append(id);
        sb.append(", cel=").append(cel);
        sb.append(", uwagi=").append(uwagi);
        sb.append(", astronauta=").append(astronauta);
        sb.append(", prom=").append(prom);
        sb.append('}');
        return sb.toString();
    }

}
