package com.div.test.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.div.test.app.HibernateConnector;

public abstract class AbstractDao<T> {

	private final Class<T> persistentClass;
	
	public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
	private Session session = HibernateConnector.getInstance().getSession();
	
	protected Session getSession(){
        return session;
    }
	
	public T getByKey(Integer key)
	{
		Transaction transaction =  getSession().beginTransaction();
		T t = (T)getSession().get(persistentClass, key);
        transaction.commit();
        return t;
	}
	
	public void persist(T entity)  {
    	Transaction transaction = (Transaction) getSession().beginTransaction();
        getSession().persist(entity);
        transaction.commit();
    }
 
    public void delete(T entity) {
    	Transaction transaction =  getSession().beginTransaction();
        getSession().delete(entity);
        transaction.commit();
    }
     
    public void update(T entity)
    {
    	Transaction transaction =  getSession().beginTransaction();
    	getSession().update(entity);
    	transaction.commit();
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
