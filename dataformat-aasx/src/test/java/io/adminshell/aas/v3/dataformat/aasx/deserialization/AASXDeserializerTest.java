package io.adminshell.aas.v3.dataformat.aasx.deserialization;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.xml.sax.SAXException;

import io.adminshell.aas.v3.dataformat.DeserializationException;
import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.dataformat.aasx.AASXDeserializer;
import io.adminshell.aas.v3.dataformat.aasx.AASXSerializer;
import io.adminshell.aas.v3.dataformat.aasx.InMemoryFile;
import io.adminshell.aas.v3.dataformat.aasx.serialization.AASSimple;

public class AASXDeserializerTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testRoundTrip() throws SerializationException, IOException, InvalidFormatException, DeserializationException, ParserConfigurationException, SAXException {
        List<InMemoryFile> fileList = new ArrayList<>();
        byte[] operationManualContent = { 0, 1, 2, 3, 4 };
        InMemoryFile inMemoryFile = new InMemoryFile(operationManualContent, "/aasx/OperatingManual.pdf");
        fileList.add(inMemoryFile);

        File file = tempFolder.newFile("output.aasx");

        new AASXSerializer().write(AASSimple.ENVIRONMENT, fileList, new FileOutputStream(file));

        InputStream in = new FileInputStream(file);
        AASXDeserializer deserializer = new AASXDeserializer(in);

        assertEquals(AASSimple.ENVIRONMENT, deserializer.read());
        assertEquals(fileList, deserializer.getRelatedFiles());
    }
}
