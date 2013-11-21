
package towergame;

public class Bank {

	private int bankTotal;

	public Bank(int bankTotal) {
		this.bankTotal = bankTotal;
	}

	public void setBankValue(int newBankValue) {
		this.bankTotal = newBankValue;
	}

	public int getBankValue() {
		return this.bankTotal;
	}

	public void changeBankValue(int changeBankValue) {
		this.bankTotal += changeBankValue;
	}

}
