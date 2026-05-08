import com.sap.gateway.ip.core.customdev.util.Message
import java.util.Base64

def Message processData(Message message) {

    def metadata = message.getProperty("metadataRaw")

    if (metadata == null) {
        throw new Exception("metadataRaw is NULL")
    }

    def encoded = Base64.encoder.encodeToString(metadata.getBytes("UTF-8"))

    message.setProperty("metadataBase64", encoded)

    return message
}