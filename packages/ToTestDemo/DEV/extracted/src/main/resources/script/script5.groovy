import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def reader = message.getBody(java.io.Reader)   // ✅ streaming
    def json = new JsonSlurper().parse(reader)

    def sha = json?.sha

    message.setProperty("sha_zip", sha)

    return message
}