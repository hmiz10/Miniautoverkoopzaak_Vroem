package be.intecbrussel.entities;

import be.intecbrussel.model.Office;
import be.intecbrussel.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ProductDaoJpaImpl implements ProductDao{

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createProduct(Product product) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(product);
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
    public Product readProduct(int productCode) {
        Product product = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            product = entityManager.find(Product.class, productCode);
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Product managedProduct = entityManager.merge(product);
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
    public void deleteProduct(Product product) {
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            product = entityManager.find(Product.class, 112);
            entityManager.remove(product);
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
