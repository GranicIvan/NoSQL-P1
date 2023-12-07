package v1;

public class Drzava {

	private String ime;
	private int zip;
	private String stkraceno;
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public int getZip() {
		return zip;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public String getStkraceno() {
		return stkraceno;
	}
	
	public void setStkraceno(String stkraceno) {
		this.stkraceno = stkraceno;
	}

	public Drzava(String ime, int zip, String stkraceno) {
		super();
		this.ime = ime;
		this.zip = zip;
		this.stkraceno = stkraceno;
	}

	@Override
	public String toString() {
		return " [Drzava [ime=" + ime + ", zip=" + zip + ", stkraceno=" + stkraceno + "]] ";
	}
	
	
	
	
	
}
