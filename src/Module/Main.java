package Module;

import java.util.Scanner;
import redis.clients.jedis.*;

public class Main {

	private static void create() {
		System.out.print("Create ");
	}

	private static void update() {
		System.out.print("Update");
	}

	private static void delete() {
		System.out.print("delete ");
	}

	private static void read() {
		System.out.print("read ");
	}

	public static void main(String[] args) throws Exception {
		try {
			Jedis jedis = new Jedis("localhost");
			System.out.println("Conexion exitosa");
			System.out.println("Server ping: " + jedis.ping());

			Scanner sc = new Scanner(System.in);
			int numberOption;

			System.out.println("1.- CREATE");
			System.out.println("2.- DELETE");
			System.out.println("3.- UPDATE");
			System.out.println("4.- READ");

			System.out.print("Selecciona una opcion a realizar: ");
			numberOption = sc.nextInt();
			System.out.println(numberOption);

			switch (numberOption) {
			case 1:
				create();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				read();
				break;
			default:
				break;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
