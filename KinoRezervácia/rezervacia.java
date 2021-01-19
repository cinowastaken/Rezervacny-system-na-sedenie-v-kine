package KinoRezervácia;

public class rezervacia
{
	zakaznik zakaznik;
	film film;
	int sedadlo;
	
	public rezervacia(zakaznik zakaznik, film film)
	{
		this.zakaznik = zakaznik;
		this.film = film;
	}
	
	public void setSedadlo(int sedadlo)
	{
		this.sedadlo = sedadlo;
	}
	
	public boolean rezervaciaSedadlo(int sedadlo)
	{
		if (film.getSedadla().get(sedadlo).getObsadene())
		{
			return false;
		}
		else
		{
			film.getSedadla().get(sedadlo).setObsadene(true);
			setSedadlo(sedadlo);
			return true;
		}
	}
	
	public boolean zrusenieSedadlo()
	{
		film.getSedadla().get(this.sedadlo).setObsadene(false);
		return true;
	}
	
	public zakaznik getZakaznik()
	{
		return this.zakaznik;
	}
}
