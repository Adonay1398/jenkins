pipeline {
    environment {
    PATH = "C:/path/to/dir/containing/python.exe;$PATH"
}

    agent any
    stages {
        stage('Pull') {
            steps {
                git 'https://github.com/Adonay1398/jenkins.git'
            }
        }
        stage('Build') {
            steps {
                sh 'echo "Compilando..."'
            }
        }
        stage('Test') {
            steps {
                script {
                    try {
                        sh 'python -m unittest discover -s . -p "test_*.py"'
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
