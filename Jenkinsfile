pipeline {
	agent none
	options {
		ansiColor('xterm')
	}
  stages {
    stage("Build and Deploy") {
    	agent {
    		label 'java'
    	}
      steps {
        container("java-slave") {
        	scmSkip(deleteBuild: true)
          git(branch: "${env.BRANCH_NAME}", credentialsId: "github",
            url: "https://github.com/elsevier-research/dp-grant-award-kafka-schema.git")
          sh "mvn clean install"
          sh "mvn deploy"
        }
      }
    }
  }
}