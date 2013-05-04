package ru.intechbank.crm.synd;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.intechbank.crm.model.Entry;
import ru.intechbank.crm.model.Feed;
import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;

public class SyndGenerator {

	
	public SyndFeed makeFeed(Feed f,List<Entry> e){
		
		List<SyndEntry> entries = new ArrayList<SyndEntry>();
	 	Iterator<Entry> i = e.iterator();
	 	SyndEntry entry = new SyndEntryImpl();
	 	SyndFeed feed = new SyndFeedImpl(); 
	 	
        while(i.hasNext()){
        	entry =makeEntry(i.next());
        	entries.add(entry);               
        }
    	feed.setUri(f.getUri());
    	feed.setLink(f.getUrl());
    	//feed.setEncoding("Windows-1251");
    	//feed.setEncoding("KOI8-R");
        feed.setFeedType(SyndFeedType.RSS_20.getCode());
        feed.setAuthor(f.getAuthor());
        feed.setCopyright(f.getAuthor());
        feed.setTitle(f.getTitle());
        feed.setPublishedDate(f.getUpdatedDate()); 
        feed.setDescription(f.getContent());
        feed.setEntries(entries);
        
		return feed;	
	}
	
	 	
    public SyndEntry makeEntry(Entry e) {
        SyndEntry entry = new SyndEntryImpl();
        entry.setAuthor(e.getAuthor());
        entry.setTitle(e.getTitle());
        entry.setLink(e.getUrl());
        entry.setUri(e.getUri());
        entry.setPublishedDate(e.getPublishedDate());
        entry.setUpdatedDate(e.getUpdatedDate());
        SyndContent description = new SyndContentImpl();
        description.setType("text/html");
        description.setValue(e.getContent() );
        entry.setDescription(description);
        return entry;
    }

    public SyndCategory makeCategory(String name, String taxonomyUrl) {
        SyndCategory category = new SyndCategoryImpl();
        category.setName(name);
        category.setTaxonomyUri(taxonomyUrl);
        return category;
    }

}
