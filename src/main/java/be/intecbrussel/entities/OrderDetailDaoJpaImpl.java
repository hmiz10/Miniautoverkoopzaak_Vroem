package be.intecbrussel.entities;

import be.intecbrussel.model.Office;
import be.intecbrussel.model.Order;
import be.intecbrussel.model.OrderDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderDetailDaoJpaImpl implements OrderDetailDao{

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(orderDetail);
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
    public OrderDetail readOrderDetail(int orderNumber) {
        OrderDetail orderDetail = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            orderDetail = entityManager.find(OrderDetail.class, orderNumber);
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return orderDetail;
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            OrderDetail managedOrderDetail= entityManager.merge(orderDetail);
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
    public void deleteOrderDetail(OrderDetail orderDetail) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            orderDetail = entityManager.find(OrderDetail.class, 112);
            entityManager.remove(orderDetail);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
