# jakartaee-mobile Readme File.
Ricahrd Schilling (https://github.com/dexmagic/)   
June 9, 2023  
Seattle  

I was porting some libraries to Android that are built on Java Architecture for XML Binding (JAXB) to Android and ran into some barriers. I'll repeat them here for anyone else who has struggled with the same thing: 
1. Lots of people seem to have the same need.
2. The Android project used to build JAXB need to be set up to support Android 19 and higher (see links on Java 19 below).
3. There is a need for a complete XML binding on Android, and JAXB isn't implemented on Android.
4. Java 9 Modules means that liraries written for Android need to avoid namespace collisions.
5. Any JAXB solution on Android close as possible to Oracles' implementation on the Java platform. This is required to minimize the work required to port existing JAXB generate code (client code and potentially server code as well) to Android.

Jakarta EE to the rescue!

So this project ports the relevant code at https://github.com/jakartaee to run on Android.

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
 * What you get by specifying JavaVersion.VERSION_19 and higher: https://developer.android.com/studio/write/java8-support
 * Google's release notes related to Java Version 8: https://github.com/google/desugar_jdk_libs/blob/master/CHANGELOG.md


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

