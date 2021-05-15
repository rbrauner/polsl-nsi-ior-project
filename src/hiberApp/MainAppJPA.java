/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;


import model.Astronauta;
import model.Misja;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.internal.predicate.LikePredicate;
import util.HiberUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import java.util.List;

/*
 @author LabHiber RaU7
 */
public final class MainAppJPA {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);

    public static void main(String[] args) {
        final DataLoad dataLoad = new DataLoad();
        dataLoad.createData(SESSION_FACTORY);

        query1();
        query2();
        query3();
    }

    public static void query1() {
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Astronauta> criteria = builder.createQuery(Astronauta.class);
        Root<Astronauta> root = criteria.from(Astronauta.class);
        criteria.select(root).where(builder.like(root.get("nazwisko"), "%Kowal%"));

        List<Astronauta> resultList = em.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);
    }

    public static void query2() {
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Astronauta> criteria = builder.createQuery(Astronauta.class);
        Root<Astronauta> root = criteria.from(Astronauta.class);
        criteria.select(root).where(builder.like(root.get("nazwisko"), "%Kowal%"));

        List<Astronauta> resultList = em.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);
    }

    public static void query3() {
    }
}
