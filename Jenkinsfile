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
            sh 'docker tag springboot-docker-kubernets tusharjadhav2386/dockertesting1:springboot-docker-kubernets'
            sh 'docker push tusharjadhav2386/dockertesting1:springboot-docker-kubernets'
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
                kubernetesDeploy (configs: 'deployment.yaml',kubeconfigId: 'kubeconfig')
              // kubernetesDeploy configs: '', kubeConfig: [path: ''], kubeconfigId: 'kubeconfig', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
              // kubeconfig(credentialsId: 'kubernetsAuth', serverUrl: '127.0.0.1:61996') {
              //  withKubeConfig([credentialsId: 'kubernetsAuth', serverUrl: 'https://127.0.0.1:50597']) {  // some block
               //sh 'kubectl apply -f deployment.yaml'
              // sh 'kubectl apply -f service.yaml'



               //}
             }
           }
         }

        stage('RunDocr image')
             {
                steps{
                   script{
                         // sh 'docker run -p 8086:8086 springboot-docker-kubernets'
                         sh 'docker run -d -p 8086:8086 --name springboot-docker-kubernets springboot-docker-kubernets'
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
