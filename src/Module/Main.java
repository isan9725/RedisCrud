package Module;
import redis.clients.jedis.*;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			Jedis jedis = new Jedis("localhost");
			System.out.println("Conexion exitosa");
			System.out.println("Server ping: " + jedis.ping());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
