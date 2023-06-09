# jakartaee-mobile Readme 
Richard Schilling (https://github.com/dexmagic/)   
June 9, 2023
Seattle  

I was porting some libraries to Android that are built on Java Architecture for XML Binding (JAXB) to Android and ran into some barriers. I'll repeat them here for anyone else who has struggled with the same thing: 
1. Lots of people seem to have the same need.
2. The Android project used to build JAXB need to be set up to support Android 19 and higher (see links on Java 19 below).
3. There is a need for a complete XML binding on Android, and JAXB isn't implemented on Android.
4. As Java itself changes, I need a working project to verify what features of the Java language are actually supported in any Android production build.

Jakarta EE to the rescue! 

There are some additional benefits in creating this project that have to do with building Android libraries and apps on the latest version of Android Studio, Gradle Plugin, and Java source level.

4. Java 9 Modules means that liraries written for Android need to avoid namespace collisions.
5. Any JAXB solution on Android close as possible to Oracles' implementation on the Java platform. This is required to minimize the work required to port existing JAXB generate code (client code and potentially server code as well) to Android.
6. I need to stay ahead of the impact using ```sourceCompatibility JavaVersion.VERSION_19``` and higher would have Android applications.
7. I need to know how gradle plugin 8.0 and higher impact older Android applications so I can migrate them.

And what better way to achieve all those goals than to build an app with the latest Gradle plugin and highest available Java Source compatability.  So this project ports the relevant code at https://github.com/jakartaee to run on Android, AND specifies the source compatability of ANDROID_19.


## About This Project

This project copies code from https://github.com/jakartaee with the minimal changes possible. At the moment this is the most viable option to create an Android port. Some changes that cannot be merged back into the original repository are required, however. So simply making direct copies of source that can be compiled on the Android platform is the best option at the moment. 

For example, ```module-info.java``` files need to be left out because they create errors. Including this file from the jaxb-api project into the module ```jaxbapi``` of this repository ...

```java

module jakarta.xml.bind {
    requires transitive jakarta.activation;
    requires transitive java.xml;
    requires java.logging;

    exports jakarta.xml.bind;
    exports jakarta.xml.bind.annotation;
    exports jakarta.xml.bind.annotation.adapters;
    exports jakarta.xml.bind.attachment;
    exports jakarta.xml.bind.helpers;
    exports jakarta.xml.bind.util;

    uses jakarta.xml.bind.JAXBContextFactory;
}
```

causes the following error:

```
jakartaee-mobile/android/jaxbapi/src/main/java/module-info.java:18: error: module not found: jakarta.activation
    requires transitive jakarta.activation;
                               ^
```

## Some Useful Links

### Java 8 And Beyond

In order to build and maintain applications that run Java EE/JAXB code it's important to have the latest language support. That is the reason this project specifies a very high JavaVersion in build.gradle files. Here is an example from the jaxbapi module in this project:

```
android {
    namespace 'jakarta.xml.bind'
    compileSdk 33

    defaultConfig {
        minSdk 33
        targetSdk 33
        
        // ...
    }

    buildTypes {
        // ...
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_19
        targetCompatibility JavaVersion.VERSION_19
    }
}
```

Lots of reading is required to fully understand all the reaasons you would specify JavaVersion.VERSION_19 and higher in your gradle files. So here are some convenient links to help you catch up if you need to.

### Gradle Compatability and Java Version 19

As of this writing (June 9, 2023) Gradle does not support Java 20, so the highest Java version I could specify is VERSION_19.

 * Gradle's compatability matrix drives what version of Java is available: https://docs.gradle.org/current/userguide/compatibility.html
 * What you get by specifying JavaVersion.VERSION_19 and higher: https://developer.android.com/studio/write/java8-support
 * Google's release notes related to Java Version 8: https://github.com/google/desugar_jdk_libs/blob/master/CHANGELOG.md
 * A list of Java 8 features supported in older apps too as a reference: https://developer.android.com/studio/write/java8-support-table

Some notes:
 * Gradle 7.6 is the first version that supports Android 19.


### Oracle Source Docs and Information

 * Oracle's official JAXB web page: https://www.oracle.com/technical-resources/articles/javase/jaxb.html
 * Architecture: https://docs.oracle.com/javase/8/docs/technotes/guides/xml/jaxb/index.html
 * XJC, which compiles an XML schema file into fully annotated Java classes.: https://docs.oracle.com/javase/8/docs/technotes/tools/unix/xjc.html
 * Java Tutorials: https://docs.oracle.com/javase/tutorial/jaxb/intro/examples.html
 * Java 19 Release notes: https://www.oracle.com/news/announcement/oracle-releases-java-19-2022-09-20/
 * Android 11 Release notes (announcing the removal of JAXB/CORBA): https://www.oracle.com/java/technologies/javase/11-relnote-issues.html
 * Java 19 Release documentation: https://docs.oracle.com/en/java/javase/19/index.html
 * 

### Jakarta EE

The Eclipse project also implemements a version of JAXB.

 * Jakarta's official JAXB page: https://eclipse-ee4j.github.io/jaxb-ri/
 * Jakarta's official GitHub page: https://github.com/jakartaee

### Some Additional Links and Reading Material

 * JAXB and Java EE Removal on Java 11: https://www.jesperdj.com/2018/09/30/jaxb-on-java-9-10-11-and-beyond/
 * More on the same topic: https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception
 * 

