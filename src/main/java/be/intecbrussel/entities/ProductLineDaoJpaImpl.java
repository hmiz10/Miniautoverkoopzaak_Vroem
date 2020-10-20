package be.intecbrussel.entities;

import be.intecbrussel.model.Product;
import be.intecbrussel.model.ProductLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProductLineDaoJpaImpl implements ProductLineDao {

    EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createProductLine(ProductLine productLine) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(productLine);
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
    public ProductLine readProductLine(int productLine) {
        ProductLine productLine1 = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            productLine1 = entityManager.find(ProductLine.class, productLine);
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return productLine1;
    }

    @Override
    public void updateProductLine(ProductLine productLine) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            ProductLine managedProductLine = entityManager.merge(productLine);
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
    public void deleteProductLine(ProductLine productLine) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            productLine = entityManager.find(ProductLine.class, 112);
            entityManager.remove(productLine);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
