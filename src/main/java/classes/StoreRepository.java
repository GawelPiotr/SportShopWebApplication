package classes;

import interfaces.StoreInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StoreRepository implements StoreInterface {


    public List<Product> getAllProducts() {
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

    public List<Product> getProductByType(String type) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("select p from Product p where p.type = :typeName", Product.class);
            query.setParameter("typeName", type);
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

    public List<Product> getProductByClientId(Integer clientId) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("select p from History h join Product p where h.clientId = :myClientId ", Product.class);
            query.setParameter("myClientId", clientId);
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


    public void addProductQuantityById(Integer id_product, Integer quantity) {

    }

    @Override
    public void setReservedById(Integer productId, Integer reservedValue) {

    }

    @Override
    public Integer getReservedById(Integer productId) {
        return null;
    }

    @Override
    public List<History> getHistoryByClientId(Integer clientId) {
        return null;
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
