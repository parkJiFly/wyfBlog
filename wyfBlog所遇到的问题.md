# wyf博客

## 1、配置部分

### 1、报错

(1)	java.lang.IllegalArgumentException: Invalid value type for attribute 'factoryBeanObjectType': java.lang.String 	at org.springframework.beans.factory.support.FactoryBeanRegistrySupport

（2）	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath. 	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).

（3） Bean named 'ddlApplicationRunner' is expected to be of type 'org.springframework.boot.Runner' but was actually of type 'org.springframework.beans.factory.support.NullBean'



版本对比

​		 SpringVersion				 	SpringBootVersion

​		5.3.24									2.7.7

​		6.1.8										3.3.0

## 1、登录用户部分

### 1    result

- `@JsonInclude(JsonInclude.Include.NON_NULL)` 确保当 `address` 为null时，它不会被包含在JSON输出中。
- `@Getter` 生成 `getName()`, `getAge()` 和 `getAddress()` 方法。
- `@NoArgsConstructor` 生成一个无参构造函数 `public MyClass() { }`。
