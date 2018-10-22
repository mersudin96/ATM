import java.util.ArrayList;
import java.util.Scanner;

public class Banka {
	public static ArrayList<Account>listaRacuna=new ArrayList<Account>();
	
	public static int generisiBroj() {
		int r=(int)(Math.random()*1000000000);
		return r;
	}
	public static boolean vecPostoji(int broj) {
		boolean uslov=false;
		for(int i=0; i<listaRacuna.size(); i++) {
			if(listaRacuna.get(i).getAccountNumber()==broj) {
				uslov=true;
				break;
			}
			else
				uslov=false;
		}
		return uslov;
	}
	
	
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
				String imeKor=unos.next();
				account.setOwnerName(imeKor);
				System.out.print("Unesite password koji zelite ubuduce koristiti: ");
				String password=unos.next();
				account.setUserPassword(password);
				System.out.print("Koliko zelite novca poloziti na racun: ");
				
				int polog=unos.nextInt();
				while(polog<=0) {
					System.out.println("Morate staviti bar malo novca na racun.");
					polog=unos.nextInt();
				}
				account.addFunds(polog);
				listaRacuna.add(Account.getBrojRacunaUkupno()-1, account);
				System.out.println("\nUspjesno otvoren racun. Vas broj racuna je: " +account.getAccountNumber() +"\n");
				break;
			
			case 2:
				TransferNovca transfer=new TransferNovca();
				System.out.println("Unesite racun sa kojeg saljete novac: ");
				transfer.setSourceAccount(unos.nextInt());
				System.out.println("");
				System.out.println("Unesite racun na koji saljete novac: ");
				transfer.setTargetAccount(unos.nextInt());
				System.out.println("Unesite kolicinu novca koji zelite poslati: ");
				transfer.setAmmount(unos.nextDouble());
				transfer.sendMoney();
				break;
				
			case 3:
				System.out.print("Unesite broj vaseg racuna: ");
				int brRacuna=unos.nextInt();
				System.out.print("Vas password: ");
				String pass=unos.next();
				for(int i=0; i<listaRacuna.size(); i++) {
					if(listaRacuna.get(i).getAccountNumber()==brRacuna) {
						if(listaRacuna.get(i).getUserPassword().equals(pass))
							System.out.println(listaRacuna.get(i).toString());
						else
							System.out.println("Password nije validan.");
						break;
					}
					else {
						if(i==listaRacuna.size()-1)
							System.out.println("Broj Racuna nije validan.");
					}
				}
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
				break;
				
			}
		}while(izborKor!=0);
		unos.close();
		
	}
	
}
