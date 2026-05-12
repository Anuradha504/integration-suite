import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {
    byte[] zipBytes = message.getBody(byte[].class)
    message.setProperty("zipBinary", zipBytes)
    return message
}