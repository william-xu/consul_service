#简介

SpringBoot注册到consul以及使用consul作为配置中心的示例。

运行示例需要启动consul服务节点并且在上面设置配置信息，具体可查看下面，启动前需要修改bootstrap.yml中的本地配置


## 配置

  * 在consul服务端Key/Value页面创建key "config/consul_service,dev/data"
  * 配置Value内容如下，并在右下角设置为YAML：
springDatasourceUrl: "jdbc:mysql://192.168.43.101:3306/demodb"
signingKey: "34234234"
spring:
  database:
    driverClassName: "com.mysql.jdbc.Driver"
    url: "jdbc:mysql://192.168.43.80:3306/demodb?useUnicode=true&characterEncoding=utf-8&useSSL=false"
    username: "root"
    password: "123456"
    testWhileIdle: "true"
    validationQuery: "SELECT 1"
  * key相关解说：
     * "/"表明前面的是文件夹，","逗号也是属于名称的一部分，这里逗号后面为profile名称
     * "config/consul_service,dev/data" 这个key保存后，会生成config、consul_service,dev两个文件夹，
                     在consul_service,dev文件夹下生成data数据项，保存上面配置的Value内容    
    
## Distributed Configuration with Consul
example, an application with the name "testApp" and with the "dev" profile will have the following property sources created:

config/testApp,dev/
config/testApp/
config/application,dev/
config/application/    
    
The most specific property source is at the top, with the least specific at the bottom. Properties in the config/application folder are applicable to all applications using consul for configuration. Properties in the config/testApp folder are only available to the instances of the service named "testApp".

Configuration is currently read on startup of the application. Sending a HTTP POST to /refresh will cause the configuration to be reloaded. Section 4.3, “Config Watch” will also automatically detect changes and reload the application context.

YAML must be set in the appropriate data key in consul. Using the defaults above the keys would look like:
config/testApp,dev/data
config/testApp/data
config/application,dev/data
config/application/data

To disable the Config Watch set spring.cloud.consul.config.watch.enabled=false.

You can change the data key using spring.cloud.consul.config.data-key

Consul Config may be customized using the following properties:

bootstrap.yml. 

spring:
  cloud:
    consul:
      config:
        enabled: true
        prefix: configuration
        defaultContext: apps
        profileSeparator: '::'
        
enabled:  			setting this value to "false" disables Consul Config
prefix:  			sets the base folder for configuration values
defaultContext: 	sets the folder name used by all applications
profileSeparator:	sets the value of the separator used to separate the profile name in property sources with profiles


### 配置示例
假如创建的key为： config2/consul_service,prod/data2    
那么对应项目bootstrap.yml的相关配置：
spring:
  application:
    name: consul_service
  profiles:
    active: prod    
  cloud:
    consul:
      config:
        format: YAML
        enabled: true
        prefix: config2
        data-key: data2   

    

## 问题
	* 配置在application下面，即全局配置的刷新要比服务级别配置的刷新慢不少，服务级别的默认是1秒，改动后几乎就立刻刷新了，全局配置的刷新在哪里设置？
	* git2consul     
