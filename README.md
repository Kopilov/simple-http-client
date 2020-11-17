# Simple HTTP client
Small HTTP client with GUI writen in Java.
Can send hand-written requests and display responses (like netcat) and help to generate requests.
Requests are generated as
```
METHOD + URL.Path + HTTP/1.1
headers (Host and Content-length added automatically)

body (if method is POST or PUT)
```

You can download Jar from [Maven Central](https://repo1.maven.org/maven2/com/github/kopilov/simplehttpclient/simplehttpclient/0.2/simplehttpclient-0.2.jar)

If you do not have any Java software, download and install JRE (http://java.com/download)
to run compiled program and add directory with 'java' program (jre/bin) to your
system variable PATH or write full path to 'java' in bat|sh file of this software.

