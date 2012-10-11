# Jenkins Control Plugin for IntelliJ IDEA

## ChangeLog
See CHANGELOG.txt

## Description
This plugin allows to view the content of your Jenkins Continous Integration Server.

## Plugin Compatibility
This plugin was built with JDK 1.6 and ideaIU-10.5.0 version. Jenkins CIs of jenkins-ci and apache.org are used for manual and stress testing.

## Installation steps
Download this plugin from your IDE or from the plugin website: http://plugins.intellij.net/?idea&id=6110.

## Configuration steps
* Click on the **Jenkins Settings** button located on the upper toolbar (or you can also open IntelliJ Settings Screen and select the Jenkins Control Plugin option).
* Enter your Jenkins Server URL (e.g: http://ci.jenkins-ci.org).
* If Security is enabled on the server, you have to provide credentials. Click on the **Enable Authentication** checkbox. Enter your username and the password file path.
* If Cross Site Request Forgery Prevention is enabled on the server, then you have to provide your crumb data file path. To get the value, you will have to open the following URL in your browser *_jenkins_url_/crumbIssuer/api/xml?tree=crumb*. Just copy and paste the crumb value in a file. please note for the authentication case, you have to run the crumb URL after login.  
* To make sure that all parameters are correct, you can click on the **Test Connection** button. A feedback message will appear.
* If you want the plugin to refresh periodically the Jenkins workspace or Rss Feed reader, you can set a period value
* You can specify a build start delay (in sec.).
* You can enable Auto refresh and input a period value (in minutes) on both Job Browser and Rss Feed Reader.
* When your configuration is set up, click on the **Apply** Button to save it.

## Usage
By default, Jenkins Plugin Panel is available on the right of the IDE. Click on the Jenkins Button to display it.
The panel is divided into 2 parts :
### Up part - Job view
* To view the jobs You have to refresh the Jenkins Workspace by right-clicking on the Server icon node
* You can select some view by selecting of them in the combo box.
* When you right click on a job some options are available such as Launch a Build, View The Job's Page and View the Last Build Results.
* You can set some jobs as favorite. A new View will appear in the combobox that will include your selected jobs.

### Down part - Rss View
To get the last rss feeds, you have to click on the Rss icon button, a list will appear and you will be able to go to the broken build web page.

### Widget
* A small widget is available on the status bar. It indicates the overall status of the selected view. When there is no broken build then the icon color is blue (else, a red icon is displayed with the remaining broken builds. If the job auto-refresh is enabled then the widget updates itself.
* When you click on the icon, a popup is displayed with builds status summary (# broken, # succeeded, # unstable) and weather that indicates the health of the project view.

## Limitations
* This software is written under Apache License 2.0.
* This software follows some agile practice: Provide basic functionality and get feedback from the users. So, this version
does not cover all needs and it is opened for any suggestion that you can use the issue feature of the github project

## Thanks
I would like to thank
* Kohsuke Kawaguchi for providing us such a great CI server
* Jetbrains Team for providing us such an incredible IDE (certainly the best that Java developers could have).
* Marcin Zajączkowski for his smart suggestions
* Mark James author of the famfamfam web site who provides beautiful icons.
* Guys from Lex Group : Boris Gonnot, Regis Medina, Sébastien Crego, Olivier Catteau, Jean Baptiste Potonnier and others Agile ninjas.
* My wife and my daughter who support me to have fun in software development and also remind me my husband/father duty ;).