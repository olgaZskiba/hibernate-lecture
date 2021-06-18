package io.github.olgazskiba;

import io.github.olgazskiba.bean.Boy;
import io.github.olgazskiba.bean.Toy;
import io.github.olgazskiba.dao.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Boy boy = new Boy();
        boy.setBoy("YYYY");
        session.save(boy);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
