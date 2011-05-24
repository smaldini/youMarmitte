# Kickstart session

This grails application needs :
* JDK 1.5
* Grails 1.3.7

YouMarmitte features :
* An online recipes publisher
* A secured access
* A social aspect -> Like - Doesn't like

# Grails commands to reproduce the setup from the project

* grails create-app youMarmitte
* _cd youMarmitte_
* grails interactive (launch multiple commands in the same session )
* install-plugin spring-security-core (install security module)
* install-plugin spring-security-ui (install some UI for security : auth, registration, role management...)
* install-plugin cached-resources (install the grails 1.4 standard static resources manager)
* install-plugin greenmail (in order to make security UI working, you will need a mail server, if you need quick mail testing, this plugin will fake one for you without additional configuration)
* install-plugin jquery (for AJAX)
* create-domain-class Recipe (to hold Recipe data)
* create-domain-class UserRecipeLike (to hold Like relationship between User and Data)
* create-controller Recipe (add behaviors for Recipe)
* s2-quickstart yourmarmitte User Role (generate User, Role and UserRole domain classes in the youmarmitte package)
* s2ui-override auth (override the not very fancy UI page for login)
