node {
    def mvnHome
    stage('Get latest pulls') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/l7ya009/AutomationPlayground.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'MAVEN_HOME'
    }
    stage('Clean old builds') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean/)
            }
        }
    }

     stage('Run tests') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean test '
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean test /)
            }
        }
    }


    stage('Results') {
        allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'allure-results']]
    }
}
