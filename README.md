# spring cloud 学习笔记
# [spring cloud 环境搭建](./doc/springcloud环境搭建.md)
# [spring-cloud-eureka](./doc/)
环境搭建 eurekaserver
- 在上面的springcloud maven 项目中加入两个maven modules 分别为eurekaserver, eurekaclient
- eurekaserver 引入服务端相关依赖，
- 写启动类加上相关注
- 添加配置文件
- 启动服务，访问http://localhost:9000/ 查看eureka 的相关信息，此时还没有任务服务注册到eureka 中

```yaml
server:
  port: 9000

spring:
  application:
    name: eurekaserver
    
eureka:
  client:
    register-with-eureka: false # 是否注册到eureka中
    fetch-registry: false # 是否从eureka 中获取信息
    service-url:
      defaultZone: http://localhost:${server.port}/eureka # eureka 服务器的地址

```

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
	}
}

```
**eureka pom 文件**
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.ly.springcloud</groupId>
  	<artifactId>springcloud</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <artifactId>eurekaserver</artifactId>
  <dependencies>
	<!-- eureka maven仓库中有好几个，别选错了 -->
	<dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
  </dependencies>
</project>
```
eureka 集群的搭建：
eureka 集群是为了注册中心的高可用，主要原理就是通过相互注册来实现。即配置文件中的defaultZone 指定所有其他的eurekaserve地址,多个使用逗号（,）分隔。实现过程
- 集群搭建需要多个eureka 服务端。这里采用打成jar .使用不同配置文件多次启动的方式来实现
- 将上面的配置文件赋值两份，出来，分别取名为application-dev.yml 和 application-prod.yml
然后进行适当修改注意几点：server.port 要不同，否则无法多次启动。spring.application.name 要相同。增加eureka.instance.hostname,配置两边要不同，删除上面注册和获取的两个false配置，或者修改为true.(register-with-eureka)，即配置文件中的defaultZone，使用host 文件，配置域名IP映射文件的方式，不要直接写localhost
- 配置host文件，将eurekaserver1 域名映射到服务器IP地址（127.0.0.1），打包项目为jar,使用spring.profiles.active = ? 指定不同的文件，启动项目两次
- 打开浏览器，localhost:9000和localhost:9010, 可以看到DS Replicas 和 available-replicas 中都有对方的值

**application-dev.yml**

```yaml
server:
  port: 9010

spring:
  application:
    name: eurekaserver
    
eureka:
  instance:
    hostname: eurekaserver2
  client:
    service-url:
      defaultZone: http://eurekaserver1:9000/eureka # eureka 服务器的地址

```
**application.prod.yml**
```yaml
server:
  port: 9000

spring:
  application:
    name: eurekaserver
    
eureka:
  instance:
    hostname: eurekaserver1
  client:
    service-url:
      defaultZone: http://eurekaserver2:9010/eureka # eureka 服务器的地址

```

