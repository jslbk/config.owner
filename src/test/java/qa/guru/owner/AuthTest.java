package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.AuthConfig;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest {

    @Test
    public void testAuthClasspath() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.getUsername()).isEqualTo(("jslbk"));
        assertThat(config.getPassword()).isEqualTo(("123123123"));
    }

    @Test
    public void testAuthWithSecretFile() throws Exception {
        String content = "username=secret-user\npassword=secret-password";
        Path secret = Paths.get("/tmp/secret.properties");

        Files.write(secret, content.getBytes(StandardCharsets.UTF_8));
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.getUsername()).isEqualTo(("secret-user"));
        assertThat(config.getPassword()).isEqualTo(("secret-password"));

        Files.delete(secret);
    }

}
