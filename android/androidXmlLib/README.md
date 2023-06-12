androidXmlLib README file.
Richard Schilling (richard@aesirmachina.com)
June 2023. Seattle.

June 12, 2023
I have been trying to port JAXP and other XML related libraries to the Android platform. I notice a couple of things about the existing implementation for the Java platform: 

1. the implementation is large and complex. It could be smaller and more straightforward for Android.
2. the runtime model isn't explicitely supported. All classes need to be written with the android lifecycle in mind. Handlers should be used, for example to perform large processing tasks such as XML parsing.
3. Android could benefit from having it's own namespace to isolate code (same is true for erlang, BTW, but that's another story for a different library).

So with those things in mind, I'm creating a package module called "android.xml" which allows me to prot existing code for JAXP processing and XML onto the Android platform. My work with jakartee libraries and JAXP and XML porting to Android over the past week has convinced me that this should be a straightforward task. 

The strategy to accomplish this: I will copy open source libraires as is and then begin to strip them down to optimize them for Androd. I need to get them into a single library first and then do that work so I can ensure that things compile and run properly along the way.

