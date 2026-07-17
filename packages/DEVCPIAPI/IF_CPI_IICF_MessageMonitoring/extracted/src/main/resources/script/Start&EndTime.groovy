import com.sap.gateway.ip.core.customdev.util.Message;
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime


def Message processData(Message message)
{
		hmap= message.getHeaders()
        pmap = message.getProperties()
        def lastRun = hmap.get("lastRun")
        def startTime = hmap.get("startTime")
        def endTime= hmap.get("endTime")
        Integer Freq = Integer.parseInt(hmap.get("interval"))

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

//Check if mannual StartTime is passed
	if (startTime != null && !startTime.isEmpty()){
			startTime =startTime
	}
	else
		startTime = lastRun

    // Parse the StartTime
    LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter)

    // If EndTime is null, calculate it using StartTime + Interval
    if (endTime == null || endTime.isEmpty()) {
        LocalDateTime calculatedEndTime = startDateTime.plusMinutes(Freq)
        endTime = calculatedEndTime.format(formatter)
    }

    // If both StartTime and EndTime are given, use them as is
    LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter)

    // Format both StartTime and EndTime
    String formattedStartTime = startDateTime.format(formatter)
    String formattedEndTime = endDateTime.format(formatter)
    
	 message.setHeader("endTime", formattedEndTime)
	 message.setHeader("startTime", formattedStartTime)
	 message.setHeader("SAP_ApplicationId",formattedStartTime+"_"+formattedEndTime)

    return message
}