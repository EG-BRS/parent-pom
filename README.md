EG Parent POM
=================
The parent Maven POM for EG Maven Projects.

What is it?
-----------
The EG parent POM provides default configuration for Maven builds.
 
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
            <id>eg-public</id>
            <repositories>
                <repository>
                    <id>eg-public</id>
                    <name>EG's public repo</name>
                    <url>https://sonatype.egone.dk/repository/maven-public/</url>
                </repository>
            </repositories>
        </profile>
   
    </profiles>
 
    <activeProfiles>
        <activeProfile>eg-public</activeProfile>
    </activeProfiles>  
 ```

The add the parent configuration to your pom.

```xml
    <parent>
      <groupId>dk.eg</groupId>
      <artifactId>parent</artifactId>
      <version>1.3.1</version>
    </parent>
```

The pom includes properties which allow various build configuration to be 
customized.  For example, to override the default version of the
maven-compiler-plugin, just set a property.

For the full list of properties, refer to the POM itself.

