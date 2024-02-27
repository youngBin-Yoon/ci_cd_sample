FROM openjdk:17
LABEL authors="code_maker"

WORKDIR /var/jenkins_home/workspace

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/api-0.0.1-SNAPSHOT.jar ${JAR_PATH}/api-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","./build/libs/api-0.0.1-SNAPSHOT.jar"]


#ENTRYPOINT ["top", "-b"]