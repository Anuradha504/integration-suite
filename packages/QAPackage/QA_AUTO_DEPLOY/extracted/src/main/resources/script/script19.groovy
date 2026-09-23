import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    // Wait for 3 seconds
    Thread.sleep(3000)

    return message
}