// ASN-Dropper using ipinfo.app API, first kotlin project
import java.net.URL
import java.net.HttpURLConnection

fun main() {
    print("ASN to Drop ~# ")
    var asnum = readLine()
    val url = URL("https://asn.ipinfo.app/api/text/ipblackhole/$asnum")
    val urlConnection = url.openConnection() as HttpURLConnection

    try {
        val rules = urlConnection.inputStream.bufferedReader().readText()
        val drop = Runtime.getRuntime().exec("$rules")
    } finally {
        urlConnection.disconnect()
    }
}
