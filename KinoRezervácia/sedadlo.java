package KinoRezervácia;

public class sedadlo
{
	private int cislo;
	private boolean obsadene;
	
	public sedadlo(int cislo, boolean obsadene)
	{
		this.cislo = cislo;
		this.obsadene = obsadene;
	}
	
	public void setObsadene(boolean obsadene)
	{
		this.obsadene = obsadene;
	}
	
	public boolean getObsadene()
	{
		return this.obsadene;
	}
}
