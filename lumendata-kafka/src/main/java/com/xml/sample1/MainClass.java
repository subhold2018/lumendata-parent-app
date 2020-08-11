package com.xml.sample1;

import java.io.FileReader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;

public class MainClass {
	public static void main(String[] args) throws Exception {
		XMLInputFactory xif = XMLInputFactory.newFactory();
		XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("sample1.xml"));
		xsr.nextTag(); // Advance to Envelope tag

		xsr.nextTag(); // Advance to Body tag
		xsr.nextTag();
		xsr.nextTag();

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		StringWriter stringWriter = new StringWriter();
		transformer.transform(new StAXSource(xsr), new StreamResult(stringWriter));
		StringReader sr = new StringReader(stringWriter.toString());
		JAXBContext jaxbContext = JAXBContext.newInstance(LoginResult.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		LoginResult loginResult = (LoginResult) unmarshaller.unmarshal(sr);
		System.out.println(loginResult);
		
	}
}
