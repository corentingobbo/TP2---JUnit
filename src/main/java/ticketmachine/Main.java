package ticketmachine;

public class Main {

	public static void main(String[] args) throws Exception {
		TicketMachine machine = new TicketMachine(50);
		System.out.println("L'utilisateur insère 60 centimes");
		machine.insertMoney(60);
		System.out.println("L'utilisateur appuie sur 'Impression ticket'");
		machine.printTicket();
                System.out.println(machine.getBalance());
	}
}
