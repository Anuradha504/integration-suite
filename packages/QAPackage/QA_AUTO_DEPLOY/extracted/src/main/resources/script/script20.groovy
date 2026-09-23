import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    def reader = message.getBody(java.io.Reader)

    def json = new JsonSlurper().parse(reader)

    def folders = []

    json.each { item ->

        if(item.name != null) {
            folders.add(item.name)
        }
    }

    message.setProperty("folderList", folders.join(","))

    return message
}