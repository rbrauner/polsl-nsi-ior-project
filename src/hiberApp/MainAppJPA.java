/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import util.EMBuilder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Employee;
import model.Employee_;


/* 
 @author LabHiber RaU7
 */
public final class MainAppJPA {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        testJPQL();
        FACTORY.close();

    }

    public static void testJPQL() {
        EntityManager em = FACTORY.createEntityManager();
            List<Employee> result = em.createQuery("select e from Employee e").getResultList();
            result.forEach(System.out::println);
            System.out.println("=======================");
        em.close();
    }

    public static void showAllEmployees() {
        EntityManager em = EMBuilder.getEM();
        List<Employee> empsList = em.createQuery("select e from Employee e").getResultList();
        empsList.forEach(System.out::println);
        System.out.println("=======================");
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
        empsList = em.createQuery(criteria).getResultList();
        empsList.forEach(System.out::println);

        builder = em.getCriteriaBuilder();
        criteria = builder.createQuery(String.class);
        root = criteria.from(Employee.class);
        criteria.select(root.get(Employee_.NAME));
        List<String> names = em.createQuery(criteria).getResultList();
        names.forEach(System.out::println);
        
         List<Tuple> result = em
                .createQuery("select e.name,e.surname, e.address.city from Employee e"
                  , Tuple.class)
                .getResultList();
        result.forEach(t ->{
            System.out.println(t.get(0)+" "+t.get(1)+" "+t.get(2));
        });
        System.out.println("=======================");
        em.close();
    }

}
