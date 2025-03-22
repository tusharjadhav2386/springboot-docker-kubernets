pipeline {
    agent any

    stages{

       stage('Checkout'){
         steps{
            git branch: 'main',url:'https://github.com/tusharjadhav2386/springboot-docker-kubernets.git'
              }
         }

       stage('Bulid'){
        steps{
          sh 'mvn clean install'
             }
          }

        stage('Test')
        {
        steps{
          sh 'mvn test'
        }
        }

        stage('Build docker image')
        {
        steps{
          script{
          sh 'docker build -t springboot-docker-kubernets .'
          }
        }
        }



        stage('Push Docker Image')
        {
          steps{

          script{

          //sh 'docker login -u tusharjadhav2386 -p tushar@2386'

          withCredentials([string(credentialsId: 'docker_hub', variable: 'docker_hub')]) {
            sh 'docker tag springboot-docker-kubernets tusharjadhav2386/testingdocker:springboot-docker-kubernets'
            sh 'docker push tusharjadhav2386/testingdocker:springboot-docker-kubernets'
          }

              }
            }

         }

         stage('Deploy to k8s')
         {
           steps
           {
            script
            {
                kubernetesDeploy (configs: 'deployment.yaml',kubeconfigId: 'k8sconfig')
             }
           }
         }

         stage('RunDocr image')
        {
         steps{
         script{
         sh 'docker run -p 8080:8080 springboot-docker-kubernets'
         }
         }
        }


      }
         post {
                 success {
                     echo 'Build successful'
                 }
                 failure {
                     echo 'Build failed'
                 }
             }
    }
