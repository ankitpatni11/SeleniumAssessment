package Utilities;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class xmlReader {
	String xpath;
	Document document;

	public String xmlParser(String webElement) {
		try {
			File inputFile = new File(System.getProperty("user.dir") + "\\objectRepository.xml");
		//	System.out.println("user directory is : "+System.getProperty("user.dir"));
			SAXReader saxReader = new SAXReader();

			document = saxReader.read(inputFile);
			document.getRootElement();
			xpath = document.getRootElement().selectSingleNode(webElement).getText();

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xpath;
	}

}
