import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def body = message.getBody(java.io.Reader)   
    def json = new JsonSlurper().parse(body)

    if (json?.sha) {
        message.setProperty("sha_metadata", json.sha)
        message.setProperty("metadataExists", "true")
    } else {
        message.setProperty("metadataExists", "false")
    }

    return message
}