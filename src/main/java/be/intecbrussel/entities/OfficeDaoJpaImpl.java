package be.intecbrussel.entities;

import be.intecbrussel.model.Customer;
import be.intecbrussel.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class OfficeDaoJpaImpl implements OfficeDao {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOffice(Office office) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(office);
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
    public Office readOffice(int officeCode) {
        Office office = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            office = entityManager.find(Office.class, officeCode);
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return office;
    }

    @Override
    public void updateOffice(Office office) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Office managedOffice = entityManager.merge(office);
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
    public void deleteOffice(Office office) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            office = entityManager.find(Office.class, 112);
            entityManager.remove(office);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
