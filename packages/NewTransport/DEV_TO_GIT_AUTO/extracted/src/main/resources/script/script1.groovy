import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def body = new JsonSlurper().parse(message.getBody(java.io.Reader))
    
    message.setProperty("artifactList", body.artifacts)
    message.setProperty("triggeredBy", body.triggeredBy)

    return message
}