Xena Parent POM
=================
The parent Maven POM for Xena Maven Projects.

What is it?
-----------
The Xena parent POM provides default configuration for Maven builds.
 
* Recommended/Default versions for the most commonly used Maven plugins
* Profiles for generating docker builds, and enforcing a minimum versions of 
  Java and Maven
* Distribution Management and other configuration for deploying to the 
  Xena Maven repositories

How to use it?
--------------
Start out by adding the public repository to settings.xml
```xml
    <profiles>
   
        <profile>
            <id>xena</id>
            <repositories>
                <repository>
                    <id>xena-public</id>
                    <name>Xenas public repo</name>
                    <url>http://apaq-repository-public.s3-website-eu-west-1.amazonaws.com/release</url>
                </repository>
            </repositories>
        </profile>
   
    </profiles>
 
    <activeProfiles>
        <activeProfile>xena</activeProfile>
    </activeProfiles>  
 ```

The add the parent configuration to your pom.

```xml
    <parent>
      <groupId>dk.xena</groupId>
      <artifactId>xena-parent</artifactId>
      <version>1.0.4</version>
    </parent>
```

The pom includes properties which allow various build configuration to be 
customized.  For example, to override the default version of the
maven-compiler-plugin, just set a property.

For the full list of properties, refer to the POM itself.

