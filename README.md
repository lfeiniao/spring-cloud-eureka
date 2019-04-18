# spring-cloud-eureka
环境搭建
1.两个maven项目,一个eureka 客户端，一个eureka 服务端
根据spring官网搭建，注意版本问题，不要随便换版本，会有各种不兼容问题
官网上有个bug，客户端项目没有引入web依赖，没有tomcat ，无法正常启动
所有的代码在release 中
