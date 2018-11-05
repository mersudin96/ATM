import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	private int	 accountNumber;
	private String ownerName;
	private static String adminPassword="adminovaSifra";
	private String userPassword;
	private double moneyOnAccount;
	private static int brojRacunaUkupno;
	
	Scanner unos=new Scanner(System.in);
	static ArrayList<Account>listaRacuna=new ArrayList<Account>();
	
	public Account() {
		brojRacunaUkupno++;
	}
	
	public Account(int accountNumber, String ownerName, double moneyOnAccount ) {
		this.accountNumber=accountNumber;
		this.ownerName=ownerName;
		this.moneyOnAccount=moneyOnAccount;
		brojRacunaUkupno++;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public static String getAdminPassword() {
		return adminPassword;
	}
	
	public static int getBrojRacunaUkupno() {
		return brojRacunaUkupno;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public double getMoneyOnAccount() {
		return moneyOnAccount;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword=userPassword;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber=accountNumber;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName=ownerName;
	}
	
	public void addFunds(double ammount) {
		moneyOnAccount+=ammount;
	}
	
	public void removeFunds(double ammount) {
		moneyOnAccount-=ammount;
	}
	
	public static void isValidAcc(int brRacuna, String pass) {
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
	}
	
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
	
	public void uplata(double polog) {
		addFunds(polog);
	}
	
	public String toString() {
		return "\n\t"
				+ "Broj racuna: " +accountNumber +"\n\t"
				+ "Vlasnik racun: " +ownerName +"\n\t"
				+ "Password: " +userPassword +"\n\t"
				+ "Stanje na racunu: " +moneyOnAccount
				+ "\n";
	}
	
}
