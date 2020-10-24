package tamagotchiv2;

public class TamaTama extends Tamagotchi {
	
	public TamaTama(String name, String color, String hairColor){
		super(name, color, hairColor);
		
		this.typeTexte = " , je suis un Tamagotchi";
		this.type ="Tama";
		this.size = 1.72; 
		this.life = 100;
		
		this.imageTama = "   .^._.^."
				+"\n  | .    . |"
				+"\n  (  ----  )"
				+"\n  .'       '."
				+"\n |/         \\|"
				+"\n   \\ /--\\ /"
				+"\n    V    V";
		
		this.setMenu(); //create all the actions of theTamagotchi that can be displayed by getFunctionList()
		
	}
	
	/**
	 * Returns the set of actions of the Tamagotchi
	 * @return  Que voulez vous faire avec "name"?
					<br>Le faire manger -- > 1
					<br>Aller aux toilettes -- > 2
					<br>Teindre les cheveux -- > 3
					<br>Se reposer -- > 4
					<br>Se reproduire -- > 5
					<br>Exprimer sa joie -- > 6
					<br>Voir ses amis -- > 7
					<br>Faire du sport -- > 8
					<br>Enlever son masque or  Mettre son masque --> 9
					<br>Se laver -- > 10
					<br>Fumer-- > 11
					<br>Se reproduire à deux-- > 12
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
					+ "\nTeindre les cheveux -- > 3"
					+ "\nSe reposer -- > 4"
					+ "\nSe reproduire -- > 5"
					+ "\nExprimer sa joie -- > 6"
					+ "\nVoir ses amis -- > 7"
					+ "\nFaire du sport -- > 8"
					+ "\n" + textMask + " --> 9"
					+ "\nSe laver -- > 10"
					+ "\nFumer -- > 11"
					+ "\nSe reproduire à deux -- > 12"
					+ "\n"
					+ "\nVoir votre Tamagotchi -- > 88"
					+ "\nLe faire mourir -- > 99";
		}
		return this.actions;
	}

	@Override
	protected String fire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String meow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String bark() {
		// TODO Auto-generated method stub
		return null;
	}

}
