package com.islamistudio.rss.data.source.remote.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class Channel {

    @Element
    private String title;

    @Element
    private String description;

    @Element
    private String link;

    @Element
    private String language;

    @Element
    private String copyright;

    @Element
    private String lastBuildDate;

    @Element
    private String pubDate;

    @ElementList(required = false, inline = true)
    private List<Item> item;
}
