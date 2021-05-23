package dao;

import manager.MyEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO<EntityClass> {

    protected String tableName;

    public BaseDAO() {
    }

    public List<EntityClass> getAll() {

        String firstLetter = Character.toString(tableName.charAt(0));
        List<EntityClass> collection = new ArrayList();
        String queryString = "SELECT " + firstLetter + " FROM " + tableName + " " + firstLetter;
        Query query = MyEntityManager.getEntityManager().createQuery(queryString);
        collection = query.getResultList();
        return collection;
    }

    public EntityClass getById(int id) {

        String firstLetter = Character.toString(tableName.charAt(0));
        String queryString = "SELECT " + firstLetter + " FROM " + tableName + " " + firstLetter + " WHERE " + firstLetter + ".id=" + id;
        Query query = MyEntityManager.getEntityManager().createQuery(queryString);
        EntityClass obj = (EntityClass) query.getSingleResult();
        return obj;
    }


    public EntityClass saveOrUpdate(EntityClass obj) {
        EntityManager entityManager = MyEntityManager.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            if (entityManager.contains(obj))
                entityManager.merge(obj);

            entityManager.persist(obj);
            entityManager.flush();
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            return null;
        }
        return obj;
    }

    public void deleteById(int id) {

        EntityClass obj = getById(id);
        MyEntityManager.getEntityManager().remove(obj);
    }

    //  public EntityClass save(EntityClass obj) {}

    // public EntityClass update(EntityClass obj) {}

    // public EntityClass delete(int id) {}

}
