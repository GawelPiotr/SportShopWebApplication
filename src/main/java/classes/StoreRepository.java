package classes;

import main.java.interfaces.StoreInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class StoreRepository implements StoreInterface {
//
//    public List<Product> getAll() {
//        Transaction transaction = null;
//        try (Session session = SessionManager.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query<Product> query = session.createQuery("select c from Product c where c.address.city = :cityName", Product.class);
//            query.setParameter("cityName", city);
//            List<Product> list = query.list();
//            transaction.commit();
//            transaction = null;
//            return list;
//        } catch (Throwable e) {
//            e.printStackTrace();
//        } finally {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return Collections.emptyList();
//    }
//
}
