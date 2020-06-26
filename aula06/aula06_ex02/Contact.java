package lab0602;

public class Contact {
	private String name;
	private int number;
	
	public Contact(String name, int number) {
		this.name=name;
		this.number=number;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setNumber(int num) {
		this.number = num;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String toString(){
        return String.format("%s:%d", this.name, this.number);
    }
}
