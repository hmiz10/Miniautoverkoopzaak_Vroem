package be.intecbrussel.entities;

import be.intecbrussel.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class EmployeeDaoJpaImpl implements EmployeeDao {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createEmployee(Employee employee) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            entityManager.find(Employee.class, employee.getEmployeeNumber());
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public Employee readEmployee(int employeeNumber) {
        Employee employee = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            employee = entityManager.find(Employee.class, employeeNumber);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return employee;
    }

    @Override
    public Employee readEmployee(String employeeName) {
        Employee employee = null;
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            employee = entityManager.find(Employee.class, employeeName);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Employee managedEmployee = entityManager.merge(employee);
            transaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {

        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();

            employee = entityManager.find(Employee.class, 1002);
            entityManager.remove(employee);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }

    }
}
