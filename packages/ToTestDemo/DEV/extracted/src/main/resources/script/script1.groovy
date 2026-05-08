import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def body = new JsonSlurper().parse(message.getBody(java.io.Reader))

    def artifact = body.artifacts[0]

    message.setProperty("packageId", artifact.packageId)
    message.setProperty("artifactId", artifact.artifactId)
    message.setProperty("triggeredBy", body.triggeredBy)

    return message
}