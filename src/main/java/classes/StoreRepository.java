package classes;

import interfaces.StoreInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StoreRepository implements StoreInterface {


    public List<Product> getAllProducts() {
        String hqlQuery = "select p from Product p";
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery(hqlQuery, Product.class);
            return query.list();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Product> getProductByType(String type) {

        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("select p from Product p where p.type = :typeName", Product.class);
            query.setParameter("typeName", type);
            return query.list();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Product> getProductByClientId(Integer clientId) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("select p from History h join Product p where h.clientId = :myClientId AND h.productId = p.productId", Product.class);
            query.setParameter("myClientId", clientId);
            return query.list();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    public Optional<Client> getClientByNick(String nick) {

        Client client = new Client();
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("select c from Client c where c.nick = :nickName ", Client.class);
            query.setParameter("nickName", nick);
            client = query.getSingleResult();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(client);
    }

    public void saveClient(Client client) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(client);
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

    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
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

    @Override
    public void saveHistoryEntry(History history) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(history);
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


    public void setProductQuantityById(Integer productId, Integer quantity) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("UPDATE Product SET quantity = :quantityName WHERE productId = :productIdName", Product.class);
            query.setParameter("quantityName", quantity);
            query.setParameter("productIdName", productId);
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

    @Override
    public void setReservedById(Integer productId, Integer reservedValue) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE Product SET reserved = :reservedValueName WHERE productId = :productIdName");
            query.setParameter("reservedValueName", reservedValue);
            query.setParameter("productIdName", productId);
            query.executeUpdate();
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

    @Override
    public Optional<Integer> getReservedById(Integer productId) {
        Integer reserved = 0;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Integer> query = session.createQuery("select p.reserved from Product p where p.productId = :productIdName ", Integer.class);
            query.setParameter("productIdName", productId);
            reserved = query.getSingleResult();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(reserved);
    }

    @Override
    public List<History> getHistoryByClientId(Integer clientId) {

        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<History> query = session.createQuery("select c from History c WHERE clientId = :clientIdName", History.class);
            query.setParameter("clientIdName", clientId);
            return query.list();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    @Override
    public Optional<Product> getProductByProductId(Integer productId) {
        Product product = new Product();
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            product = session.find(Product.class, productId);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(product);
    }
}
