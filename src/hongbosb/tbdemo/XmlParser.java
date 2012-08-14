package hongbosb.tbdemo;

import java.io.*;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class XmlParser {

    private InputStream mContentStream;
    private String[] mTitles;

    public XmlParser(String content) {
        mContentStream = new ByteArrayInputStream(content.getBytes());
    }

    public List<RssBean> startParsing() {
        try {
            List<RssBean> beans = new ArrayList<RssBean>();

            DocumentBuilder builder 
                = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(mContentStream);
            NodeList itemList = parseItemNodeList(doc);

            BeanGenerator gen = new BeanGenerator();

            for (int i = 0; i < itemList.getLength(); i ++) {
                RssBean bean = gen.bean(itemList.item(i));
                beans.add(bean);
            }

            return beans;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private NodeList parseItemNodeList(Document doc) {
        return doc.getDocumentElement().getElementsByTagName("item");
    }

    public static class BeanGenerator {
        public static RssBean bean(Node node) {
            NodeList list = node.getChildNodes();
            RssBean bean = new RssBean();
            for (int i = 0; i < list.getLength(); i ++) {
                Node n = list.item(i);
                bean = dispatch(n, bean);
            }
            return bean;
        }

        public static RssBean dispatch(Node node, RssBean bean) {
            String name = node.getNodeName();
            if ("title".equals(name)) {
                bean.title = node.getTextContent();
            }
            return bean;
        }
    }
}
