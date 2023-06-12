# Ports of Jakarta EE libraries to Android.

Source code is copied into this project and modified for Android because the build systems can't yet be directly integrated.
The module androidXmlLib is created to provide references to OpenJDK and Oracle source on the JDK platform that is needed for the jaxbapi libraries to compile. Some notes about this module:
 * all classes in the package jakarta.xml.stream are a straight copy of the Oracle JDK 18 classes and with the package name changed only. 


