import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    byte[] zipBinary = message.getBody(byte[].class)

    message.setProperty("zipBinary", zipBinary)

    return message
}