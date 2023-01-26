pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }
     agent any
    tools {
        maven 'maven'
    }

    stages {
        stage('Checking JAVA, Maven,git') {
            steps {
                echo 'Code Compilation is In Progress!'
                sh 'java --version'
                sh 'git --version'
                sh 'whoami'
                echo "this pipeline is running via Jenkins User"
            }
        }
        stage('Code Compilation') {
            steps {
                echo 'Code Compilation is In Progress!'
                sh 'mvn clean package'
            }
        }

        stage('Code QA Execution') {
            steps {
                echo 'Junit Test case check in Progress!'
                sh 'mvn test package'
            }
        }
        stage('Code Package') {
            steps {
                echo 'Creating War Artifact'
                sh 'java -version'
                sh 'mvn clean package'
            }
        }

        stage('Building  Docker Image') {
            steps {
                echo 'Starting Building Docker Image'
                sh 'docker build -t akshay2patil/yatra2we .'
                sh 'docker build -t yatra2we .'
                echo 'Completed  Building Docker Image'
            }
        }

        stage('Tagging Docker Image') {
            steps {
                echo 'Creating War Artifact'
                sh 'java -version'
                sh 'mvn clean package'
            }
        }

        stage('Docker Image Scanning') {
            steps {
                echo 'Creating War Artifact'
                sh 'java -version'
                sh 'mvn clean package'
            }
        }

          stage(' Docker push to Docker Hub') {
             steps {
                 script {
                      withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]){
                      sh 'docker login docker.io -u akshay2patil -p ${dockerhubCred}'
                      echo "Push Docker Image to DockerHub : In Progress"
                      sh 'docker push akshay2patil/yatra2we:latest'
                      echo "Push Docker Image to DockerHub : In Progress"
                      sh 'whoami' }
             }
        }