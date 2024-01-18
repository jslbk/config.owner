package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.MobileConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileTest {

    @Test
    public void testMobile() {
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("iPhone 15 Pro Max");
        assertThat(config.getPlatformVersion()).isEqualTo(17.5);
        assertThat(config.getPlatformName()).isEqualTo("iOS");
    }

    @Test
    public void testMobileWithSystemOverride() {
        System.setProperty("platform.version", "18");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("iPhone 15 Pro Max");
        assertThat(config.getPlatformVersion()).isEqualTo(18);
        assertThat(config.getPlatformName()).isEqualTo("iOS");
    }

    @Test
    public void testMobileWithAndroid() {
        System.setProperty("device", "android");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("Google Pixel");
        assertThat(config.getPlatformVersion()).isEqualTo(13);
        assertThat(config.getPlatformName()).isEqualTo("Android");
    }

    @Test
    public void testMobileWithIOS() {
        System.setProperty("device", "ios");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("iPhone 15 Pro Max");
        assertThat(config.getPlatformVersion()).isEqualTo(18);
        assertThat(config.getPlatformName()).isEqualTo("iOS");
    }

}
