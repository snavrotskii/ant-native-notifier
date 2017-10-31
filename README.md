# Apache Ant build completion notification

This ant build tool listener makes system tray notification after build completion.

![alt text](https://user-images.githubusercontent.com/33085728/32001653-0a48c2cc-b9a3-11e7-9787-7b8615e7ae55.png)  ![alt text](https://user-images.githubusercontent.com/33085728/32113170-30ff8f58-bb48-11e7-8f9e-3884db53cb5a.png)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To build project you may use maven build tool ([download maven page](https://maven.apache.org/download.cgi)). 

### Installing

##### Windows
```
git clone https://github.com/snavrotskii/ant-native-notifier.git
```
```
cd ./ant-native-notifier/
```
```
mvn clean package
```
```
set ANT_ARGS= -listener name.snavrotskiy.ant.listener.AntNativeNotificationListener -lib %cd%\target\ant-native-notifier-1.0-SNAPSHOT-jar-with-dependencies.jar
```

```
cd to ant based project
ant build
```

##### UNIX
```
git clone https://github.com/snavrotskii/ant-native-notifier.git
```
```
cd ./ant-native-notifier/
```
```
mvn clean package
```
```
export ANT_ARGS='-listener name.snavrotskiy.ant.listener.AntNativeNotificationListener -lib '$(pwd)'/target/ant-native-notifier-1.0-SNAPSHOT-jar-with-dependencies.jar'
```

```
cd to ant based project
ant build
```

### Configuration
Notifiers can be configured by creating the file $HOME/.send-notification.
This file should contains properties in the form: key = value.

    notifier.implementation = which implementation to use. (growl, notificationcenter, simplenc notifysend, systemtray, snarl, pushbullet, kdialog, notifu, anybar, toaster, notify, burnttoast, slack).

Please find more details in [send-notification/wiki](https://github.com/jcgay/send-notification/wiki)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details