import com.sap.gateway.ip.core.customdev.util.Message
import java.util.zip.ZipInputStream
import java.util.Base64
import java.io.ByteArrayOutputStream
import java.io.InputStream

def Message processData(Message message) {

    def files = []
    def zis = new ZipInputStream(message.getBody(InputStream))
    def entry

    while ((entry = zis.getNextEntry()) != null) {

        if (!entry.isDirectory()) {

            def baos = new ByteArrayOutputStream()
            byte[] buffer = new byte[4096]
            int len

            while ((len = zis.read(buffer)) > 0) {
                baos.write(buffer, 0, len)
            }

            def encoded = Base64.encoder.encodeToString(baos.toByteArray())

            files.add([
                filePath: "extracted/" + entry.getName(),
                content : encoded
            ])
        }

        zis.closeEntry()
    }
    zis.close()

    // Store entire list
    message.setProperty("fileList", files)

    // Start index
    message.setProperty("index", 0)

    return message
}