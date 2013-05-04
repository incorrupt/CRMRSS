package ru.intechbank.crm.synd;



public enum SyndFeedType 

{

    RSS_09("rss_0.9"),
    RSS_091("rss_0.91"),
    RSS_092("rss_0.92"),
    RSS_093("rss_0.93"),
    RSS_O94("rss_0.94"),
    RSS_10("rss_1.0"),
    RSS_20("rss_2.0"),
    ATOM_03("atom_0.3"),
    ATOM_10("atom_1.0");

    private String code;

    

    private SyndFeedType(String code)

    {

        this.code = code;

    }

    

    public String getCode()

    {

        return code;

    }

}