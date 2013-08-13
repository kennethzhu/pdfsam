import java.net.InetAddress;
import java.net.UnknownHostException;


public class HostInfo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
//		System.out.println(System.getProperty("alamoe.hostID"));
		InetAddress  addr=java.net.InetAddress.getLocalHost();
		System.out.println(addr.getHostName());
//		addr.

	}

}
