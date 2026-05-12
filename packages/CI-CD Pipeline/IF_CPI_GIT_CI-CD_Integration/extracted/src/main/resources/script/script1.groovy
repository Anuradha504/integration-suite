import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def body = new JsonSlurper().parse(
        message.getBody(java.io.Reader)
    )

    message.setProperty(
        "artifacts",
        body.artifacts
    )

    // initialize counter
    message.setProperty(
        "loopIndex",
        0
    )

    return message
}