import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
 
import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO
 
def bySecond = timestamp("MMddyyyy'T'HHmmss")
def LOGGER_HOME = "C:/eclipse/devops/haat/workspace/JaxbTutor/log"
 
appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
   // pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
    pattern = "%d{MM-dd-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
  }
}

appender("AUDIT", FileAppender) {
  file = "${LOGGER_HOME}/audit/auditLog-${bySecond}.log"
  encoder(PatternLayoutEncoder) {
    pattern = "%d{MM-dd-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
  }
}

appender("FILE", FileAppender) {
  file = "${LOGGER_HOME}/debug/debug.log"
  append = true
  encoder(PatternLayoutEncoder) {
    pattern = "%d{MM-dd-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
    //pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
  }
}

logger("com.haat.xsd", ALL)
root(DEBUG, ["STDOUT" , "AUDIT", "FILE"])