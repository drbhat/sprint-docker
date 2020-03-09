pipeline {
	agent any
		stages {
			stage('SCM-Get Code From Github') {
         		steps {
            		// Get some code from a GitHub repository
            		git 'https://github.com/drbhat/sprint-docker'
         		}
			}
			stage('Build') {
         		steps {
            		// To run Maven on a Windows agent, use
            		bat "mvn -Dmaven.test.failure.ignore=true clean package"
         		}
			}
			stage('Test') {
         		steps {
            		junit '**/target/surefire-reports/TEST-*.xml'
               		archiveArtifacts 'target/*.jar'
         		}
         		steps {
              		withSonarQubeEnv('My SonarQube Server') {
                	bat 'mvn clean package sonar:sonar'
              		}
				}
			}
			stage('Deploy') {
         		steps {
            		echo "Deploy stage"
         		}
			}
		
		}
}