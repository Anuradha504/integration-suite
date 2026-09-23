import com.sap.gateway.ip.core.customdev.util.Message
import groovy.util.XmlSlurper

def Message processData(Message message) {

    def reader = message.getBody(java.io.Reader)

    def xml = new XmlSlurper().parse(reader)

    String packageId = xml.packageId.text().trim()
    String artifactId = xml.artifactId.text().trim()

    message.setProperty("packageId", packageId)
    message.setProperty("artifactId", artifactId)

    return message
}