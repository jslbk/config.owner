package qa.guru.owner.config;

import org.aeonbits.owner.Config;

// @Config.LoadPolicy(Config.LoadType.FIRST) // Load first properties from the sources

@Config.Sources({
        "classpath:${device}.properties",
        "classpath:mobile.properties"
})
public interface MobileConfig extends Config {

    @Key("device.name")
    String getDeviceName();

    @Key("platform.name")
    String getPlatformName();

    @Key("platform.version")
    Double getPlatformVersion();

}
