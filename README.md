## A JavaFx-Kotlin boilerplate for Raspberry Pi ##

A boilerplate project to easily get a JavaFX app running on a Raspberry Pi. The app has a programmatic access to the low-level hardware I/O capabilities (thanx to the Pi4J v2 library) and can be extended with the Kotlin language. 

This project has been developed and tested with the RaspberryPi OS (Raspbian GNU/Linux 10 (buster)) running on a Raspberry Pi 4B 4Go board.

### Prerequisites for your RaspberryPi OS
* JDK >= 11 (to be installed: sudo apt install openjdk-11-jdk)
* the maven tool (to be installed: sudo apt install maven)
* Pi4J v2 (automatically installed with maven from file pom.xml)
* openJavaFX >=16 from Gluon (to be installed: see below)
* Kotlin (automatically installed with maven from file pom.xml)

### Installation
On your Raspberry Pi, a JDK >= 11 and the tool maven have to be installed. 
During the assembly step, maven packages the linux SDK for JavaFX instead of the ARM one. Consequently, the pom file removes those dependencies and copies the SDK that should be stored in the assets/javafx/arm directory. You have to download the ARM SDK by yourself from the [Gluon Downloads page](https://gluonhq.com/products/javafx/).

Once done, in the project root dir, type: mvn clean package

### Running

From the project dir, type : sudo -E ./target/distribution/run.sh