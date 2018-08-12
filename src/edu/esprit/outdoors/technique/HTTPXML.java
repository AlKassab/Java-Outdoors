package edu.esprit.outdoors.technique;

import edu.esprit.outdoors.models.Feed;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class HTTPXML {

    public static ArrayList<Feed> feedList = new ArrayList<>();

    public void start(String feeds) throws Exception {
        URL url = new URL(feeds);
        URLConnection connection = url.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList guidNodes = doc.getElementsByTagName("guid");
        NodeList titlecNodes = doc.getElementsByTagName("title");
        NodeList linkNodes = doc.getElementsByTagName("link");
        NodeList descNodes = doc.getElementsByTagName("description");
        NodeList dccreatorNodes = doc.getElementsByTagName("dc:creator");
        NodeList categoryNodes = doc.getElementsByTagName("category");
        NodeList pubDate = doc.getElementsByTagName("pubDate");

        for (int i = 0; i < descNodes.getLength(); i++) {
            Feed feed = new Feed();
            feed.setCategory(categoryNodes.item(i).getTextContent());
            feed.setCreator(dccreatorNodes.item(i).getTextContent());
            feed.setDescription(descNodes.item(i).getTextContent());
            feed.setGuid(guidNodes.item(i).getTextContent());
            feed.setLink(linkNodes.item(i).getTextContent());
            feed.setPubDate(pubDate.item(i).getTextContent());
            feed.setTitle(titlecNodes.item(i).getTextContent());
            feedList.add(feed);

        }
    }

    private Document parseXML(InputStream stream)
            throws Exception {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        } catch (Exception ex) {
            throw ex;
        }

        return doc;
    }
}
