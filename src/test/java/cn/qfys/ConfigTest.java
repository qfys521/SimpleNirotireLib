package cn.qfys;

import cn.qfys521.config.JsonConfig;
import cn.qfys521.config.PropertiesConfig;
import cn.qfys521.config.XmlConfig;
import cn.qfys521.config.YamlConfig;
import cn.qfys521.util.RandomUtil;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void testJsonConfig() throws IOException {
        JsonConfig<TestBean> testBeanConfig = new JsonConfig<>(new TestBean(), "bean.json");
        TestBean testBean = testBeanConfig.loadOrFail();

        testBean.setName("testBean");
        testBean.setId(1);

        testBeanConfig.saveOrFail();

        System.out.println(testBeanConfig.toJson());
    }

    @Test
    public void testYamlConfig() throws IOException {
        YamlConfig<TestBean> testBeanConfig = new YamlConfig<>(new TestBean(), "bean.yml");
        TestBean testBean = testBeanConfig.loadOrFail();

        testBean.setName("testBean");
        testBean.setId(1);

        testBeanConfig.saveOrFail();

        System.out.println(testBeanConfig.toYaml());
    }

    @Test
    public void testPropertiesConfig() throws IOException {
        PropertiesConfig<TestBean> testBeanConfig = new PropertiesConfig<>(new TestBean(), "bean.properties");
        TestBean testBean = testBeanConfig.loadOrFail();

        testBean.setName("testBean");
        testBean.setId(1);

        testBeanConfig.saveOrFail();

        System.out.println(testBeanConfig.toProperties());
    }

    @Test
    public void testXmlConfig() throws IOException {
        XmlConfig<TestBean> testBeanConfig = new XmlConfig<>(new TestBean(), "bean.xml");
        TestBean testBean = testBeanConfig.loadOrFail();

        testBean.setName("testBean");
        testBean.setId(1);

        testBeanConfig.saveOrFail();

        System.out.println(testBeanConfig.toXml());
    }

    @Test
    public void testRandom() {
        System.out.println(RandomUtil.randomInt(100));
        System.out.println(RandomUtil.randomLong(Long.MAX_VALUE));
        System.out.println(RandomUtil.randomInt(Integer.MAX_VALUE));
    }
}
