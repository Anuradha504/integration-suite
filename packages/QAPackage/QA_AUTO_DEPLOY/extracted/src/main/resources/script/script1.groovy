import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def reader = message.getBody(java.io.Reader)
    def json = new JsonSlurper().parse(reader)

    def artifactId = json.artifactId
    def packageId = json.packageId

    message.setProperty("artifactId", artifactId)
    message.setProperty("packageId", packageId)

    return message
}