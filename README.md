# Thenx De-interface

English | [简体中文](./README-zh_CN.md)

**Thenx De-interface** *(TDI for short)* is a Java ecology-based de-intermediation interface development platform project, which refers to many redundant interfaces in today's complex and changeable project development, which reduce the efficiency of enterprise project development, improve the cost of enterprise project development, and complicate the maintenance difficulty of enterprise project to some extent.

Based on this problem, the TDI project was born, unifying the data based **Create**, **Retrieve**, **Update**, and **Delete** operations into a flexible backend interface with only four interfaces.

------

## Seek help

If you have any problems using TDI, we are always available to help!

- Tell us about the problems you have by [asking questions](https://github.com/thenx-projects/thenx-deinterface/issues). 
- Let us know by email what problems you have (opensource@thenx.org).

------

## Feedback problem

If you find any bugs or new feature suggestions in the process of using TDI, let us know directly by [submitting ISSUES!](https://github.com/thenx-projects/thenx-deinterface/issues)

------

## Building projects from source

TDI projects use Gradle to build the latest project for the current main branch. It is worth noting that this project is based on OpenJDK 11, which we are using with the **Amazon corretto-11** version, which in theory can be run and compiled as long as it is JDK 11.

We just need to execute the following instructions to clone the latest code from the main branch:

```shell
$ git clone --depth=1 https://github.com/thenx-projects/thenx-deinterface.git
```

------

## Module description
TDI has several important modules, and here is a quick overview:

### thenx-deinterface-projects-common

This module is the common code module for the entire TDI project.

### thenx-deinterface-projects-config

This module is a common configuration module in a TDI project, such as project configuration, Redis configuration, database configuration, and so on.

### thenx-deinterface-projects-entrance

This module is the entrance module of the whole project.

### thenx-deinterface-projects-unified

This module is the engine module of the whole project, including but not limited to adding, deleting, modifying, checking, semantic and other functions.

------

## License

Thenx De-interface is Open Source software released under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0.html).