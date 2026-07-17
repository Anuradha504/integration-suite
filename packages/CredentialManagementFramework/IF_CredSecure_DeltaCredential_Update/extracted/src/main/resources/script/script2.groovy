import com.sap.gateway.ip.core.customdev.util.Message
import java.time.Instant

def Message processData(Message message) {

    String lastRun = message.getProperty("LastRunTime")
    String modified = message.getProperty("CredentialLastModified")

    boolean processRecord =
            Instant.parse(modified)
                   .isAfter(Instant.parse(lastRun))

    message.setProperty("ProcessRecord", processRecord)

    return message
}