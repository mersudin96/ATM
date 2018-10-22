import java.util.Scanner;

public class TransferNovca extends Banka {
	Scanner unos= new Scanner(System.in);
	private int sourceAccount;
	private int targetAccount;
	private double ammount;
	
	public TransferNovca() {
		
	}
	
	public TransferNovca(int sourceAccount, int targetAccount, double ammount) {
		this.sourceAccount=sourceAccount;
		this.targetAccount=targetAccount;
		this.ammount=ammount;
	}

	public void setSourceAccount(int sourceAccount) {
		this.sourceAccount = sourceAccount;
	}


	public void setTargetAccount(int targetAccount) {
		this.targetAccount = targetAccount;
	}
	
	public void setAmmount(double ammount) {
		this.ammount=ammount;
	}
	
	
	public void sendMoney() {
		boolean source=false;
		boolean target=false;
		boolean tacanPassword=false;
		int indexSourca=0;
		int indexTargeta=0;
		double previusStateSource=0;
		
		
		for(int i=0; i<listaRacuna.size(); i++) {
			if(sourceAccount==listaRacuna.get(i).getAccountNumber()) {
				System.out.print(listaRacuna.get(i).getOwnerName() +" molimo unesite vas pasvord: ");
				String pass=unos.next();
				if(listaRacuna.get(i).getUserPassword().equals(pass))
					tacanPassword=true;
				else
					break;
				
				previusStateSource=listaRacuna.get(i).getMoneyOnAccount();
				if(previusStateSource-ammount>0) {
					source=true;
					indexSourca=i;
				}
			}
			if(targetAccount==listaRacuna.get(i).getAccountNumber()) {
				target=true;
				indexTargeta=i;
			}
		}
		
		
			if(source && target && ammount>0 && tacanPassword) {
				listaRacuna.get(indexTargeta).addFunds(ammount);
				listaRacuna.get(indexSourca).removeFunds(ammount);
				System.out.println("Transakcija uspjesno izvrsena...");
			}
			else if(source==false && target && ammount>0)
				System.out.println("Nevazeci broj racuna sa kojeg zelite vrsiti transakciju.");
			else if(source && target==false && ammount>0)
				System.out.println("Racun na koji zelite poslati novac nije validan.");
			else if(source==false && target==false && ammount>0)
				System.out.println("Nepostojeci racuni.");
			else if(source && target && ammount<0)
				System.out.println(ammount +" nije validan broj za transakciju.");
			else if(source && target && ammount>0 && tacanPassword==false)
				System.out.println("Pogresan password.");
			else
				System.out.println("Momak. Nemoj se zajebavat sa nama.");
	}
	
}
