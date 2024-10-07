## Java 时间工具与配置管理工具

### 简介

本项目提供了一组 Java 工具类，用于处理时间相关操作和管理应用程序配置。

* **Time 类:** 提供了一系列静态方法，用于获取当前时间、格式化时间、以及进行时间转换等操作。
* **Config 类:** 基于 Jackson 库，提供了一种灵活的方式来存储和加载应用程序配置。支持自定义数据类型，并能将配置数据序列化为
  JSON 格式。
* **Main 类:** 作为应用程序的入口点。

### 功能概述

* **Time 类:**
    * 获取当前时间：以 `Date` 对象或格式化字符串的形式返回当前时间。
    * 时间格式化：支持自定义格式化模式，将时间转换为指定格式的字符串。
    * 时间转换：将系统时间（毫秒）转换为 `Date` 对象。
* **Config 类:**
    * 配置文件管理：支持将配置数据保存到文件中，并从文件中加载配置数据。
    * 数据类型支持：支持自定义数据类型作为配置对象。
    * JSON 序列化：将配置数据序列化为 JSON 格式。
* **Main 类:**
    * 命令行参数解析：使用 Apache Commons CLI 解析命令行参数，支持 `-h` (帮助) 和 `-v` (版本) 选项。

### 使用方法

1. **引入依赖:**
    * **Jackson:** 用于 JSON 序列化和反序列化。
    * **Lombok:** (可选) 简化 Java Bean 的编写。
    * **Apache Commons CLI:** 用于解析命令行参数。

2. **创建配置类:**
    * 定义一个 Java 类，表示你的配置数据。
    * 创建 `Config` 对象，指定配置类、文件名和初始数据。

3. **加载配置:**
    * 调用 `loadOrFail()` 方法从文件中加载配置数据(如果文件不存在则会创建一个文件)。

4. **保存配置:**
    * 调用 `saveOrFail()` 方法将配置数据保存到指定文件中。

5. **使用时间工具类:**
    * 调用 `Time` 类中的静态方法获取当前时间或进行时间转换。

### 示例

```java
// 创建配置类
@Data
class MyConfig {
    private String name;
    // ... 其他配置项
}


class Example {
    @Test
    public void testXmlConfig() throws IOException {
        XmlConfig<MyConfig> myConfigConfig = new XmlConfig<>(new MyConfig(), "config.xml");
        MyConfig myConfig = myConfigConfig.loadOrFail();

        myConfig.setName("testBean");

        myConfigConfig.saveOrFail();

        System.out.println(myConfigConfig.toXml());
    }
}
```