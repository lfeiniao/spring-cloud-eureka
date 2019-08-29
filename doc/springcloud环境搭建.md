# spring cloud 环境搭建
基本概论：spring cloud 依赖于springboot，本质上来说，springcloud 就是springboot 项目，下面以maven为例记录搭建过程：
1. 使用maven构建一个空白的java 工程
2. 添加maven 依赖，parent 依赖springboot，springboot 选择合适的版本
3. 使用maven的dependencyManagement import (查看maven的用法) springcloud 注意这里springcloud 和springboot 使用版本对应关系的
4. 子模块按需引入springcloud 的相关模块
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>2.1.3.RELEASE</version>
  </parent>
  <groupId>com.ly.springeureka</groupId>
  <artifactId>springeureka</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>pom</packaging>

  <modules>
  	<module>eurekaserver</module>
  	<module>eurekaclient</module>
  </modules>
  
  <properties>
  	<spring-cloud.version>Greenwich.RELEASE</spring-cloud.version>
  </properties>
  
  <dependencies>
  	<dependency>
	    <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
	</dependency>
  </dependencies>
  
  <dependencyManagement>
  	<dependencies>
  		<dependency>
		    <groupId>org.springframework.cloud</groupId>
		    <artifactId>spring-cloud-dependencies</artifactId>
		    <version>${spring-cloud.version}</version>
		    <type>pom</type>
		    <scope>import</scope>
		</dependency>
  	</dependencies>
  </dependencyManagement>
</project>
```