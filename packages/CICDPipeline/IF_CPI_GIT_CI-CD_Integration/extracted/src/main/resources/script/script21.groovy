import com.sap.gateway.ip.core.customdev.util.Message
import groovy.util.XmlSlurper

def Message processData(Message message) {

    def body = message.getBody(String)

    def artifactId = message.getProperty("artifactId")

    def packageId = message.getProperty("packageId")

    def xml = new XmlSlurper(false, false).parseText(body)

    boolean artifactExists = false


    xml.entry.each { entry ->

        def entryId = entry.id.text()

        if(entryId.contains("Id='${artifactId}'")) {
            artifactExists = true
        }

    }


    if(!artifactExists){

        throw new Exception(
        "Artifact ID '${artifactId}' does not exist in Package '${packageId}'."
        )

    }


    return message
}