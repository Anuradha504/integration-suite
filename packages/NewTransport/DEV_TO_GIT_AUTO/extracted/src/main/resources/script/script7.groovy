import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    try {
        def reader = message.getBody(java.io.Reader)
        def json = new JsonSlurper().parse(reader)

        message.setProperty("sha_zip", json.sha)
        message.setProperty("zipExists", true)

    } catch(Exception e) {
        message.setProperty("zipExists", false)
    }

    return message
}