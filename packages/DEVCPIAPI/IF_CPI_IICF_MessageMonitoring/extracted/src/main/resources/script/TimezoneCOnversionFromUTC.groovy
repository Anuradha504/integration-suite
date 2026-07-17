import com.sap.gateway.ip.core.customdev.util.Message;
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone
import java.time.ZonedDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

def String TimeZoneConversion(String utcTime, String timeZone)
{
        def format= "yyyy-MM-dd HH:mm:ss"
		
        // Parse the UTC time string
        ZonedDateTime utcDateTime = ZonedDateTime.parse(utcTime+'Z')
		println(utcTime)

        // Convert to the specified timezone
        ZonedDateTime zonedDateTime = utcDateTime.withZoneSameInstant(ZoneId.of(timeZone))
		println(zonedDateTime)
		
        // Format the output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format)
        String formattedTime = zonedDateTime.format(formatter)
        println(formattedTime)
        return formattedTime; 
}