# Thenx De-interface

## 一、概述

​		**Thenx De-interface** 是一个基于 **Java生态** 的 **去中间化接口开发平台** 项目，诣指在如今复杂多变的项目开发中随着业务的增长而产生诸多的冗余接口，其在一定程度上降低了企业级项目开发效率、提高了企业级项目开发成本、复杂化了企业级项目维护难度。

​		基于如上问题，诞生了 **Thenx De-interface** 项目，通过基于 **数据** 的 **Create**、**Retrieve**、**Update**、**Delete** 四个操作将其统一为弹性后台接口且有且仅有四个接口。


## 二、所涉及到的技术及文档

​		本项目中引用到了如下技术，可通过地址直接查看:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.0/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.0/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#boot-features-developing-web-applications)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#boot-features-redis)

## 三、从源码构建项目

​		一切操作均需要从 [Thenx De-Interface](https://github.com/thenx-projects/thenx-deinterface) 项目中 Fork 到自己仓库。便于各项目贡献者提交、合并代码。

### 3.1. 项目的预配置

#### 3.1.1.  Git Clone

​		执行如下指令将 [Thenx De-Interface](https://github.com/thenx-projects/thenx-deinterface) 项目 **Clone** 下来：

```shell
$ git clone --depth=1 https://github.com/thenx-projects/thenx-deinterface.git
```

​		**注意: 你需要将 Clone 地址更换为你 Fork 之后的仓库地址 !**

#### 3.1.2. 配置远程主仓库

​		执行如下指令配置 **Thenx De-interface** 主仓库

```shell
$ git remote add upstream https://github.com/thenx-projects/thenx-deinterface.git

# 通过如下指令可查看是否配置成功，其中两条 origin，两条 upstream
$ git remote -v
```

