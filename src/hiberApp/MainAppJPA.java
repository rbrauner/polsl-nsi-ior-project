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
import org.hibernate.query.criteria.internal.predicate.LikePredicate;
import util.HiberUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
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
        CriteriaQuery<Astronauta> criteria = builder.createQuery(Astronauta.class);
        Root<Astronauta> astronauta = criteria.from(Astronauta.class);
        criteria.select(astronauta).where(builder.like(astronauta.get("nazwisko"), "%Kowal%"));
        criteria.distinct(true);

        List<Astronauta> resultList = em.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);
    }

    public static void query2() {
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Prom> criteria = builder.createQuery(Prom.class);
        Root<Astronauta> astronauta = criteria.from(Astronauta.class);
        Join<Astronauta, Misja> misja = astronauta.join("misja");
        Join<Misja, Prom> prom = misja.join("prom");
        criteria.select(prom).where(builder.like(misja.get("uwagi"), "%Brak%"));
        criteria.distinct(true);

        List<Prom> resultList = em.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);
    }

    public static void query3() {
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Astronauta> astronauta = criteria.from(Astronauta.class);
        criteria.select(builder.count(astronauta));
        criteria.distinct(true);

        List<Long> resultList = em.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);
    }
}
