pipeline {
  agent any
  stages {
    stage('CheckOut-Code') {
      steps {
        git(credentialsId: '1fa6c2ef-8330-4195-9417-342e1ebfab5b', url: 'https://github.com/tapiwanasheMbizvo/econetShop', branch: 'master')
      }
    }

  }
}