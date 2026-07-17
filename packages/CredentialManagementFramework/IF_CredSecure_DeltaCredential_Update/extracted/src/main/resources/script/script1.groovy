import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def body = message.getBody(String)

    if(body == null || body.trim().isEmpty()){
        message.setProperty("LastRunTime","2026-01-01T00:00:00Z")
    } else {
        message.setProperty("LastRunTime",body)
    }

    return message
}