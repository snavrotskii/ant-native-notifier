# Apache Ant finish build notification

This listener make native system tray notification after build completion 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To build project you may use maven build tool ([download maven page](https://maven.apache.org/download.cgi))

### Installing

```
git clone https://github.com/snavrotskii/ant-native-notifier.git
cd ./ant-native-notifier/
mvn clean package
export ANT_ARGS=-listener name.snavrotskiy.ant.listener.AntNativeNotificationListener \
    -lib ./target/ant-native-notifier-1.0-SNAPSHOT.jar
```

After that you able to run any ant build with system native notifications


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details