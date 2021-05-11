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
public class Ladunek {
    private Integer id;
    private LadunekTyp typ;
    private String uwagi;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ladunek{id=").append(id);
        sb.append(", typ=").append(typ);
        sb.append(", uwagi=").append(uwagi);
        sb.append('}');
        return sb.toString();
    }
}
