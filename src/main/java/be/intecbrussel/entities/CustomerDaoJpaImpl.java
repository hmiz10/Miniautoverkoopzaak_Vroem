package be.intecbrussel.entities;

import be.intecbrussel.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Currency;

public class CustomerDaoJpaImpl implements CustomerDao {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createCustomer(Customer customer) {
        EntityManager entityManager = null;

        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(customer);
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
    public Customer readCustomer(int customerNumber) {
        Customer customer = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            customer = entityManager.find(Customer.class, customerNumber);
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return customer;
    }

    @Override
    public Customer readCustomer(String customerName) {
        Customer customer = null;
        EntityManager entityManager = null;

        try{
            entityManager = emf.createEntityManager();
            customer = entityManager.find(Customer.class, customerName);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Customer managedCustomer = entityManager.merge(customer);
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
    public void deleteCustomer(Customer customer) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            customer = entityManager.find(Customer.class, 112);
            entityManager.remove(customer);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
