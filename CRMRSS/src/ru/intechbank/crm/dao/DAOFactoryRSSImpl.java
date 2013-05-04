package ru.intechbank.crm.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.intechbank.crm.model.Entry;
import ru.intechbank.crm.model.Feed;

import java.util.List;


public class DAOFactoryRSSImpl {

	private static SessionFactory _sf;
	
	public DAOFactoryRSSImpl(Configuration cfg) {
		_sf = cfg.buildSessionFactory();
	}
	
	public DAOFactoryRSSImpl(SessionFactory sf) {
		_sf = sf;
	} 
	
	@SuppressWarnings("unchecked")
	public List<Entry> getEntries(String feedname){ 
		Query q = _sf.openSession().getNamedQuery("GetEntries");  
		q.setParameter("feedName", feedname);
		return q.list();
	}
	
	public Feed getFeed(String feedname){ 
		Query q = _sf.openSession().getNamedQuery("GetFeed");  
		q.setParameter("feedName", feedname);
		return (Feed) q.uniqueResult();
	}
	
	
}
