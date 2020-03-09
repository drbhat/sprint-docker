//properties([pipelineTriggers([pollSCM('')])])
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
			/*stage('SonarQube Analysis') {
				steps {
        			withSonarQubeEnv('sonar-6') { 
          				bat "mvn sonar:sonar"
        			}
				}        
        	} 
   	 		stage('Email Notification') {
				steps {
        			mail bcc: '', body: '''Hi Welcome to jenkins email alerts 
        			Thanks
      				Hari''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'drbhat@gmail.com'
				}        
        	} */
			stage('Test') {
         		steps {
            		junit '**/target/surefire-reports/TEST-*.xml'
               		archiveArtifacts 'target/*.jar'
         		}        		
			}
			stage('Build Docker Image') {
         		steps {
            		bat "docker build -t drbhat/sprint-docker:latest ."
         		}
			}
			stage('Push Docker Image') {
				steps {
     				withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
    					bat "docker login -u drbhat -p ${dockerHubPwd}"
					}
        		    			
     				bat 'docker push drbhat/sprint-docker:latest'
     			}
   			}
			stage('Run Container on Dev Server') {
				steps {
					bat "docker rm -f sprint-docker"
     				bat "docker run -p 8080:8080 -d --name sprint-docker drbhat/sprint-docker:latest"
     			}	     				
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