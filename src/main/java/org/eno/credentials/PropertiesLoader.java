package org.eno.credentials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

class PropertiesLoader {

    public final static String SOURCE_PATH = "eno.credential.source";

    static Credentials load() {

        final Properties properties = new Properties();

        try {
            final String propertyPath = System.getProperty(SOURCE_PATH);
            if (propertyPath != null) {
                final Path path = Paths.get(propertyPath);

                properties.load(Files.newInputStream(path));

                return new Credentials(
                        properties.getProperty("mainAuth"),
                        properties.getProperty("botAuth"),
                        properties.getProperty("clientId"),
                        properties.getProperty("clientSecret"),
                        properties.getProperty("channelID"),
                        properties.getProperty("botChannelID"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
