import com.sap.gateway.ip.core.customdev.util.Message
import groovy.util.XmlSlurper

def Message processData(Message message) {

    def xml = new XmlSlurper().parse(
        message.getBody(java.io.Reader)
    )

    message.setProperty(
        "packageId",
        xml.packageId.text()
    )

    message.setProperty(
        "artifactId",
        xml.artifactId.text()
    )

    message.setProperty(
        "iflowName",
        xml.artifactId.text()
    )

    return message
}