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
			}
			stage('Build Docker Image') {
         		steps {
            		bat 'docker build -t drbhat/sprint-docker:latest .'
         		}
			}
			stage('Push Docker Image'){
     			withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
    				bat "docker login -u drbhat -p ${dockerHubPwd}"
				}
        		    			
     			bat 'docker push drbhat/sprint-docker:latest'
   			}
			stage('Run Container on Dev Server'){
     			def dockerRun = 'docker run -p 8080:8080 -d --name my-app kammana/my-app:2.0.0'
     				     				
   			}		
		}
		post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               echo 'Pipeline run success at ${new Date()}'
            }
            failure {
               echo 'Pipeline run failed'
            }
            aborted {
                echo 'Pipeline run aborted'
            }
         }
}