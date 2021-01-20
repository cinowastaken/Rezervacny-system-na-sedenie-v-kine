package KinoRezervácia;

import java.util.*;

public class film
{
	private String nazov;
	private int obsadenie = 50;
	private ArrayList<sedadlo> sedadla;
	
	public film(String nazov)
	{
		this.nazov = nazov;
		sedadla = new ArrayList<sedadlo>();
		vytvorSedadla(this.obsadenie);
	}
	
	public String getNazov()
	{
		return nazov;
	}
	
	public ArrayList<sedadlo> getSedadla()
	{
		return sedadla;
	}
	
	public void vytvorSedadla(int obsadenie)
	{
		for (int i = 1; i <= obsadenie; i ++)
		{
			sedadla.add(new sedadlo(i, false));
		}
	}
	
	public void obsadenie()
	{
		for (int i = 1; i <= this.obsadenie; i++)
		{
			System.out.print(i + " ");
			if (i == 10 || i == 20 || i == 30 || i == 40 || i == 50)
			{
				System.out.println();
			}
		}
	}
}