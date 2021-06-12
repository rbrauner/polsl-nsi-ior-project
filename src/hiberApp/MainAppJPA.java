/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;


import model.Astronauta;
import model.Misja;
import model.Prom;
import org.hibernate.Metamodel;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.spi.TupleBuilderTransformer;
import org.hibernate.query.criteria.internal.predicate.LikePredicate;
import util.HiberUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.Arrays;
import java.util.List;

/*
 @author LabHiber RaU7
 */
public final class MainAppJPA {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);

    public static void main(String[] args) {
//        final DataLoad dataLoad = new DataLoad();
//        dataLoad.createData(SESSION_FACTORY);

        query1();
        query2();
        query3();
    }

    public static void query1() {
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
        Root<Astronauta> astronauta = criteria.from(Astronauta.class);
        criteria.select(builder.tuple(astronauta.get("imie"), astronauta.get("nazwisko"))).where(builder.like(astronauta.get("nazwisko"), "%Kowal%"));

        List<Tuple> resultList = em.createQuery(criteria).getResultList();
        resultList.stream().forEach((item) -> {
            System.out.println(item.get(0) + " " + item.get(1));
        });
    }

    public static void query2() {
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
        Root<Misja> misja = criteria.from(Misja.class);
//        Join<Misja, Astronauta> astronauta = misja.join("astronauta");
        criteria.select(builder.tuple(misja.get("prom").get("nazwa"), builder.size(misja.get("astronauta")))).where(builder.like(misja.get("uwagi"), "%Brak%"));

        List<Tuple> resultList = em.createQuery(criteria).getResultList();
        resultList.stream().forEach((item) -> {
            System.out.println(item.get(0) + " " + item.get(1));
        });
    }

    public static void query3() {
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
        Root<Astronauta> astronauta = criteria.from(Astronauta.class);
        criteria.select(builder.tuple(builder.count(astronauta), builder.avg(astronauta.get("liczbaMisji"))));
        criteria.distinct(true);

        List<Tuple> resultList = em.createQuery(criteria).getResultList();
        resultList.stream().forEach((item) -> {
            System.out.println(item.get(0) + " " + item.get(1));
        });
    }
}
