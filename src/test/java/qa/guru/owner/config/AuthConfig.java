package qa.guru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/auth.properties",
        "file:/tmp/secret.properties",
        "classpath:auth.properties"
})
public interface AuthConfig extends Config {

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();
}
