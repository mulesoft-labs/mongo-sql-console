MAVEN_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=9100,server=y,suspend=n" mvn -Djetty.port=8080 jetty:run
