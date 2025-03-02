#!/usr/bin env groovy


def call () {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker_hub_repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t arman04/java-maven-app:jma-2.1 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push arman04/java-maven-app:jma-2.1'
    }
}