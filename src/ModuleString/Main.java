package ModuleString;

import java.util.Scanner;
import redis.clients.jedis.*;

public class Main {

	private static void create(Jedis jedis) {
		Scanner createS = new Scanner(System.in);

		System.out.print("Nombre: ");
		String name = createS.nextLine();
		System.out.println();

		System.out.print("Apellido: ");
		String lastName = createS.nextLine();
		System.out.println();

		System.out.print("Email: ");
		String email = createS.nextLine();
		System.out.println();

		Scanner createSInt = new Scanner(System.in);
		System.out.print("ID: ");
		int id = createSInt.nextInt();

		User newUser = new User(name, lastName, email, id);
		String stringID = String.valueOf(id);
		jedis.set(stringID, newUser.toString());
	}

	private static void update(Jedis jedis) {
		
		Scanner updateS = new Scanner(System.in);

		System.out.println("ID a editar");
		String id = updateS.nextLine();
		
		if(jedis.exists(id)){
			
			System.out.println("Nuevo nombre: ");
			String name = updateS.nextLine();
			System.out.println();
			
			System.out.println("Nuevo apellido: ");
			String lastName = updateS.nextLine();
			System.out.println();
			
			System.out.println("Nuevo email: ");
			String email = updateS.nextLine();
			System.out.println();
			
			User newUser = new User(name, lastName, email, Integer.parseInt(id));
			jedis.set(id, newUser.toString());
			
		}else {
			System.out.println("No existe esa llave");
		}
	}

	private static void delete(Jedis jedis) {
		Scanner deleteS = new Scanner(System.in);
		System.out.println("ID a eliminar: ");
		int id = deleteS.nextInt();
		String stringID = String.valueOf(id);

		jedis.del(stringID);
	}

	private static void read(Jedis jedis) {
		Scanner readS = new Scanner(System.in);
		System.out.println("ID a buscar: ");
		int id = readS.nextInt();
		String stringID = String.valueOf(id);

		String res = jedis.get(stringID);
		System.out.println(res);
	}

	public static void main(String[] args) throws Exception {
		try {
			Jedis jedis = new Jedis("localhost");

			Scanner sc = new Scanner(System.in);
			int numberOption;

			while (true){
				System.out.println("1.- CREATE");
				System.out.println("2.- DELETE");
				System.out.println("3.- UPDATE");
				System.out.println("4.- READ");

				System.out.print("Selecciona una opcion a realizar: ");
				numberOption = sc.nextInt();
				System.out.println(numberOption);

				switch (numberOption) {
					case 1:
						create(jedis);
						break;
					case 2:
						delete(jedis);
						break;
					case 3:
						update(jedis);
						break;
					case 4:
						read(jedis);
						break;
					default:
						break;
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
