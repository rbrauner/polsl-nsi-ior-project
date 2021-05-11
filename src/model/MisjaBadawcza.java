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
public class MisjaBadawcza extends Misja {
    private List<Zadanie> zadanie;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MisjaBadawcza{zadanie=").append(zadanie);
        sb.append('}');
        return sb.toString();
    }

    public List<Zadanie> getZadanie() {
        return zadanie;
    }

    public void setZadanie(List<Zadanie> zadanie) {
        this.zadanie = zadanie;
    }
}
