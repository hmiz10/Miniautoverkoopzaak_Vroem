package be.intecbrussel.entities;

import be.intecbrussel.model.Office;
import be.intecbrussel.model.Order;
import be.intecbrussel.model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PaymentDaoJpaImpl implements PaymentDao{

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();


    @Override
    public void createPayment(Payment payment) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(payment);
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
    public Payment readPayment(int customerNumber) {
        Payment payment = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            payment = entityManager.find(Payment.class, customerNumber);
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return payment;
    }

    @Override
    public void updatePayment(Payment payment) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Payment managedPayment = entityManager.merge(payment);
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
    public void deletePayment(Payment payment) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            payment = entityManager.find(Payment.class, 112);
            entityManager.remove(payment);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
