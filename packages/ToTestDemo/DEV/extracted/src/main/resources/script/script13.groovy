import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def sha = null

    try {

        // Stream body safely
        def reader = message.getBody(java.io.Reader)

        def json = new JsonSlurper().parse(reader)

        sha = json.sha

    } catch(Exception e) {

        sha = null
    }

    // Handle empty SHA
    if(sha == null || sha.toString().trim().isEmpty()) {
        sha = null
    }

    message.setProperty("sha", sha)

    return message
}