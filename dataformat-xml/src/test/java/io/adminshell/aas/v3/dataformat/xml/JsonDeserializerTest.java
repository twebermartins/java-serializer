package io.adminshell.aas.v3.dataformat.xml;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.adminshell.aas.v3.dataformat.Deserializer;
import io.adminshell.aas.v3.dataformat.xml.XmlDeserializer;
import io.adminshell.aas.v3.model.AssetAdministrationShellEnvironment;

public class JsonDeserializerTest {

	private static final Logger logger = LoggerFactory.getLogger(JsonDeserializerTest.class);
	private static final Deserializer deserializer = new XmlDeserializer();

	@Test
	public void testReadFromFile() throws Exception {
		String xml = new String(Files.readAllBytes(Paths.get("src/test/resources/Example_AAS_ServoDCMotor - Simplified V2.0.xml")));
		XmlDeserializer deserializer = new XmlDeserializer();
		try {
			
			AssetAdministrationShellEnvironment env = deserializer.read(xml);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));

	}
}
