import com.sap.gateway.ip.core.customdev.util.Message
import java.util.Base64

def Message processData(Message message) {

    byte[] bytes = message.getBody(byte[])
    String encoded = Base64.encoder.encodeToString(bytes)

    message.setBody(encoded)

    return message
}