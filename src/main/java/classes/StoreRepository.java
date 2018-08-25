package classes;

import interfaces.StoreInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class StoreRepository implements StoreInterface {



    public List<Product> getAll() {
        String hqlQuery = "select p from Product p";
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery(hqlQuery, Product.class);
            List<Product> list = query.list();
            return list;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Product> getByType(String type) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("select p from Product p where p.type = :type", Product.class);
            query.setParameter("type", type);
            List<Product> list = query.list();

            transaction.commit();
            transaction = null;
            return list;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Collections.emptyList();
    }

    public List<Product> getProductByClientId(Integer id_client) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("select p from History h join Product p where h.client_id = " + id_client, Product.class);
            //query.setParameter();
            List<Product> list = query.list();

            transaction.commit();
            transaction = null;
            return list;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Collections.emptyList();
    }


    public Client getClientByNick(String nick) {
        return null;
    }

    public void saveClient(Client client) {

    }

    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            transaction.commit();
            transaction = null;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    public void historyEntry(Integer id_product, Integer ic_client) {

    }

    public void addProductQuantityById(Integer id_product, Integer quantity) {

    }
}
