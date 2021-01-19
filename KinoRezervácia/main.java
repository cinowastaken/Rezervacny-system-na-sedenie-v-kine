package KinoRezervácia;

import java.util.*;

public class main
{
	public static void main(String[] args)
	{
		int moznost = 0;
		
		ArrayList<zakaznik> zakaznici = new ArrayList<zakaznik>();
		ArrayList<film> filmy = new ArrayList<film>();
		ArrayList<rezervacia> rezervacie = new ArrayList<rezervacia>();
		
		filmy.add(new film("Shrek"));
		filmy.add(new film("LOTR"));
		filmy.add(new film("Star Wars"));
		
		System.out.println("----------------------------------------");
		System.out.println("KINO");
		System.out.println("----------------------------------------");
		System.out.println("Ceny:");
		System.out.println("Klasický lístok: 4,50€");
		System.out.println("Detský lístok: 3€");
		
		Scanner scanner = new Scanner(System.in);
		
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("Zadajte 1 pre rezerváciu");
			System.out.println("Zadajte 2 pre zrušenie rezervácie");
			System.out.println("Zadajte 3 pre ukončenie");
			System.out.println("----------------------------------------");
		
			System.out.println("Zadajte možnosť: ");
			moznost = scanner.nextInt();
			
			while (moznost < 1 || moznost > 3 )
			{
				System.out.println("----------------------------------------");
				System.out.println("Zadali ste zlé číslo. Prosím zadajte 1-3.");
				moznost = scanner.nextInt();
			}
			
			if (moznost == 1)
			{
				System.out.println("----------------------------------------");
				System.out.println("Zadali ste rezerváciu");
				System.out.println("----------------------------------------");
				
				System.out.println("Zadajte svoje meno: ");
				String meno = scanner.next();
				System.out.println("Zadajte svoje priezvisko: ");
				String priezvisko = scanner.next();
				
				Random rand = new Random();
				int id = rand.nextInt(1000);
				
				zakaznik zakaznik = new zakaznik(id, meno, priezvisko);
				zakaznici.add(zakaznik);
				
				System.out.println("----------------------------------------");
				System.out.println("Vyberte film");
				System.out.println("----------------------------------------");
				
				for (int i = 0; i < filmy.size(); i++)
				{
					int cisloFilm = i + 1;
					System.out.println("Film č.: " + cisloFilm);
					System.out.println("Nazov filmu: " + filmy.get(i).getNazov());
					System.out.println();
				}
				
				System.out.println("----------------------------------------");
				System.out.println("Zadajte č. filmu: ");
				int film = scanner.nextInt();
				
				while (film < 1 || film > filmy.size())
				{
					System.out.println("----------------------------------------");
					System.out.println("Zadali ste zlé číslo. Prosím zadajte 1-" + filmy.size() + ".");
					film = scanner.nextInt();
				}
				
				int nakup = 0;
				double suma = 0;
				
				do
				{
					System.out.println("----------------------------------------");
					System.out.println("Zadajte [1] pre klasický lístok alebo [2] pre detský lístok: ");
					int listok = scanner.nextInt();
					
					while (listok < 1 || listok > 2)
					{
						System.out.println("----------------------------------------");
						System.out.println("Zadali ste zlé číslo. Prosím zadajte 1-2.");
						listok = scanner.nextInt();
					}
					
					if (listok == 1)
					{
						suma += 4.50;
					}
					else if (listok == 2)
					{
						suma += 3;
					}
					
					System.out.println("----------------------------------------");
					filmy.get(film - 1).obsadenie();
					System.out.println("----------------------------------------");
					
					System.out.println("Vyberte sedadlo: ");
					int sedadlo = scanner.nextInt();
					
					while (sedadlo < 1 || sedadlo > 50)
					{
						System.out.println("----------------------------------------");
						System.out.println("Zadali ste zlé číslo. Prosím zadajte 1-50.");
						sedadlo = scanner.nextInt();
					}
					
					System.out.println("----------------------------------------");
					rezervacia rezervacia = new rezervacia(zakaznik, filmy.get(film - 1));
					
					if (rezervacia.rezervaciaSedadlo(sedadlo))
					{
						rezervacie.add(rezervacia);
						System.out.println("Rezervovali ste si sedadlo.");
					}
					else
					{
						System.out.println("Sedadlo je obsadené.");
						if (listok == 1)
						{
							suma -= 4.50;
						}
						else if (listok == 2)
						{
							suma -= 3;
						}
					}
					
					System.out.println("----------------------------------------");
					System.out.println("Zadajte [1] ak chcete rezervovať ďalšie sedadlo alebo [2] ak chcete zaplatiť: ");
					nakup = scanner.nextInt();
					
					while (nakup < 1 || nakup > 2)
					{
						System.out.println("----------------------------------------");
						System.out.println("Zadali ste zlé číslo. Prosím zadajte 1-2.");
						nakup = scanner.nextInt();
					}
					
				} while (nakup == 1);
				
				System.out.println("----------------------------------------");
				System.out.println("Cena: " + suma + "€");
				System.out.println("ID rezervácie: " + zakaznik.getId());
			}
		
			if (moznost == 2)
			{
				System.out.println("----------------------------------------");
				System.out.println("Zadali ste zrušenie rezervácie");
				System.out.println("----------------------------------------");
				
				System.out.println("Zadajte vaše ID objednávky: ");
				int id = scanner.nextInt();
				System.out.println("----------------------------------------");
				
				int zrusenie = 0;
				
				for (zakaznik zakaznik : zakaznici)
				{
					if (zakaznik.getId() == id)
					{
						for (rezervacia rezervacia : rezervacie)
						{
							if (rezervacia.getZakaznik().getId() == zakaznik.getId())
							{
								rezervacia.zrusenieSedadlo();
								zrusenie = 1;
							}
						}
					}
				}
				
				if (zrusenie == 1)
				{
					System.out.println("Zrušili ste objednávku.");
				}
				else
				{
					System.out.println("Zadané ID objednávky neexistuje.");
				}
			}
			
			if (moznost == 3)
			{
				System.out.println("----------------------------------------");
				System.out.println("Koniec programu.");
				System.out.println("----------------------------------------");
				System.exit(0);
			}
		} while (true);
	}
}