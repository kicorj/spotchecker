FROM jboss/wildfly
ADD ./target/spotchecker.war /opt/jboss/wildfly/standalone/deployments/