import com.sap.gateway.ip.core.customdev.util.Message
import java.util.Base64

def Message processData(Message message) {

    byte[] fileBytes = message.getBody(byte[].class)

    if (fileBytes == null) {
        throw new Exception("File content is NULL")
    }

    String base64 = Base64.encoder.encodeToString(fileBytes)
    base64 = base64.replaceAll("\\r|\\n", "")

    message.setProperty("fileBase64", base64)

    return message
}