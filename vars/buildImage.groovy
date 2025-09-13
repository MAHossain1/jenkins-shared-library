#!/usr/bin/env groovy

def call(String imageName) {
    echo "building the docker image and push to dockerhub"
    withCredentials(
            [usernamePassword(credentialsId:'docker-hub-credentials', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]
    ) {
        sh "docker build -t ${imageName} ."
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker push ${imageName}"
    }
}