pipeline {
  agent any
  stages {
    stage('Pull') {
      steps {
        git 'https://github.com/Adonay1398/jenkins.git'
      }
    }
    stage('Build') {
      steps {
        sh 'javac' // Suponiendo que usas Maven para compilar proyectos Java
      }
    }
    stage('Test') {
      steps {
        script {
          try {
            sh 'java ' // Suponiendo que usas Maven para ejecutar pruebas JUnit
          } catch (Exception e) {
            currentBuild.result = 'FAILURE'
            throw e
          }
        }
      }
    }
    stage('Deploy') {
      when {
        expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
      }
      steps {
        sh 'echo "Desplegando..."'
      }
    }
  }
  post {
    failure {
      echo 'Las pruebas han fallado. Rechazando el código.'
    }
    success {
      echo 'Las pruebas pasaron. Continuando con el despliegue.'
    }
  }
}
