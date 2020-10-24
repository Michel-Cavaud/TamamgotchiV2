package tamagotchiv2;

public class CatTama extends Tamagotchi{
	

	public CatTama(String name, String color, String hairColor) {
		super(name, color, hairColor);
		
		this.size = 0.32; 
		this.life = 50;
		
		this.typeTexte = " ,  je suis un chat";
		this.type = "Cat";
		this.imageTama = "          .__....._             _.....__,"
				+"\n            .\": o :':         ;': o :\"."
				+"\n            `. `-' .'.       .'. `-' .'"
				+"\n              `---'             `---'"
				+"\n"
				+"\n    _...----...      ...   ...      ...----..._"
				+"\n .-'__..-\"\"'----    `.  `\"`  .'    ----'\"\"-..__`-."
				+"\n'.-'   _.--\"\"\"'       `-._.-'       '\"\"\"--._   `-.`"
				+"\n'  .-\"'                  :                  `\"-.  `"
				+"\n  '   `.              _.'\"'._              .'   `"
				+"\n        `.       ,.-'\"       \"'-.,       .'"
				+"\n          `.                           .'"
				+"\n            `-._                   _.-'"
				+"\n                `\"'--...___...--'\"`";


		
		this.imageWhale = "                         ____    .-."
				+"\n                     .-\"`    `\",( __\\_"
				+"\n      .-==:;-._    .'         .-.     `'."
				+"\n    .'      `\"-:'-/          (  \\} -=a  .)"
				+"\n   /            \\/       \\,== `-  __..-'`"
				+"\n'-'              |       |   |  .'\\ `;"
				+"\n                  \\    _/---'\\ (   `\"`"
				+"\n                 /.`._ )      \\ `;"
				+"\n                 \\`-/.'        `\"`"
				+"\n                  `\"\\`-."
				+"\n                     `\"`";
		
		this.setMenu(); //create all the actions of theTamagotchi that can be displayed by getFunctionList()
	}
	
	
	/**
	 * The cat barks life -1
	 * @return Votre "name" ne peut pas plus miauler !
				<br>Il a maintenant "life" points de vie
				<br>or
				<br>Votre "name" miaule (miaou miaou) !
				<br>Votre "name"  a 3 points de santé en plus! 
				<br>et 1 points de vie en moins
				<br>Il a maintenant "health" points de santé
				<br>Il a maintenant "life" points de vie
	 */
	public String meow() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.health < 30) {
				textReturn ="Votre " + this.name + " ne peut plus miauler !"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				this.health += 3;
				this.setHealth(3);
				textReturn = "Votre " + this.name + " miaule (miaou miaou)" 
						+ "\n\nVotre " + this.name + " a 3 points de santé en plus! !"
						+ "\net 1 point de vie en moins"
						+ "\nIl a maintenant " + this.health + " points de santé"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * tail coloring life -1
	 * @param color the new tail color
	 * @return Votre "name" ne peux pas être roux !!!!
					<br>Il a maintenant "life" points de vie
					<br>or
					<br>Votre "name" à la queue "color" maintenant
					<br>Il a maintenant "life" points de vie
	 */
	@Override
	public String hair(String color) {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(color.equals( "ROUX") || color.equals("roux") || color.equals("Roux")) {
				textReturn ="Votre " + this.name + " ne peux pas être roux !!!!"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				this.hairColor = color;
				textReturn ="Votre " + this.name + " à la queue " + color + " maintenant"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * Returns the set of actions of the Tamagotchi dragon
	 * @return  Que voulez vous faire avec "name"?
					<br>Le faire manger -- > 1
					<br>Aller aux toilettes -- > 2
					<br>Teindre la queue -- > 3
					<br>Se reposer -- > 4
					<br>Se reproduire -- > 5
					<br>Exprimer sa joie -- > 6
					<br>Voir ses amis -- > 7
					<br>Faire du sport -- > 8
					<br>Enlever son masque or  Mettre son masque --> 9
					<br>Se laver -- > 10
					<br>Fumer-- > 11
					<br>Se reproduire à deux -- > 12
					<br>Miauler -- > 13
					<br>
					<br>Voir votre Tamagotchi -- > 88
					<br>Le faire mourir -- > 99
	 */
	protected String setMenu() {
		String textMask = this.mask? "Enlever son masque": "Mettre son masque";
		if(this.life <= 0 || this.health <= 0) {
			this.actions = "";
		}else {
			this.actions = this.imageTama 
					+"\n\nQue voulez vous faire avec " + this.name + "?"
					+ "\nLe faire manger -- > 1"
					+ "\nAller aux toilettes -- > 2"
					+ "\nTeindre sa queue -- > 3"
					+ "\nSe reposer -- > 4"
					+ "\nSe reproduire -- > 5"
					+ "\nExprimer sa joie -- > 6"
					+ "\nVoir ses amis -- > 7"
					+ "\nFaire du sport -- > 8"
					+ "\n" + textMask + " --> 9"
					+ "\nSe laver -- > 10"
					+ "\nFumer -- > 11"
					+ "\nSe reproduire à deux -- > 12"
					+ "\nMiauler -- > 13"
					+ "\n"
					+ "\nVoir votre Tamagotchi -- > 88"
					+ "\nLe faire mourir -- > 99";
		}
		return this.actions;
	}
	
	/**
	 * the Tamagotchi meal hunger +5, life -1
	 * @return Votre "name" n'a pas faim !
					<br>Il a maintenant "life" points de vie
					<br>or
					<br>Votre "name" a bien mangé !
					<br> "imageWhale"
				    <br><br>Votre "name" a 5 point de faim en plus ! !
					<br>et 1 points de vie en moins
				    <br>Il a maintenant "hunger" points de faim
					<br>Il a maintenant "life" points de vie
	 */
	@Override
	public String eat() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.hunger == 100) {
				textReturn ="Votre " + this.name + " n'a pas faim !"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				this.setHunger(5);
				textReturn = "Votre " + this.name + " a bien mangé sa souris !"
						 + "\n" + this.imageWhale
						+ "\n\nVotre " + this.name + " a 5 point de faim en plus ! !"
						+ "\net 1 points de vie en moins"
						+ "\nIl a maintenant " + this.hunger + " points de faim"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}


	@Override
	protected String fire() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String bark() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
		
}
