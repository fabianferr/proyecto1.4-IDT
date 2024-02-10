package com.umlaut.crowd.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class te {
    public static Document a(URL url) throws IOException, IllegalArgumentException, SAXException, ParserConfigurationException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setUseCaches(false);
        return a(httpURLConnection.getInputStream());
    }

    public static Document a(InputStream inputStream) throws IOException, SAXException, ParserConfigurationException, IllegalArgumentException {
        if (inputStream != null) {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        }
        throw new IllegalArgumentException();
    }
}
