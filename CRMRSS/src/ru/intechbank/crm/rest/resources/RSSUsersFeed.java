package ru.intechbank.crm.rest.resources;

import java.io.IOException;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.cfg.Configuration;

import ru.intechbank.crm.dao.DAOFactoryRSSImpl;
import ru.intechbank.crm.model.Entry;
import ru.intechbank.crm.model.Feed;
import ru.intechbank.crm.synd.SyndGenerator;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

@Path("/Users")
public class RSSUsersFeed {
	
	private static SyndGenerator _generator = new SyndGenerator();
	private static DAOFactoryRSSImpl _DAO = new DAOFactoryRSSImpl(new Configuration().configure("rssdb.hibernate.cfg.xml"));
	
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public String getFeed(@PathParam("username") String username)  throws IOException, FeedException {
		
        List<Entry> e = _DAO.getEntries(username);
        Feed f = _DAO.getFeed(username);
        
        SyndFeedOutput output = new SyndFeedOutput();
        
        return output.outputString(_generator.makeFeed(f,e));
       
	}

}