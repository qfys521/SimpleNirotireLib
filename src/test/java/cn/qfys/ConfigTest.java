package cn.qfys;

import cn.qfys521.file.Config;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void testConfig() {
        Config<TestBean> testBeanConfig = new Config<>(new TestBean(), "bean.json", TestBean.class);
        TestBean testBean = testBeanConfig.loadOrFail();
        testBean.setName("testBean");
        testBean.setId(1);
        System.out.println(testBean);
        testBeanConfig.saveOrFail();
        System.out.println(testBeanConfig);
    }

}
