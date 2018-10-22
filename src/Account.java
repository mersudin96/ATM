
public class Account {
	private int	 accountNumber;
	private String ownerName;
	private static String adminPassword="adminovaSifra";
	private String userPassword;
	private double moneyOnAccount;
	private static int brojRacunaUkupno;
	
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
	
	
	public String toString() {
		return "\n\t"
				+ "Broj racuna: " +accountNumber +"\n\t"
				+ "Vlasnik racun: " +ownerName +"\n\t"
				+ "Password: " +userPassword +"\n\t"
				+ "Stanje na racunu: " +moneyOnAccount
				+ "\n";
	}
	
}
