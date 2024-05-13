package org.example;

import java.io.File;
import javax.xml.XMLConstants;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.example.model.Employee;
import org.xml.sax.SAXException;

public class JaxbExample {
    public static void main(String[] args) {
        String xmlFile = "C:\\_src\\kafka-exercises\\xml\\src\\main\\java\\org\\example\\model\\employee.xml";
        String xsdFile = "C:\\_src\\kafka-exercises\\xml\\src\\main\\java\\org\\example\\model\\employee.xsd";

        jaxbXmlFileToObject(xmlFile, xsdFile);
    }

    private static void jaxbXmlFileToObject(String xmlFile, String xsdFile) {

        JAXBContext jaxbContext;

        try {
            //Get JAXBContext
            jaxbContext = JAXBContext.newInstance(Employee.class);

            //Create Unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //Setup schema validator
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema employeeSchema = sf.newSchema(new File(xsdFile));
            jaxbUnmarshaller.setSchema(employeeSchema);

            //Unmarshal xml file
            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(new File(xmlFile));

            System.out.println(employee);
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }
}