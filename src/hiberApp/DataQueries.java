/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model.Astronauta;
import model.Prom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

/*
 @author LabHiber RaU7
 */
public final class DataQueries {

     /**
     * Queries test data
     *
     * @param SESSION_FACTORY for connecting data source
     */

    public void showAstronauta(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("select a from Astronauta a");
            List<Astronauta> astronautaList = query.getResultList();
            astronautaList.stream().forEach((astronauta) -> {
                System.out.println(astronauta);
            });
        }

    }

    public void showAll(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("select distinct o from java.lang.Object o");
            ((org.hibernate.query.Query<?>) query).setComment("All objects list");
            List<Object> all = query.getResultList();
            all.forEach(System.out::println);
        }
    }

    public void query1(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("select distinct a from Astronauta a where a.nazwisko like '%Kowal%'");
            List<Astronauta> resultList = query.getResultList();
            resultList.stream().forEach((item) -> {
                System.out.println(item);
            });
        }
    }

    public void query2(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("select distinct m.prom from Astronauta a join a.misja m where m.uwagi like '%Brak%'", Prom.class);
            List<Prom> resultList = query.getResultList();
            resultList.stream().forEach((item) -> {
                System.out.println(item);
            });
        }
    }

    public void query3(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("select count(a) from Astronauta a");
            List<Long> resultList = query.getResultList();
            resultList.stream().forEach((item) -> {
                System.out.println(item);
            });
        }
    }
}
