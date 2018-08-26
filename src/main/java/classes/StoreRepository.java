package classes;

import interfaces.StoreInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class StoreRepository implements StoreInterface {

    public List<Product> getAllProducts() {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("select c from Product c", Product.class);
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

    @Override
    public List<Product> getProductByType(String type) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("select c from Product c where c.type = :typeName", Product.class);
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

    @Override
    public List<Product> getProductByClientId(Integer id) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery("select c from Product c where c.id = :idName", Product.class);
            query.setParameter("idName", id);
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

    @Override
    public Client getClientByNick(String nick) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Client> query = session.createQuery("select c from Client c where c.nick = :nickName", Client.class);
            query.setParameter("nickName", nick);
            Client client = query.getSingleResult();
            transaction.commit();
            transaction = null;
            return client;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
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

    @Override
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

    @Override
    public void addProductQuantityById(Integer productId, Integer quantity) {
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
            Query<Product> query = session.createQuery("UPDATE Product SET reserved = :reservedValueName WHERE productId = :productIdName", Product.class);
            query.setParameter("reservedValueName", reservedValue);
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
    public List<History> getHistoryByClientId(Integer clientId) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<History> query = session.createQuery("select c from History c WHERE clientId = :clientIdName", History.class);
            query.setParameter("clientIdName", clientId);
            List<History> list = query.list();
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

}
