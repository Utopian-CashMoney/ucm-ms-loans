pipeline { 
    agent any 
//      environment {
// //         PATH = "/usr/local/bin:$PATH"
//            def mvnHome = tool name: 'Maven 3.6.3', type: 'maven'

//      }
        tools { 
        maven 'Maven 3.8.1' 
        jdk 'jdk16' 
    }
    stages { 
          stage ('Checkout Git Repo') {
            steps {
                    git branch: 'CP-H2', url: 'https://github.com/Utopian-CashMoney/ucm-ms-loans.git'            
            }
        }

        stage ('Build') {
            
            steps {
                 // sh label: '', script: 'mvn clean package'
                 // sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
                  sh 'mvn clean package' 
                
//                     withMaven(maven: 'Maven 3.6.3') {
//                         sh "maven clean package"
//                     }
            }
        }
    }
}

