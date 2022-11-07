pipeline {
  agent any
  stages {
    stage('CheckOut-Code') {
      steps {
        git(credentialsId: '6e30411b-0b1c-435a-88bf-f695be76d6e5', url: 'https://github.com/tapiwanasheMbizvo/econetShop', branch: 'master')
      }
    }

  }
}