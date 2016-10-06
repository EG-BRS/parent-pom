CodeZoo Parent POM
=================
The parent Maven POM for CodeZoo Maven Projects.

What is it?
-----------
The CodeZoo parent POM provides default configuration for Maven builds.
 
* Recommended/Default versions for the most commonly used Maven plugins
* Profiles for generating docker builds, and enforcing a minimum versions of 
  Java and Maven
* Distribution Management and other configuration for deploying to the 
  CodeZoo Maven repositories

How to use it?
--------------
Start out by adding the public repository to settings.xml
```xml
    <profiles>
   
        <profile>
            <id>xena</id>
            <repositories>
                <repository>
                    <id>codezoo-public</id>
                    <name>CodeZoos public repo</name>
                    <url>http://apaq-repository-public.s3-website-eu-west-1.amazonaws.com/release</url>
                </repository>
            </repositories>
        </profile>
   
    </profiles>
 
    <activeProfiles>
        <activeProfile>codezoo</activeProfile>
    </activeProfiles>  
 ```

The add the parent configuration to your pom.

```xml
    <parent>
      <groupId>dk.codezoo</groupId>
      <artifactId>parent</artifactId>
      <version>1.1.0</version>
    </parent>
```

The pom includes properties which allow various build configuration to be 
customized.  For example, to override the default version of the
maven-compiler-plugin, just set a property.

For the full list of properties, refer to the POM itself.

