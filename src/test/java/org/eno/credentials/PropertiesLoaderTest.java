package org.eno.credentials;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertiesLoaderTest {

    @Test
    void testLoadSource() throws URISyntaxException {
        File file = new File("src/test/resources/org/eno/credentials/test.properties");
        String absolutePath = file.getAbsolutePath();

        System.setProperty(PropertiesLoader.SOURCE_PATH,
                absolutePath);

        final Credentials instance = Credentials.getInstance();

        assertEquals("aaaa", Credentials.getInstance().getMainAuth());
        assertEquals("bbbb", Credentials.getInstance().getBotAuth());
        assertEquals("cccc", Credentials.getInstance().getClientId());
        assertEquals("dddd", Credentials.getInstance().getClientSecret());
        assertEquals("eeee", Credentials.getInstance().getChannelId());
        assertEquals("ffff", Credentials.getInstance().getBotChannelId());

        System.setProperty(PropertiesLoader.SOURCE_PATH, "");

    }
}