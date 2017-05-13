# Immerse Demo Project for the OSGi Web Console

This is a project template for AEM-based applications. It is intended as a best-practice set of examples as well as a potential starting point to develop your own functionality.

## Main use cases
 * Servlet Example in `SimpleServlet.java`
 * Custom Service/Consumer `MyService.java` and `MyServiceImpl.java`
 * Vanity URL in `/content/immerse/en/jcr:content`
 * AdaptTo example in `SimpleServlet.java`
 * Service User Mapping to a subservice `/apps/immerse/config.author/<PID>`
 * Full Health Check example `ImmerseHealthCheck.java`
   * Composite Health report for "test" tag `/apps/immerse/config/<PID>`
   * Add the Composite Health Report to the Health Reposts console `/apps/granite/operations/config/hc/<hsnode>`

## Modules

The main parts of the template are:

* core: Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.
* ui.apps: contains the /apps (and /etc) parts of the project, ie JS&CSS clientlibs, components, templates, runmode specific configs as well as Hobbes-tests
* ui.content: contains sample content using the components from the ui.apps

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM with  

    mvn clean install -PautoInstallPackage
    
Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

## Maven settings

The project comes with the auto-public repository configured. To setup the repository in your Maven settings, refer to:

    http://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html
