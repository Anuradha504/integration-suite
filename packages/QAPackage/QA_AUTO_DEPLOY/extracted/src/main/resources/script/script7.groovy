import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def reader = message.getBody(java.io.Reader)

    def json = new JsonSlurper().parse(reader)

    def zipContent = json.content

    message.setProperty("zipBase64", zipContent)

    message.setBody(zipContent)

    return message
}