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
                sh 'mvn --version'
                sh 'java --version'
                sh 'git --version'
                sh 'whoami'
                echo "this pipeline is running via Jenkins User"
            }
        }
        stage('Code Compilation') {
            steps {
                echo 'Code Compilation is In Progress!'
                sh 'mvn --version'
                sh 'mvn clean compile'
            }
        }

        stage('Code QA Execution') {
            steps {
                echo 'Junit Test case check in Progress!'
                sh 'mvn --version'
                sh 'mvn clean test'
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
                sh 'docker build -t akshay2we/yatra2we .'
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
                 withCredentials([string(credentialsId: 'akshay2patil', variable: 'akshay')]){
                 sh 'docker login docker.io -u akshay2patil -p ${akshay}'
                 echo "Push Docker Image to DockerHub : In Progress"
                 sh 'docker push akshay2patil/yatra2we:latest'
                 echo "Push Docker Image to DockerHub : In Progress"
                 sh 'whoami'
                 }
              }
            }
        }

        stage(' Docker Image Push to Amazon ECR') {
           steps {
              script {
                 withDockerRegistry([credentialsId:'ecr:us-east-1:docker.ecr', url:"https://599827061316.dkr.ecr.us-east-1.amazonaws.com"]){
                 sh """
                 echo "List the docker images present in local"
                 docker images
                 echo "Tagging the Docker Image: In Progress"
                 docker tag yatra2we:latest 599827061316.dkr.ecr.us-east-1.amazonaws.com/yatra2we:latest
                 echo "Tagging the Docker Image: Completed"
                 echo "Push Docker Image to ECR : In Progress"
                 docker push 599827061316.dkr.ecr.us-east-1.amazonaws.com/yatra2we:latest
                 echo "Push Docker Image to ECR : Completed"
                 """
                 }
              }
           }
        }

        stage('Upload the docker Image to Nexus') {
           steps {
              script {
                 withCredentials([usernamePassword(credentialsId: 'admin', passwordVariable: 'password', usernameVariable: 'nexuscred')]) {
                 sh 'docker login http://18.234.108.41:8080/repository/yatra2we -u admin -p ${password}'
                 echo "Push Docker Image to Nexus : In Progress"
                 sh 'docker tag yatra2we http://18.234.108.41:8080/yatra2we:latest'
                 sh 'docker push 18.234.108.41:8080/yatra2we'
                 echo "Push Docker Image to Nexus : Completed"
                 }
              }
            }
        }

        stage('Deploy App to K8s Cluster') {
            steps {
                sh 'whoami'
                sh 'kubectl apply -f Kubernetes/prod'
            }

        }/**
        stage('Deploy App to K8s Cluster') {
          withKubeConfig([credentialsId: 'kuberneteskubeconfig', serverUrl: 'https://api.myprodcluster.in']) {
                sh 'kubectl apply -f kubernetes/prod'
            }
        }**/
    }
}