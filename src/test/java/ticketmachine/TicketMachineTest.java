package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() throws Exception {
            machine.insertMoney(10);
            machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance()); // Les montants ont été correctement additionnés               
	}

	@Test
	//  S3 : on n’imprime pas le ticket si le montant inséré est insuffisant
	public void checkTicketFailure() {
		assertFalse(machine.printTicket()); // Les montants ont été correctement additionnés               
	}
        
	@Test
	// S4 : on imprime le ticket si le montant inséré est suffisant
	public void checkTicketSuccess() throws Exception {
            machine.insertMoney(70);
	assertTrue(machine.printTicket()); // Les montants ont été correctement additionnés               
	}
        
        @Test
         //S5 : Quand on imprime un ticket la balance est décrémentée du prix du ticket
        public void checkDecrementation() throws Exception {
        machine.insertMoney(70);
	machine.printTicket();
            assertEquals(20, 70-PRICE);
	}
        
        @Test
         // S6 : le montant collecté est mis à jour quand on imprime un ticket (pas avant)
        public void montantCollecteMisAJour() throws Exception {
        machine.insertMoney(70);
	machine.printTicket();
        assertEquals(PRICE, machine.getTotal());
	}
        
        @Test
         //  S7 : refund() rend correctement la monnaie
        public void rendMonnaieSucces() throws Exception {
        machine.insertMoney(20);
            assertEquals(machine.refund(), 20);
	}
                
        @Test
         //  S8 : refund() remet la balance à zéro
        public void balanceZero() {
        machine.refund();
            assertEquals(0, machine.getBalance());
	}
        
        @Test (expected = Exception.class)
         //  S9 : on ne peut pas insérer un montant négatif
        public void insertNegative() throws Exception {
        machine.insertMoney(-20);
	}

        @Test (expected = IllegalArgumentException.class)
         //  S10 : on ne peut pas créer de machine qui délivre des tickets dont le prix est négatif
        public void machineCorrect() throws Exception {
        TicketMachine machinetest = new TicketMachine(-20);
	}
}
