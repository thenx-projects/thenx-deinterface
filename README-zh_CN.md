# Thenx De-interface

[English](./README.md) | 简体中文

​		**Thenx De-interface** *(简称 TDI)* 是一个基于 **Java生态** 的 **去中间化接口开发平台** 项目，诣指在如今复杂多变的项目开发中随着业务的增长而产生诸多的冗余接口，其在一定程度上降低了企业级项目开发效率、提高了企业级项目开发成本、复杂化了企业级项目维护难度。

​		基于如上问题，诞生了 **TDI** 项目，通过基于 **数据** 的 **Create**、**Retrieve**、**Update**、**Delete** 四个操作将其统一为弹性后台接口且有且仅有四个接口。

------

## 寻求帮助

如果您在使用 TDI 的时候碰到了任何问题，我们可以随时提供帮助 !

- 通过 [提问题](https://github.com/thenx-projects/thenx-deinterface/issues) 的方式来告诉我们您所遇到的问题。
- 通过邮件的方式来告诉我们您所遇到的问题 (opensource@thenx.org)

## 反馈问题

如果您在使用 TDI 的过程中发现了任何 BUG 或者新的功能建议，可直接通过 [提交 ISSUES](https://github.com/thenx-projects/thenx-deinterface/issues) 的方式来告诉我们 !

## 从源码构建项目

TDI 项目使用 Gradle 来构建当前 main 分支的最新项目。值得注意的是，本项目基于 OpenJDK 11，我们所使用的是 **Amazon corretto-11** 版本，理论上来说只要是 JDK11 都可以运行和编译本项目。

我们仅仅需要执行如下指令可克隆下来 main 分支的最新代码：

```shell
$ git clone --depth=1 https://github.com/thenx-projects/thenx-deinterface.git
```

## 模块说明

TDI 有几个重要模块，如下是一个快速概览：

### thenx-deinterface-projects-common

该模块是整个 TDI 项目的公共代码模块。

## thenx-deinterface-projects-config

该模块是 TDI 项目中公共配置模块，诸如项目的配置、Redis 的配置、数据库的配置等。

## thenx-deinterface-projects-entrance

该模块是整个项目的入口模块。

## thenx-deinterface-projects-unified

该模块是整个项目的引擎模块，包括但不限于增、删、改、查、语义等功能解析。

------

## License

Thenx De-interface is Open Source software released under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0.html).