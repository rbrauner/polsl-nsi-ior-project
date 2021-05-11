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
public class LotTransportowy extends Misja {
    private List<Ladunek> ladunek;

    public List<Ladunek> getLadunek() {
        return ladunek;
    }

    public void setLadunek(List<Ladunek> ladunek) {
        this.ladunek = ladunek;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LotTransportowy{ladunek=").append(ladunek);
        sb.append('}');
        return sb.toString();
    }
}
