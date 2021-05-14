package pojo;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class PersonTest extends TestCase {

    public void testGetId() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Session s2 = sf.openSession();
        s2.beginTransaction();
//        Person p = null;
//        for (int i = 0; i < 50; ++i) {
//            p = new Person();
//            p.setName("person" + (i + 1));
//            s.save(p);
//        }

//        Person p = (Person) s.get(Person.class, 1);
//        System.out.println(p.getId() + ":" + p.getName());
//        p.setName("modified");
//        s.update(p);

//        String hql = "from Person p where p.name like ?1";
//        Query q = s.createQuery(hql);
//        q.setParameter(1, "%person%");
//        List<Person> people = q.list();

//        String sql = "select * from person where name like ?1";
//        Query q = s.createSQLQuery(sql);
//        q.setParameter(1, "%person%");
//        List<Object[]> people = q.list();
//
//        for (var os: people) {
//            for (var p: os) System.out.print(p + "\t");
//            System.out.println();
//        }

//        Family family = new Family();
//        family.setName("family2");
//        s.save(family);
//        s.getTransaction().commit();
//
//        s.beginTransaction();
//        Family family = s.get(Family.class, 4);
//        Person person = s.get(Person.class, 2);
//        person.setFamily(family);
//        s.update(person);
//        List<Person> people = family.getPeople();
//        if (null == people) people = new ArrayList<>();
//        Person p = new Person();
//        p.setName("family2p");
//        people.add(p);
//        s.update(family);

//        Person person = s.load(Person.class, 3);
//        System.out.println(person);
        Person person = s.get(Person.class, 1);
        Person person2 = s2.get(Person.class, 1);

        person.setAge(person.getAge() + 1);
        person2.setAge(person2.getAge() + 1);

        s.update(person);
        s2.update(person2);

        s.getTransaction().commit();
        s2.getTransaction().commit();
        s.close();
        s2.close();
        sf.close();

    }

    public void testSetId() {
    }

    public void testTestGetName() {
    }

    public void testTestSetName() {
    }
}