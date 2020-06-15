How to Run: (TraditionalTestsV1 and TraditionalTestsV2 Projects)
==========
Pre requisites:
==============
1. Java 8 installed and setup in path environment variable locally
2. Maven installed and setup in path environment variable locally
3. Chrome Browser version Version 83.0.4103.97 (Official Build) (64-bit)
   And Firefox Browser version 77.0.1 (64-bit)
   
 Note:
 ----  
   If you have a different browser versions than these, please download the chromedriver.exe and geckodriver.exe
   from the internet that is suitable with your version of the browser and replace those with the ones in drivers/
   folder at the root directory AppliFashionAppTests. i.e., inside "AppliFashionAppTests\drivers" folder.

How to Run the tests:
=====================
Goto project directory say,
"C:\workspace\AppliFashionAppTests\TraditionalTestsV1"
Then run this command "mvn clean verify"
C:\workspace\AppliFashionAppTests\TraditionalTestsV1>mvn clean verify

Similarly for "TraditionalTestsV2" Project,
Goto project directory say,
"C:\workspace\AppliFashionAppTests\TraditionalTestsV2"
Then run this command "mvn clean verify"
C:\workspace\AppliFashionAppTests\TraditionalTestsV2>mvn clean verify

Where to see test results:
==========================
Test Results will be generated inside project directory . In our example,
C:\workspace\AppliFashionAppTests\TraditionalTestsV1/target/surefire-reports/index.html

For TraditionalTestsV2,
C:\workspace\AppliFashionAppTests\TraditionalTestsV2/target/surefire-reports/index.html

The screenshot of test results on my local run are available here...
"TraditionalTestsV1\TestRun_Results_Local_V1.png"
"TraditionalTestsV2\TestRun_Results_Local_V2.png"

Similarly the reporting for individual element is available here...
"TraditionalTestsV1\Traditional-V1-TestResults.txt
"TraditionalTestsV2\Traditional-V2-TestResults.txt


Known Issues:
=============
1. Edge browser on my machine is EdgeHtml 18.18362. I couldn't find proper way to make it work with this browser. 
Alternatively, I can download the binary of edge chrome and use this binary to run the tests. But due to restrictions on my office laptop,
I couldn't able do this. So disabled edge browser configuration for Traditional tests

2. Add to Compare, favorite and Cart buttons though they open up in firefox upon hovering over the product, Somehow selenium not recognizing these.
Need to investigate. It's happening only on firefox browser with smaller view port. This is the only failing test on "TraditionalTestsV1" suite under "Task2"

3. Using TestNg SoftAssert where there is no option to provide error reason as there is for hamcrest asserts. So currently the failures in TraditionalTestsV2 tests
will be displayed with true vs false but don't tell you of which visual element the failure belongs to. But we can easily trace back to the code and find out what line
it's referring to and figure out the failure. In our example, the add to favorite, Cart and comapre buttons have such assertions and missing of these from the display
tell you expecting true but was false in the TestNG report. But by looking at the Traditional-V2-TestResults.txt file and the code we can easily figure out what's wrong.