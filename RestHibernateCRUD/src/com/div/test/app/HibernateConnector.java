package com.div.test.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

	private static HibernateConnector connector;
	private Configuration cfg;
    private SessionFactory sessionFactory;
	
	public static synchronized HibernateConnector getInstance() {
		if(connector == null)
		{
			connector = new HibernateConnector();
		}
		return connector;
	}
	
	private HibernateConnector() {}
	
	public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }
	
	private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }
}
