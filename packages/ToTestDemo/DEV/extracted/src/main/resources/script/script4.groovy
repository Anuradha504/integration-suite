import com.sap.gateway.ip.core.customdev.util.Message
import java.util.Base64

def Message processData(Message message) {

    byte[] zipBytes = message.getBody(byte[].class)

    if (zipBytes == null) {
        throw new Exception("ZIP body is NULL")
    }

    String base64 = Base64.encoder.encodeToString(zipBytes)

    // remove line breaks (important for GitHub)
    base64 = base64.replaceAll("\\r|\\n", "")

    message.setProperty("artifactBase64", base64)

    return message
}