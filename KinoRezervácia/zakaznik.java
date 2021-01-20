package KinoRezervácia;

public class zakaznik
{
	private int id;
	private String meno;
	private String priezvisko;
	
	public zakaznik(int id, String meno, String priezvisko)
	{
		this.id = id;
		this.meno = meno;
		this.priezvisko = priezvisko;
	}
	
	public int getId()
	{
		return this.id;
	}
}