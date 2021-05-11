/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import java.time.LocalDate;
import model.*;
import java.util.HashSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
                log.trace("insert person transaction begin");
                tx = session.beginTransaction();
                Person person1 = new Person("John", "Smith", LocalDate.parse("1973-11-01"));
                session.save(person1);
                Person person2 = new Person("Tom", "Jones", LocalDate.parse("1980-10-13"));
                session.save(person2);
                tx.commit();
                log.trace("insert person transaction commit");
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                    log.trace(e.toString()); 
                }
            }    
                tx = session.beginTransaction();
                Employee emp1 = new Employee("Martin", "Snow", LocalDate.parse("1985-11-01"));
                emp1.setJob("programmer");
                Address address1 = new Address("44-100", "Boston", "Happy", "12A", "3");
                emp1.setAddress(address1);
                HashSet<Child> children1 = new HashSet<>(2);
                createChild(address1, "Jack", "Snow", LocalDate.parse("2015-01-01"), false , children1);
                createChild(address1, "Jill", "Snow", LocalDate.parse("2015-01-01"), false, children1);
                emp1.setChildren(children1);
                session.save(emp1);

                Employee emp2 = new Employee("Robert", "Nicks", LocalDate.parse("1968-10-13"));
                emp2.setJob("senior programmer");
                Address address2 = new Address("44-100", "Huston", "Garden", "5", "");
                HashSet<Child> children2 = new HashSet<>(1);
                createChild(address2, "Mary", "Nicks", LocalDate.parse("2010-05-20"), true, children2);
                emp2.setAddress(address2);
                emp2.setChildren(children2);
                session.save(emp2);

                Employee emp3 = new Employee("Miriam", "Apple", LocalDate.parse("1980-10-10"));
                emp3.setJob("analyst");
                Address address3 = new Address("44-100", "Warsow", "Wide", "7", "10");
                emp3.setAddress(address3);
                session.save(emp3);

                //projects
                Project project1 = new Project("LabORI", LocalDate.parse("2018-03-16"), LocalDate.parse("2020-05-08"));
                project1.setDescription("Hibernate ORM enables developers to more easily write applications whose data "
                        + "outlives the application process. As an Object/Relational Mapping (ORM) framework, "
                        + "Hibernate is concerned with data persistence as it applies to relational databases "
                        + "(via JDBC). Unfamiliar with the notion of ORM?");
                Project project2 = new Project("ADA", LocalDate.parse("2019-01-16"), LocalDate.parse("2019-06-08"));
                project2.setDescription("Ada is a structured, statically typed, imperative, and object-oriented "
                        + "high-level programming language, extended from Pascal and other languages. It has built-in "
                        + "language support for design by contract (DbC), extremely strong typing, explicit concurrency, "
                        + "tasks, synchronous message passing, protected objects, and non-determinism. ");
                Project project3 = new Project("XML", LocalDate.parse("2018-03-16"), LocalDate.parse("2018-11-12"));
                project3.setDescription("The design goals of XML emphasize simplicity, generality, and usability across "
                        + "the Internet.[6] It is a textual data format with strong support via Unicode for different "
                        + "human languages. Although the design of XML focuses on documents, the language is widely used "
                        + "for the representation of arbitrary data structures[7] such as those used in web services.");
                Project project4 = new Project("ANN", LocalDate.parse("2019-06-10"), LocalDate.parse("2021-06-08"));
                project4.setDescription("In the Java computer programming language, an annotation is a form of syntactic "
                        + "metadata that can be added to Java source code. Classes, methods, variables, parameters and "
                        + "Java packages may be annotated. Like Javadoc tags, Java annotations can be read from source "
                        + "files. Unlike Javadoc tags, Java annotations can also be embedded in and read from Java class "
                        + "files generated by the Java compiler. This allows annotations to be retained by the Java virtual"
                        + " machine at run-time and read via reflection.");
                HashSet<Project> projectSet1 = new HashSet<>();
                HashSet<Project> projectSet2 = new HashSet<>();
                HashSet<Project> projectSet3 = new HashSet<>();
                //creating project sets
                projectSet1.add(project1);
                projectSet2.add(project3);
                projectSet2.add(project4);
                projectSet3.add(project1);
                projectSet3.add(project2);
                projectSet3.add(project4);
                //adding projects to employes
                emp1.setProjects(projectSet1);
                emp2.setProjects(projectSet2);
                emp3.setProjects(projectSet3);

                //departements
                Department dept1 = new Department("Development Dep");
                Department dept2 = new Department("Analysis Dep");
                Department dept3 = new Department("Finance Dep");
                //Finance employees
                Employee emp4 = new Employee("Daisy", "Bonner", LocalDate.parse("1970-03-10"));
                emp4.setJob("chief accountant");
                Address address4 = new Address("44-111", "Huston", "West", "5", "");
                session.save(emp4);
                emp4.setAddress(address4);
                Employee emp5 = new Employee("Tom", "Sizemore", LocalDate.parse("1980-10-10"));
                emp5.setJob("accountant");
                Address address5 = new Address("44-100", "Huston", "East", "12", "10");
                session.save(emp5);
                emp5.setAddress(address5);
                Employee emp6 = new Employee("Alice", "Cooper", LocalDate.parse("1985-05-15"));
                emp6.setJob("accountant");
                Address address6 = new Address("44-100", "Huston", "North", "10A", "");
                session.save(emp6);
                emp6.setAddress(address6);
                //adding employees to Finance Dep
                emp4.setDepartment(dept3);
                emp5.setDepartment(dept3);
                emp6.setDepartment(dept3);
                //adding employees to Analysis Dep
                emp3.setDepartment(dept2);
                //adding employees to Development Dep
                emp2.setDepartment(dept1);
                emp1.setDepartment(dept1);

                //managers
                Manager man1 = new Manager("Adam", "Borek", LocalDate.parse("1979-05-15"));
                man1.setJob("manager");
                Address address7 = new Address("44-105", "Boston", "Crunchy", "1", "");
                man1.setAddress(address7);
                man1.setSalSup(0.2);
                session.save(man1);
                Manager man2 = new Manager("Mary", "Poppins", LocalDate.parse("1972-11-01"));
                man2.setJob("manager");
                Address address8 = new Address("44-100", "Boston", "White Rabbit", "1", "12");
                man2.setAddress(address8);
                man2.setSalSup(0.1);
                session.save(man2);
                Manager man3 = new Manager("John", "Lemon", LocalDate.parse("1975-07-12"));
                man3.setJob("manager");
                Address address9 = new Address("44-105", "London", "Baker", "7", "");
                man3.setAddress(address9);
                man3.setSalSup(0.15);
                session.save(man3);
                //adding managers as dep employees
                man1.setDepartment(dept1);
                man2.setDepartment(dept2);
                man3.setDepartment(dept3);
                //adding manager to dep
                dept1.setManager(man1);
                dept2.setManager(man2);
                dept3.setManager(man3);
                tx.commit();
            }

        }
        /**
         * tworzy obiekty klasy Child i dodaje je do listy children
         *
         * @param address
         * @param name
         * @param surname
         * @param birthDate
         * @param children
         */
    private void createChild(Address address, String name,
            String surname, LocalDate birthDate, boolean learning,
            HashSet<Child> children) {
        Child d = new Child(name, surname, birthDate);
        d.setLearning(learning);
        children.add(d);
    }

}
