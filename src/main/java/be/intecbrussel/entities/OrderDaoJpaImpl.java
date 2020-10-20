package be.intecbrussel.entities;

import be.intecbrussel.model.Office;
import be.intecbrussel.model.Order;
import be.intecbrussel.model.OrderDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class OrderDaoJpaImpl  implements OrderDao{
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();


    @Override
    public void createOrder(Order order) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(order);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public Order readOrder(int orderNumber) {
        Order order = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            order = entityManager.find(Order.class, orderNumber);
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Order managedOrder = entityManager.merge(order);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteOrder(Order order) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            order = entityManager.find(Order.class, 112);
            entityManager.remove(order);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
