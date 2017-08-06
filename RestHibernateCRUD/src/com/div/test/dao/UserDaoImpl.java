package com.div.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.div.test.model.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveUser(User user) {
		persist(user);
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		update(user);

	}

	/*
	 * This method returns the list of username:password 
	 * combination for user autthorization
	 */
	@Override
	public List<String> listUserProperties() {
		// TODO Auto-generated method stub
		List<String> userProperties = new ArrayList<String>();
		Transaction transaction = getSession().beginTransaction();
		Criteria criteria = createEntityCriteria();
		criteria.setProjection(
				Projections.projectionList().
				add(Projections.property("email")).
				add(Projections.property("password")));
		List<Object> list = criteria.list();
		transaction.commit();
		for(Object obj: list)
		{
			 Object[] myResult = (Object[]) obj;
			 String email = (String)myResult[0];
			 String password = (String)myResult[1];
			 userProperties.add(email+":"+password);
		}
		return userProperties;
	}

}
