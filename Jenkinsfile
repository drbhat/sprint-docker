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
			stage('Deploy') {
         		steps {
            		echo "Deploy stage"
         		}
			}		
		}
		post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               echo 'Pilepine run success'
            }
            failure {
               echo 'Pilepine run failed'
            }
            aborted {
                echo 'Pilepine run aborted'
            }
         }
}