# 코드 A-3 라이선싱 서비스를 시작하는 데 사용된 run.sh 스크립트

#!/bin/sh
  echo "********************************************************"
  echo "Waiting for the configuration server to start on port
    $CONFIGSERVER_PORT"
  echo "********************************************************"
  while ! `nc -z configserver $CONFIGSERVER_PORT`;
    [ca]do sleep 3; done
  echo ">>>>>>>>>>>> Configuration Server has started"
  echo "********************************************************"
  echo "Waiting for the database server to start on port $DATABASESERVER_PORT"
  echo "********************************************************"
  while ! `nc -z database $DATABASESERVER_PORT`; do sleep 3; done
  echo ">>>>>>>>>>>> Database Server has started"
  echo "********************************************************"
  echo "Starting License Server with Configuration Service :
    $CONFIGSERVER_URI";
  echo "********************************************************"
  java -Dspring.cloud.config.uri=$CONFIGSERVER_URI \
       -Dspring.profiles.active=$PROFILE \
       -jar /usr/local/licensingservice/licensing-service-0.0.1-SNAPSHOT.jar
