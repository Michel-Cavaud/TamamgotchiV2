package tamagotchiv2;

import outils.Clavier;

public class MainScript {

	public static void main(String[] args) {
		String valMenu;
		int valMenuInt = 0;
		String prenom;
		String color;
		String colorHair;
		Tamagotchi myTama = null;
		

		do {
			System.out.println("Choisir votre tye de Tomamgotchi:");
			System.out.println("Tamagotchi simple\t --> 1");
			System.out.println("Tamagotchi dragon\t --> 2");
			System.out.println("Tamagotchi chat\t\t --> 3");
			System.out.println("Tamagotchi chien\t --> 4");
			System.out.println("Fin du jeu\t\t --> 99");
			valMenu = Clavier.lireString();
			try { 
					valMenuInt = Integer.parseInt(valMenu);
			}
			catch(Exception e){  //if user enters anything other than a number
				emptyConsole(50) ; //Empty the console
				System.out.println("Attention faite le bon choix !!! (1, 2, 3, 4 ou  99 pour sortir)");
				continue;
			}
			if (valMenuInt > 0 && valMenuInt < 5) {
				do {
					System.out.println("Le prénom de votre Tomamgotchi");
					prenom = Clavier.lireString();
				}while(prenom.equals(""));
				do {
					System.out.println("La couleur de votre Tomamgotchi");
					color = Clavier.lireString();	
				}while(color.equals(""));
				do {
					if(valMenuInt == 3 || valMenuInt == 4) {
						System.out.println("La couleur de la queue de votre Tomamgotchi");
					}else {
						System.out.println("La couleur des cheveux de votre Tomamgotchi");
					}
					
					colorHair = Clavier.lireString();	
				}while(colorHair.equals(""));
				
				switch(valMenuInt) {
				case 1 : myTama = new TamaTama(prenom,  color, colorHair);							
				break;
				case 2 : myTama = new DragonTama(prenom,  color, colorHair);
				break;
				case 3 : myTama = new CatTama(prenom,  color, colorHair);
				break;
				case 4 : myTama = new DogTama(prenom,  color, colorHair);
				break;
				}
				valMenuInt = playTama(myTama);
			}
		}while(valMenuInt != 99);
		System.out.println("Au revoir à bientôt");
	}
	
	public static int playTama(Tamagotchi myTama) {
		String valMenu; 
		String colorHair;
		int valMenuInt = 0;
		
		System.out.println(myTama.showTamagotchi());
		do {
			System.out.println(myTama.getFunctionList());
			
			valMenu = Clavier.lireString();
			try {
					valMenuInt = Integer.parseInt(valMenu);
			}
			catch(Exception e){
				emptyConsole(100);
				System.out.println("Attention faite le bon choix !!!");
				continue;
			}
			switch(valMenuInt) {
				case 1 : emptyConsole(100);
						System.out.println(myTama.eat());
						enterKey();
				break;
				
				case 2 : emptyConsole(100);
							System.out.println(myTama.wc());
							enterKey();
				break;
				
				case 3 : emptyConsole(100);
							if(myTama.getType() == "Cat" || myTama.getType() == "Dog") {
								System.out.println("Quelle couleur pour la queue ?");
							}else {
								System.out.println("Quelle couleur pour les cheveux ?");
							}
							
							colorHair = Clavier.lireString();
							System.out.println(myTama.hair(colorHair));
							enterKey();
				break;
				
				case 4 : emptyConsole(100);
							System.out.println(myTama.sleep());
							enterKey();
				break;
				
				case 5 : emptyConsole(100);
							System.out.println(myTama.reproduce());
							enterKey();
				break;
				
				case 6 : emptyConsole(100);
							System.out.println(myTama.mood());
							enterKey();
				break;
				
				case 7 : emptyConsole(100);
							System.out.println(myTama.seeFriends());
							enterKey();
				break;
				
				case 8 : emptyConsole(100);
							System.out.println(myTama.playSports());
							enterKey();
				break;
				
				case 9 : emptyConsole(100);
							System.out.println(myTama.moveMask());
							enterKey();
				break;
				
				case 10 : emptyConsole(100);
							System.out.println(myTama.wash());
							enterKey();
				break;
				
				case 11 : emptyConsole(100);
							System.out.println(myTama.smoke());
							enterKey();
				break;
				
				case 12 : emptyConsole(100);
							System.out.println(myTama.getName() + " va se reproduire avec Dimock");
							Tamagotchi dimock;
							if(myTama.getType() == "Dragon") {
								 dimock = new DragonTama("Dimock", "bleu" ,  "vert");
							}
							else if (myTama.getType() == "Cat") {
								dimock = new CatTama("Dimock", "bleu" ,  "vert");
							}
							else if (myTama.getType() == "Dog") {
								dimock = new DogTama("Dimock", "bleu" ,  "vert");
							}
							else {
								dimock = new TamaTama("Dimock", "bleu" ,  "vert");
							}
							
							System.out.println(myTama.reproduceTwo(dimock));
							enterKey();
				break;
				
				case 13 : emptyConsole(100);
							System.out.println(myTama.specificShoutAction());
							enterKey();
				break;
							
				case 88 : emptyConsole(100); 
							System.out.println(myTama.showTamagotchi());
							enterKey();
				break;
				
				case 99 :  emptyConsole(100);
							System.out.println(myTama.getName() + " est mort !");
							myTama = null;
				break;
				
				default : emptyConsole(100);
								System.out.println(myTama.getName() + " n'est pas capable de faire cela !");
				break;
			}
		}while(valMenuInt != 99);
		return valMenuInt;
	}
		
	/**
	 *  Empty the console
	 * @param line //number line
	 */
	public static void emptyConsole(int line) {
		for (int i = 0; i < line; ++i)
			System.out.println("") ; // Empty the console
	}
	
	public static void enterKey() {
		String enter = "";
		do {
			System.out.println("\nAppuyez sur entrée pour continuer");
			enter = Clavier.lireString();
		}while(!enter.equals(""));
	}

}
