package qa.guru.owner.config;

import org.aeonbits.owner.Config;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public interface TypeConfig extends Config {

    @Key("integer")
    Integer getInteger();

    @Key("double")
    Double getDouble();

    @Key("boolean")
    Boolean getBoolean();

    @Key("enum")
    Browser getEnum();

    @Key("File")
    File getFile();

    @Key("URL")
    URL getURL();

    @Key("Path")
    Path getPath();

    @Key("byte[]")
    Byte getByte();

}