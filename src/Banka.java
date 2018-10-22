import java.util.Scanner;

public class Banka extends Account {
	

	public static void main(String[] args) {
		
		Scanner unos=new Scanner(System.in);
		int izborKor;
		
		System.out.println("\t *Dobrodosli u C++J banku*");
		do {
			System.out.println("\n1. - Izrada novog racuna \n"
					+ "2. - Transfer novca na drugi racun \n"
					+ "3. - Informacije o vasem racunu \n\n"
					+ "4. - Ispis svih racuna (Admin mod)\n\n"
					+ "0. - Izlaz");
			
			izborKor=unos.nextInt();
			switch(izborKor) {
			case 1:
				Account account=new Account();
				int accNumber=generisiBroj();
				while(vecPostoji(accNumber))
					accNumber=generisiBroj();
				account.setAccountNumber(accNumber);
				
				System.out.print("Unesite vase ime: ");
				account.setOwnerName(unos.next());
				System.out.print("Unesite password koji zelite ubuduce koristiti: ");
				account.setUserPassword(unos.next());
				System.out.print("Koliko zelite novca poloziti na racun: ");
				account.uplata(unos.nextDouble());
				
				listaRacuna.add(Account.getBrojRacunaUkupno()-1, account);
				System.out.println("\nUspjesno otvoren racun. Vas broj racuna je: " +account.getAccountNumber() +"\n");
				break;
			
			case 2:
				TransferNovca transfer=new TransferNovca();
				System.out.print("Unesite racun sa kojeg saljete novac: ");
				transfer.setSourceAccount(unos.nextInt());
				System.out.print("Unesite racun na koji saljete novac: ");
				transfer.setTargetAccount(unos.nextInt());
				System.out.print("Unesite kolicinu novca koji zelite poslati: ");
				transfer.setAmmount(unos.nextDouble());
				transfer.sendMoney();
				break;
				
			case 3:
				System.out.print("Unesite broj vaseg racuna: ");
				int brRacuna=unos.nextInt();
				System.out.print("Vas password: ");
				String pass=unos.next();
				Account.isValidAcc(brRacuna, pass);
				break;
				
			case 4:
				System.out.print("Unesi care sifru: ");
				String sifra=unos.next();
				if(Account.getAdminPassword().equals(sifra)) {
					for(int i=0; i<listaRacuna.size(); i++)
						System.out.print(listaRacuna.get(i));
				}
				else
					System.out.println("Profulo si nesto");
				break;
				
			default:
				if(izborKor==0)
					System.out.println("Dovidjenja.");
				else
					System.out.println("Pogresan unos.");
				
			}
		}while(izborKor!=0);
		unos.close();
	}
}
