import java.util.InputMismatchException;
import java.util.Scanner;

public class Banka extends Account {
	

	public static void main(String[] args) {
		
		Scanner unos=new Scanner(System.in);
		int izborKor=-1;
		
		System.out.println("\t *Dobrodosli u C++J banku*");
		do {
			System.out.println("\n1. - Izrada novog racuna \n"
					+ "2. - Transfer novca na drugi racun \n"
					+ "3. - Informacije o vasem racunu \n\n"
					+ "4. - Ispis svih racuna (Admin mod)\n\n"
					+ "0. - Izlaz");
			
			do {
				try {
					izborKor=unos.nextInt();
					if(izborKor<0 || izborKor>4)
						System.out.println("Opcije su od 1-4!");
				}
				catch(InputMismatchException ex) {
					System.out.println("Nevalidan unos. Pokusajte ponovo: ");
					unos.next();
				}
			}while(izborKor<0 || izborKor>4);
			
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
					double novac=-1;
					do {
						try {
							novac=unos.nextDouble();
							if(novac<0)
								System.out.println("morate polozit bar marku na racun xd");
						}
						catch(InputMismatchException ex) {
							System.out.println("Invalidan unos. Pokusajte ponovo: ");
							unos.next();
						}
					}while(novac<0);
					account.uplata(novac);
					
					listaRacuna.add(Account.getBrojRacunaUkupno()-1, account);
					System.out.println("\nUspjesno otvoren racun. Vas broj racuna je: " +account.getAccountNumber() +"\n");
					break;
				
				case 2:
					TransferNovca transfer=new TransferNovca();
					System.out.print("Unesite racun sa kojeg saljete novac: ");
					int source=-1;
					do {
						try {
							source=unos.nextInt();
							if(source<0)
								System.out.println("invalidan unos.");
						}
						catch(InputMismatchException e) {
							System.out.println("Pogresan unos. Pokusajte ponovo: ");
							unos.next();
						}
					}while(source<0);
					transfer.setSourceAccount(source);
					
					System.out.print("Unesite racun na koji saljete novac: ");
					int target=-1;
					do {
						try {
							target=unos.nextInt();
							if(target<0)
								System.out.println("invalidan unos.");
						}
						catch(InputMismatchException e) {
							System.out.println("Pogresan unos. Pokusajte ponovo: ");
							unos.next();
						}
					}while(target<0);
					transfer.setTargetAccount(target);
					
					
					System.out.print("Unesite kolicinu novca koji zelite poslati: ");
					novac=-1;
					do {
						try {
							novac=unos.nextDouble();
							if(novac<0)
								System.out.println("morate polozit bar marku na racun xd");
						}
						catch(InputMismatchException ex) {
							System.out.println("Invalidan unos. Pokusajte ponovo: ");
							unos.next();
						}
					}while(novac<0);
					transfer.setAmmount(novac);
					transfer.sendMoney();
					break;
					
				case 3:
					System.out.print("Unesite broj vaseg racuna: ");
					int brRacuna=-1;
					do {
						try {
							brRacuna=unos.nextInt();
							if(brRacuna<0)
								System.out.println("Nemoguce...");
						}
						catch(InputMismatchException ex) {
							System.out.println("Unesite validan broj racuna: ");
							unos.next();
						}
					}while(brRacuna<0);
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
					else if(izborKor==5)
						continue;
					else
						System.out.println("Pogresan unos.");
				}
			
		}while(izborKor!=0);
		unos.close();
	}
}
