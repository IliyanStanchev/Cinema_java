package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Consumer;

public class MyEntityManager {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void executeInsideTransaction(Consumer<EntityManager> action)
    {
        EntityTransaction tx = entityManager.getTransaction();
        try
        {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e)
        {
            tx.rollback();
            throw e;
        }
    }

    public static Object saveOrUpdate(Object o)
    {
        EntityTransaction tx = entityManager.getTransaction();
        try
        {
            tx.begin();
            if(entityManager.contains(o))
                entityManager.merge(o);

            entityManager.persist(o);
            entityManager.flush();
            tx.commit();
        } catch (RuntimeException e)
        {
            tx.rollback();
            return null;
        }
        return o;
    }

    public static EntityManager getEntityManager()
    {
        return entityManager;
    }

}