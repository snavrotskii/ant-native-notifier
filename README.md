# Apache Ant build completion notification

This ant build tool listener makes system tray notification after build completion.

![alt text](https://user-images.githubusercontent.com/33085728/32001653-0a48c2cc-b9a3-11e7-9787-7b8615e7ae55.png)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To build project you may use maven build tool ([download maven page](https://maven.apache.org/download.cgi)). 

### Installing

##### Windows
```
git clone https://github.com/snavrotskii/ant-native-notifier.git
cd ./ant-native-notifier/
mvn clean package
set ANT_ARGS='-listener name.snavrotskiy.ant.listener.AntNativeNotificationListener -lib %cd%\target\ant-native-notifier-1.0-SNAPSHOT.jar'
```

```
cd to ant based project
ant build
```

##### UNIX
```
git clone https://github.com/snavrotskii/ant-native-notifier.git
cd ./ant-native-notifier/
mvn clean package
export ANT_ARGS='-listener name.snavrotskiy.ant.listener.AntNativeNotificationListener -lib '$(PWD)'/target/ant-native-notifier-1.0-SNAPSHOT.jar'
```

```
cd to ant based project
ant build
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details