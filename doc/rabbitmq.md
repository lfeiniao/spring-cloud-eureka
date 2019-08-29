# rabbitmq 学习笔记
## rabbitmq 安装配置

rabbitmq 官方安装说明: <https://www.rabbitmq.com>
官网中，有Download+Installation 按钮，点击查看详细介绍

Rabbitmq 依赖Erlang,所以需要先安装Erlang
Erlang下载地址: <https://www.erlang.org/downloads>
Rabbitmq下载地址: <https://www.rabbitmq.com/download.html>

1.先下载Erlang 并进行安装，配置安装路径到环境变量到path 中
2.在安装Rabbitmq 中需要注意两个问题，用户路径不能为中文，安装路径不能有空格和中文
如果用户路径为中文：eg:C:\Users\中文\AppData，则需要配置一个环境变量，RABBITMQ_BASE ： D:\java\mq\rabbitmq_server-3.7.13\data（本人mq RabbitMq的安装路径）
3.安装，RabbitMq ，安装完成，服务会自行启动

4. 到开安装位置的cmd -->D:\java\mq\rabbitmq_server-3.7.17\sbin>
5. 输入rabbitmqctl satus 可以查看rabbitmq 状态，正常启动的状态下会有一大段输出
6. 输入，rabbitmq-plugins enable rabbitmq_management 启动rabbitmq插件
7. 访问rabbitmq web 页面地址：http://localhost:15672/#/ ,用户名和密码都是guest