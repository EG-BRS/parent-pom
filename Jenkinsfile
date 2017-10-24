def projectName = "parent-pom";
def majorVersion = 3;
def minorVersion = 0;
def buildVersion = env.BUILD_NUMBER;
def version = "$majorVersion.$minorVersion.$buildVersion";

node {
    stage('Checkout') {
        checkout scm

    }

    stage('Build') {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github_credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {
            sh('git checkout master')
            sh('git pull https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/EG-BRS/parent-pom.git')

            withMaven(
                maven: 'Maven 3',
                mavenSettingsConfig: 'maven_settings',
                jdk: 'JDK 8') {

                // Force version
                // sh "mvn versions:set -DnewVersion=${version}"

                // Run the maven build
                sh "mvn clean install"
            }
        }
    }

    if(env.BRANCH_NAME == "master") {


        stage('Tag it') {
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github_credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {
                withMaven(
                    maven: 'Maven 3',
                    mavenSettingsConfig: 'maven_settings',
                    jdk: 'JDK 8') {


                    sh "mvn release:prepare -Dusername=${GIT_USERNAME} -Dpassword=${GIT_PASSWORD}"
                    sh "mvn -B release:clean release:prepare release:perform -Dusername=${GIT_USERNAME} -Dpassword=${GIT_PASSWORD}"

                }
            }
        }


    }


}