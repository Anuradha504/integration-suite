import com.sap.gateway.ip.core.customdev.util.Message
import java.util.zip.ZipInputStream
import java.io.ByteArrayInputStream

def Message processData(Message message) {

    byte[] zipBytes = message.getBody(byte[])

    ZipInputStream zipInputStream =
        new ZipInputStream(
            new ByteArrayInputStream(zipBytes)
        )

    message.setProperty(
        "ZIP_STREAM",
        zipInputStream
    )

    return message
}