import com.sap.gateway.ip.core.customdev.util.Message
import java.util.Base64

def Message processData(Message message) {

    def base64 = message.getProperty("zipBase64")

    if (base64 == null) {
        throw new Exception("zipBase64 property is NULL before decode")
    }

    byte[] zipBinary = Base64.decoder.decode(base64)

    message.setBody(zipBinary)

    return message
}