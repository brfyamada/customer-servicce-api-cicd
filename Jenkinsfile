//[JENKINS] [KUBERNETS] [DOCKERHUB] [STEP 2]
pipeline {


    environment {
        dockerImageName = "byamada/customer-service-api"
        dockerImage = ""
    }

    agent any

    options { skipDefaultCheckout() }
    tools {
            gradle "gradle-7-3-3" // named in gradle configuration
    }

    stages {



        stage ('Checkout source') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-jenkins-token',
                    url: 'https://github.com/BrunoFernandoYamada/customer-service-api.git'
            }
        }


        stage ('Build gradle') {
       /*   agent {
                docker { image 'gradle'}
            }
       */
            steps {
                sh "gradle clean build -x test"
            }
        }


        stage ('Docker Build') {
            steps {
                script {
                    dockerImage = docker.build dockerImageName + ":$BUILD_NUMBER"
                }
            }
        }

        stage ('Pushing Image') {
            environment {
                registryCredentials = 'dockerhubcredential'
            }
             steps {
                 script {
                     docker.withRegistry('https://registry.hub.docker.com', registryCredentials) {
                        //pushing as latest
                        dockerImage.push('latest')
                     }
                 }
             }
        }

        stage ('Deploying to Kubernetes') {
             steps {
                 script {
                    kubernetesDeploy(configs: "deploy/deployment.yaml", kubeconfigId: "kubernetes")
                 }
             }
        }
        stage('Remove Unused docker image') {
            steps{
                sh "docker rmi $dockerImageName:$BUILD_NUMBER"
            }
        }
    }
}