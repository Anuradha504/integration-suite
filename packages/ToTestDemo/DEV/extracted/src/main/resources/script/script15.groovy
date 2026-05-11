import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def reader =
        message.getBody(java.io.Reader)

    def json =
        new JsonSlurper().parse(reader)

    message.setHeader(
        "CamelFileName",
        json.fileName
    )

    message.setProperty(
        "fileBase64",
        json.content
    )

    return message
}