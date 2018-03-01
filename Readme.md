## Simple web chat on SockJS

This is a simple SockJS(STOMP) web chat.

## Requirements

1. Java >= 1.6.x

2. Maven - 3.x.x

## How to setup web chat application

Clone the application

```bash
git clone https://github.com/jmember2015/chatgenesys.git
```

Build the app using maven

```bash
cd chat-genesys
mvn package
```

Deploy war-artifact to Jetty container

```bash
Open pom.xml in any text editor
Edit line <jetty.abspath>/usr/local/Cellar/jetty/9.4.8.v20171121/libexec</jetty.abspath>
Remove /usr/local/Cellar/jetty/9.4.8.v20171121/libexec and insert your PC (or Mac) absolute path to jetty 9 installation
Save pom.xml file 

You can now install our application by executing:

mvn install
mvn cargo:deploy

Change to the directory jetty 9 installation and type  java -jar start.jar

Type URL in the browser: http://localhost:8080/appchat/
```

