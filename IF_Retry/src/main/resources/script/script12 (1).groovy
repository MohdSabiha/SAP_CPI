import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def headersToKeep = [
        'SAP_MessageProcessingLogID',
        'SAP_MplCorrelationId',
        'PackageName',
        'Iflow_Name'
    ] as Set

    def headers = message.getHeaders()

    headers.keySet().toList().each { header ->
        if (!headersToKeep.contains(header)) {
            message.setHeader(header, null)
        }
    }

    return message
}