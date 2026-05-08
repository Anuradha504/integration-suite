import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonOutput

def Message processData(Message message) {

    def files = message.getBody(List)

    def lines = files.collect {
        JsonOutput.toJson(it)
    }.join("\n")

    message.setBody(lines)

    return message
}