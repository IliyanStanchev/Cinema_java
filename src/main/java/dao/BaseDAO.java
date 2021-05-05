package dao;

import manager.MyEntityManager;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BaseDAO<EntityClass> {

    protected String tableName;

    public BaseDAO() {}

    public List<EntityClass> getAll() {

        List<EntityClass> collection = new ArrayList();
        String queryString = "SELECT " + tableName.charAt(0) + " FROM " + tableName + " " + tableName.charAt(0);
        Query query = MyEntityManager.getEntityManager().createQuery(queryString);
        collection=query.getResultList();
        return collection;

    }

   // public EntityClass getById(int id) {}

  //  public EntityClass save(EntityClass obj) {}

   // public EntityClass update(EntityClass obj) {}

   // public EntityClass delete(int id) {}

}
