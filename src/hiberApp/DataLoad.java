/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

/*
 @author LabHiber RaU7
 */
public final class DataLoad {

    /**
     * Creates test data
     *
     * @param SESSION_FACTORY for connecting data source
     */

    static Logger log = LoggerFactory.getLogger(DataLoad.class);

    protected void createData(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = null;
            try {
                log.trace("insert prom transaction begin");
                tx = session.beginTransaction();
                Prom prom1 = new Prom();
                prom1.setNazwa("Prom 1");
                prom1.setLadownosc(10);
                prom1.setRokProdukcji(1980);
                prom1.setLiczbaCzlonkowZalogi(100);
                session.save(prom1);
                Prom prom2 = new Prom();
                prom2.setNazwa("Prom 2");
                prom2.setLadownosc(20);
                prom2.setRokProdukcji(2100);
                prom2.setLiczbaCzlonkowZalogi(5000);
                session.save(prom2);
                tx.commit();
                log.trace("insert prom transaction commit");

                log.trace("insert lotTransportowy transaction begin");
                tx = session.beginTransaction();
                LotTransportowy lotTransportowy1 = new LotTransportowy();
                lotTransportowy1.setUwagi("Brak");
                lotTransportowy1.setProm(prom1);
                lotTransportowy1.setCel(MisjaCel.MARS);
                session.save(lotTransportowy1);
                LotTransportowy lotTransportowy2 = new LotTransportowy();
                lotTransportowy2.setUwagi("Brak");
                lotTransportowy2.setProm(prom2);
                lotTransportowy2.setCel(MisjaCel.ISS);
                session.save(lotTransportowy2);
                tx.commit();
                log.trace("insert lotTransportowy transaction commit");

                log.trace("insert misjaBadawcza transaction begin");
                tx = session.beginTransaction();
                MisjaBadawcza misjaBadawcza1 = new MisjaBadawcza();
                misjaBadawcza1.setUwagi("Tak");
                misjaBadawcza1.setProm(prom2);
                misjaBadawcza1.setCel(MisjaCel.KSIEZYC);
                session.save(misjaBadawcza1);
                MisjaBadawcza misjaBadawcza2 = new MisjaBadawcza();
                misjaBadawcza2.setUwagi("Nie");
                misjaBadawcza2.setProm(prom1);
                misjaBadawcza2.setCel(MisjaCel.MARS);
                session.save(misjaBadawcza2);
                tx.commit();
                log.trace("insert misjaBadawcza transaction commit");

                log.trace("insert zadanie transaction begin");
                tx = session.beginTransaction();
                Zadanie zadanie1 = new Zadanie();
                zadanie1.setNazwa("Zadanie 1");
                zadanie1.setOpis("Opis zadania 1");
                zadanie1.setMisja(misjaBadawcza1);
                session.save(zadanie1);
                Zadanie zadanie2 = new Zadanie();
                zadanie2.setNazwa("Zadanie 2");
                zadanie2.setOpis("Opis zadania 2");
                zadanie2.setMisja(misjaBadawcza2);
                session.save(zadanie2);
                Zadanie zadanie3 = new Zadanie();
                zadanie3.setNazwa("Zadanie 3");
                zadanie3.setOpis("Opis zadania 3");
                zadanie3.setMisja(lotTransportowy1);
                session.save(zadanie3);
                Zadanie zadanie4 = new Zadanie();
                zadanie4.setNazwa("Zadanie 4");
                zadanie4.setOpis("Opis zadania 4");
                zadanie4.setMisja(lotTransportowy2);
                session.save(zadanie4);
                tx.commit();
                log.trace("insert zadanie transaction commit");

                log.trace("insert ladunek transaction begin");
                tx = session.beginTransaction();
                Ladunek ladunek1 = new Ladunek();
                ladunek1.setTyp(LadunekTyp.SPRZET);
                ladunek1.setUwagi("Ladunek 1 - Uwagi");
                ladunek1.setMisja(misjaBadawcza1);
                session.save(ladunek1);
                Ladunek ladunek2 = new Ladunek();
                ladunek2.setTyp(LadunekTyp.APARATURA_BADAWCZA);
                ladunek2.setUwagi("Ladunek 2 - Uwagi");
                ladunek2.setMisja(misjaBadawcza2);
                session.save(ladunek2);
                tx.commit();
                log.trace("insert ladunek transaction commit");

                log.trace("insert astronauta transaction begin");
                tx = session.beginTransaction();
                Astronauta astronauta1 = new Astronauta();
                astronauta1.setImie("Ryszard");
                astronauta1.setNazwisko("Nowak");
                astronauta1.setRola(AstronautaRola.PILOT);
                astronauta1.setLiczbaMisji(10);
                astronauta1.setStopien("Stopien 2");
                astronauta1.setLiczbaSpacerowKosmicznych(10);
                HashSet<Misja> misjaHashSet = new HashSet<>(1);
                misjaHashSet.add(misjaBadawcza1);
                misjaHashSet.add(lotTransportowy1);
                astronauta1.setMisja(misjaHashSet);
                session.save(astronauta1);
                Astronauta astronauta2 = new Astronauta();
                astronauta2.setImie("Joanna");
                astronauta2.setNazwisko("Kowalska");
                astronauta2.setRola(AstronautaRola.DOWODCA);
                astronauta2.setLiczbaMisji(100);
                astronauta2.setStopien("Stopien 1");
                astronauta2.setLiczbaSpacerowKosmicznych(200);
                misjaHashSet = new HashSet<>(1);
                misjaHashSet.add(misjaBadawcza2);
                misjaHashSet.add(lotTransportowy2);
                astronauta2.setMisja(misjaHashSet);
                session.save(astronauta2);
                tx.commit();
                log.trace("insert astronauta transaction commit");
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                    log.trace(e.toString());
                }
            }
        }

    }

}
