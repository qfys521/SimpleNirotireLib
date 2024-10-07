package cn.qfys;

import cn.qfys521.file.JsonConfig;
import cn.qfys521.file.PropertiesConfig;
import cn.qfys521.file.XmlConfig;
import cn.qfys521.file.YamlConfig;
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

}
