
node {
    stage('Checkout') {
        checkout scm

    }

    def v;

    stage('Build') {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github_credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {

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


        stage("Set Version and Tag it") {
            withMaven(
                            maven: 'Maven 3',
                            mavenSettingsConfig: 'maven_settings',
                            jdk: 'JDK 8') {
                def originalV = version();
                def major = originalV[1];
                def minor = originalV[2];
                def patch  = originalV[3];
                v = "${major}.${minor}.${patch}"
                if (v) {
                    echo "Building version ${v}"
                }
                sh "mvn -B versions:set -DgenerateBackupPoms=false -DnewVersion=${v}"
                sh 'git add .'
                sh "git commit -m 'Raise version'"
                sh "git tag v${v}"
            }
        }

        stage('Release it') {
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github_credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {

                withMaven(
                    maven: 'Maven 3',
                    mavenSettingsConfig: 'maven_settings',
                    jdk: 'JDK 8') {

                    sh "mvn -B -DskipTests clean deploy"

                    //sh "git push origin " + env.BRANCH_NAME
                    sh "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/EG-BRS/parent-pom v${v}"

                }
            }
        }


    }


}

def version() {
    def pom = readMavenPom file: 'pom.xml'
    def tmp = pom.version
    tmp = tmp.replaceAll("-SNAPSHOT", "")
    return v.split(".");
}