package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.FruitConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitsTest {

    @Test
    public void testArray() {
        System.setProperty("array", "banana,apple");

        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsArray())
                .containsExactly("banana", "apple");
    }

    @Test
    public void testList() {
        System.setProperty("list", "banana,orange");

        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsList())
                .containsExactly("banana", "orange");
    }

    @Test
    public void testArrayWithDefaultValue() {
        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsArrayWithDefaultValues())
                .containsExactly("orange", "apple");
    }

    @Test
    public void testArrayWithSeparator() {
        FruitConfig config = ConfigFactory.create(FruitConfig.class, System.getProperties());
        assertThat(config.getFruitsListWithSeparator())
                .containsExactly("orange", "banana");
    }

}
