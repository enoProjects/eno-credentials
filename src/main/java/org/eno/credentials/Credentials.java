package org.eno.credentials;

public class Credentials {

    private static Credentials instance;

    private final String mainAuth;
    private final String botAuth;
    private final String clientId;
    private final String clientSecret;
    private final String channelID;
    private final String botChannelID;

    Credentials(final String mainAuth,
                final String botAuth,
                final String clientId,
                final String clientSecret,
                final String channelID,
                final String botChannelID) {
        this.mainAuth = mainAuth;
        this.botAuth = botAuth;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.channelID = channelID;
        this.botChannelID = botChannelID;
    }

    public static Credentials getInstance() {
        if (instance == null) {
            instance = PropertiesLoader.load();
        }
        return instance;
    }

    public String getMainAuth() {
        return mainAuth;
    }

    public String getBotAuth() {
        return botAuth;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getChannelId() {
        return channelID;
    }

    public String getBotChannelId() {
        return botChannelID;
    }
}
