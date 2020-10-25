package tamagotchiv2;

import outils.DatePerso;

abstract public class Tamagotchi {
	protected String name;
	protected String color;
	protected int health;
	protected int hunger;
	protected double size;
	protected int life;
	protected boolean mask;
	protected String hairColor;
	protected String dateBirth;
	protected String actions;
	protected String imageWhale;
	protected String imageTama;
	protected String type;
	protected String typeTexte;
	
	/**
	 * Constructor Tamagotchi 
	 * @param name
	 * @param color
	 * @param hairColor
	 */
	public Tamagotchi(String name, String color,  String hairColor) {
		this.name = name;
		this.color= color;
		this.hairColor = hairColor;
		this.health = 50;
		this.hunger = 50;
		this.mask = false;
		this.dateBirth = DatePerso.aujourdhui();
	}
	
	protected abstract String setMenu();
	protected abstract String fire();
	protected abstract String meow();
	protected abstract String bark();
	
	/**
	 * Smoke health -10, life -2
	 * @return Votre  "name" fume ! :(
					<br><br>Votre "name"  a 10 point de santé en moins
					<br>et 2 points de vie en moins
					<br>Il a maintenant "health"  points de santé
					<br>Il a maintenant "life" points de vie
	 */
	public String smoke() {
		String textReturn = "";
		this.setLife(-2);
		if(!checkLife()){
			this.setHealth(-10);
			textReturn = "Votre " + this.name + " fume ! :("
								+ "\n\nVotre " + this.name + " a 10 point de santé en moins"
								+ "\net 2 points de vie en moins"
								+ "\nIl a maintenant " + this.health + " points de santé"
								+ "\nIl a maintenant " + this.life + " points de vie";
		}
		return textReturn;
	}
	
	/**
	 * Wash health +3, hunger -2, life - 1
	 * @return Votre "this.name" s'est lavé
					<br><br>Votre "name" a 3 point de santé en plus
					<br>2 points de faim en moins
					<br>et 1 points de vie en moins
					<br>Il a maintenant "hunger" points de faim
					<br>Il a maintenant "health" points de santé
					<br>Il a maintenant "life" points de vie
	 */
	public String wash() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			this.setHealth(3);
			this.setHunger(-2);
			textReturn = "Votre " + this.name + " s'est lavé"
								+ "\n\nVotre " + this.name + " a 3 point de santé en plus"
								+ "\n 2 points de faim en moins"
								+ "\net 1 points de vie en moins"
								+ "\nIl a maintenant " + this.hunger + " points de faim"
								+ "\nIl a maintenant " + this.health + " points de santé"
								+ "\nIl a maintenant " + this.life + " points de vie";
		}
		return textReturn;
	}
	
	/**
	 * Put on or take off your mask
	 * @return  Votre "name" a enlevé son masque
	 * 					<br>or
	 * 					<br>Votre "name" a mis son masque 
	 */
	public String moveMask(){
		String textReturn = "";
		if(!this.checkLife()){
			if(this.mask) {
				textReturn = "Votre " + this.name + " a enlevé son masque ";
			}else {
				textReturn = "Votre " + this.name + " a mis son masque ";
			}
			this.setMask(!this.mask);
			this.setMenu();
		}
		return textReturn;
	}
	
	/**
	 * Play Sport life -1, health +3, .hunger -12
	 * @return Votre "name" fait du sport
					<br><br>Votre "name" a 3 point de santé en plus
					<br>1 points de vie en en moins et 12 points de faim en moins
					<br>Il a maintenant " +hunger" points de faim
					<br>Il a maintenant "health" points de santé
					<br>Il a maintenant "life" points de vie
					<br>or
					<br>Votre "name" n'est pas assez en forme pour faire du sport
					<br>Il a maintenant "life" points de vie
					
	 */
	public String playSports() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.hunger > 35) {
				this.setHunger(-12);
				this.setHealth(3);
				textReturn = "Votre " + this.name + " fait du sport"
									+ "\n\nVotre " + this.name + " a 3 point de santé en plus"
									+ "\n 1 points de vie en en moins et 12 points de faim en moins"
									+ "\nIl a maintenant " + this.hunger + " points de faim"
									+ "\nIl a maintenant " + this.health + " points de santé"
									+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				textReturn ="Votre " + this.name + " n'est pas assez en forme pour faire du sport"
									+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * See friends life -5, health +3, hunger +2
	 * @return  Votre "name" va voire ses amis
					<br><br>Votre "name" a 10 point de santé en plus
					<br>1 points de vie en en moins et 2 points de faim en plus
					<br>Il a maintenant ".hunger" points de faim
					<br>Il a maintenant "health" points de santé
					<br>Il a maintenant "life" points de vie
					<br>or
					<br>Votre "name" n'est pas assez en forme pour voir ses amis
					<br>Il a maintenant "life" points de vie
	 */
	public String seeFriends() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.health > 20) {
				this.setHealth(10);
				this.setHunger(2);
				textReturn = "\nVotre " + this.name + " va voir ses amis"
									+ "\nVotre " + this.name + " a 10 point de santé en plus"
									+ "\n 1 points de vie en en moins et 2 points de faim en plus"
									+ "\nIl a maintenant " + this.hunger + " points de faim"
									+ "\nIl a maintenant " + this.health + " points de santé"
									+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				textReturn ="Votre " + this.name + " n'est pas assez en forme pour voir ses amis"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
		
	}
	
	/**
	 * express your mood health +2, hunger +2, life -1
	 * @return Votre "name" saute de joie
					<br><br>Votre this.name" a 2 point de santé en plus
					<br>1 points de vie en en moins et 2 points de faim en plus
					<br>Il a maintenant "health" points de santé
					<br>Il a maintenant "hunger" points de faim
					<br>Il a maintenant "this.life" points de vie
					<br>or
					<br>Votre "name" n'a pas assez de santé et doit manger pour exprimer son humeur
					<br>Il a maintenant "life" points de vie";
	 */
	public String mood() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.health > 10 && this.hunger > 10) {
				this.setHealth(2);
				this.setHunger(2);
				textReturn ="Votre " + this.name + " saute de joie"
						+ "\n\nVotre " + this.name + " a 2 point de santé en plus"
						+ "\n 1 points de vie en en moins et 2 points de faim en plus"
						+ "\nIl a maintenant " + this.health + " points de santé"
						+ "\nIl a maintenant " + this.hunger + " points de faim"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				textReturn ="Votre " + this.name + " n'a pas assez de santé et doit manger pour exprimer son humeur"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * reproduction has two objects life -2, health - 30, hunger -20 for two objects
	 * @param two  another Tamagotchi (object)
	 * @return La reproduction avec  "two.getName()" s'est bien passée
					<br><br>Votre "name" et "two.getName()" ont 30 points de santé en moins
					<br>2 points de vie en en moins et 20 points de faim en moins
					<br>"name" a maintenant "hunger" points de faim
					<br>"name" a maintenant "health" points de santé
					<br>"name" a maintenant ".life" points de vie
					<br>or
					<br>Votre "name" et "two.getName()" n'ont pas les capacités pour se reproduire
					<br>"name" a maintenant "life" points de vie
	 */
	public String reproduceTwo(Tamagotchi two) {
		String textReturn = "";
		this.setLife(-2);
		if(!this.checkLife()){
			two.setLife(two.getLife() + 2);
			if(this.health > 30 && this.hunger > 20 && two.getHealth() > 30 && two.getHunger() > 20) {
				this.setHealth(-30);
				this.setHunger(-20);
				two.setHealth (-30);
				two.setHunger(-20 );
				textReturn = "La reproduction avec " + two.getName() + " s'est bien passée"
									+ "\n\nVotre " + this.name + " et " + two.getName() + " ont 30 points de santé en moins"
									+ "\n 2 points de vie en en moins et 20 points de faim en moins"
									+ "\n" + this.name + " a maintenant " + this.hunger + " points de faim"
									+ "\n" + this.name + " a maintenant " + this.health + " points de santé"
									+ "\n" + this.name + " a maintenant " + this.life + " points de vie";
			}else {
				textReturn ="Votre " + this.name + " et " + two.getName() + " n'ont pas les capacités pour se reproduire"
									+ "\n" + this.name + " a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
		
	}
	
	/**
	 * Reproduction health -30, hunger -20, life -2
	 * @return  La reproduction s'est bien passée
					  <br><br>Votre "name" a 30 point de santé en moins
						<br>2 points de vie en en moins et 20 points de faim en moins
						<br>Il a maintenant "hunger" points de faim
						<br>Il a maintenant "health" points de santé
						<br>Il a maintenant "life" points de vie
						<br>or
						<br>Votre "name" n'a pas les capacités pour se reproduire
						<br>Il a maintenant "this.life" points de vie
	 */
	public String reproduce() {
		String textReturn = "";
		this.setLife(-2);
		if(!this.checkLife()){
			if(this.health > 30 && this.hunger > 20) {
				this.setHealth(-30);
				this.setHunger(-20);
				textReturn = "La reproduction s'est bien passée"
									+ "\n\nVotre " + this.name + " a 30 points de santé en moins"
									+ "\n 2 points de vie en en moins et 20 points de faim en moins"
									+ "\nIl a maintenant " + this.hunger + " points de faim"
									+ "\nIl a maintenant " + this.health + " points de santé"
									+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				textReturn ="Votre " + this.name + " n'a pas les capacités pour se reproduire"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;	
	}
	
	 /**
	  * sleep health +3 and life -1
	  * @return Votre "this.name" n'a pas besoin de se reposer!
					<br>Il a maintenant "life" points de vie
					<br>or
					<br>Votre "name" s'est bien reposé
					<br><br>Votre "name" a 3 point de santé en plus
					<br>et 1 points de vie en moins
					<br>Il a maintenant "health" points de santé
				   <br>Il a maintenant "life" points de vie
	  */
	public String sleep() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.health == 50) {
				textReturn ="Votre " + this.name + " n'a pas besoin de se reposer!"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {	
				this.setHealth(3);
				textReturn = "Votre " + this.name + " s'est bien reposé"
						+ "\n\nVotre " + this.name + " a 3 point de santé en plus"
						+ "\net 1 points de vie en moins"
						+ "\nIl a maintenant " + this.health + " points de santé"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * Hair coloring life -1
	 * @param color the new hair color
	 * @return Votre "name" ne peux pas être roux !!!!
					<br>Il a maintenant "life" points de vie
					<br>or
					<br>Votre "name" à les cheveux "color" maintenant
					<br>Il a maintenant "life" points de vie
	 */
	public String hair(String color) {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(color.equals( "ROUX") || color.equals("roux") || color.equals("Roux")) {
				textReturn ="Votre " + this.name + " ne peux pas être roux !!!!"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				this.hairColor = color;
				textReturn ="Votre " + this.name + " à les cheveux " + color + " maintenant"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * go to the toilet health +5, life -1
	 * @return Votre "name" n'a pas besoin d'aller au toilette!
					 <br>Il a maintenant "life" points de vie
					<br> or
					 <br>Votre "name" est passé aux toilettes
					<br><br>Votre "name" a 5 point de santé en plus
					<br>et 1 points de vie en moins
					<br>Il a maintenant "health" points de santé
					<br>Il a maintenant "life" points de vie
	 */
	public String wc() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.health == 50) {
				textReturn ="Votre " + this.name + " n'a pas besoin d'aller au toilette!"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				this.setHealth(5);
				textReturn = "Votre " + this.name + " est passé aux toilettes"
						+ "\n\nVotre " + this.name + " a 5 point de santé en plus"
						+ "\net 1 points de vie en moins"
						+ "\nIl a maintenant " + this.health + " points de santé"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * the Tamagotchi meal hunger +5, life -1
	 * @return Votre "name" n'a pas faim !
					<br>Il a maintenant "life" points de vie
					<br>or
					<br>Votre "name" a bien mangé !
				    <br><br>Votre "name" a 5 point de faim en plus ! !
					<br>et 1 points de vie en moins
				    <br>Il a maintenant "hunger" points de faim
					<br>Il a maintenant "life" points de vie
	 */
	public String eat() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.hunger == 100) {
				textReturn ="Votre " + this.name + " n'a pas faim !"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				this.setHunger(5);
				textReturn = "Votre " + this.name + " a bien mangé !"
						+ "\nVotre " + this.name + " a 5 point de faim en plus ! !"
						+ "\net 1 points de vie en moins"
						+ "\nIl a maintenant " + this.hunger + " points de faim"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
	/**
	 * the attributes of Tamagotchi
	 * @return "Je suis "name"
						<br>Je suis né le "dateBirth"
						<br>Je suis de couleur "color"
						<br>Mes cheveux sont "hairColor"
						<br>Je mesure "size" m
						<br>
						<br>Ma santé est à "health" points
						<br>Mes points de vie sont à "life"
						<br>Mes points de faim sont à "hunger"
						<br>Je porte un masque or Je ne porte pas de masque
	 */
	public String showTamagotchi() {
		String textMask = this.mask ?"Je porte un masque" : "Je ne porte pas de masque";
		String text ="Je suis " + this.name + this.type
							+ "\nJe suis né le " + this.dateBirth
							+ "\nJe suis de couleur " + this.color
							+ "\nMes cheveux sont " + this.hairColor 
							+ "\nJe mesure " + this.size + "m"
							+ "\n"
							+ "\nMa santé est à " + this.health + " points"
							+ "\nMes points de vie sont à " + this.life
							+ "\nMes points de faim sont à " + this.hunger
							+ "\n" + textMask;
		return text;
	}
	
	/**
	 * Check the characteristics of life, hunger and health
	 * @return "name" est mort ! :(
	 * 					<br>or
	 * 					<br>La santé de "name" est critique !
	 * 					<br>or
	 * 					<br>Faire manger "name"
	 */
	protected boolean checkLife() {
		boolean end = false;
		if(this.life <= 0 || this.health <= 0) {
			System.out.println(this.name + " est mort ! :(");
			setMenu() ;
			 end = true;
		}
		else if ( this.health <= 10) {
			System.out.println("La santé de " + this.name + " est critique !");
		}
		else if(this.hunger <= 10) {
			System.out.println("Faire manger " + this.name);
		}
		return end;
	}
	
	
	
	//Getter and Setter
	/**
	 * the actions of Tamagotchi
	 * @return actions
	 */
	public String getFunctionList() {
		return this.actions;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health += health;
		if(this.health > 50) {
			this.health = 50;
		}
	}

	/**
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * @param hunger the hunger to set
	 */
	public void setHunger(int hunger) {
		this.hunger += hunger;
		if(this.hunger > 100) {
			this.hunger = 100;
		}
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @param life the life to set
	 */
	public void setLife(int life) {
		this.life += life;
	}

	/**
	 * @return the mask
	 */
	public boolean isMask() {
		return mask;
	}

	/**
	 * @param mask the mask to set
	 */
	public void setMask(boolean mask) {
		this.mask = mask;
	}

	/**
	 * @return the hairColor
	 */
	public String getHairColor() {
		return hairColor;
	}

	/**
	 * @param hairColor the hairColor to set
	 */
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	/**
	 * @return the dateBirth
	 */
	public String getDateBirth() {
		return dateBirth;
	}

	/**
	 * @param dateBirth the dateBirth to set
	 */
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the imageWhale
	 */
	public String getImageWhale() {
		return imageWhale;
	}

	/**
	 * @param imageWhale the imageWhale to set
	 */
	public void setImageWhale(String imageWhale) {
		this.imageWhale = imageWhale;
	}

	/**
	 * @return the actions
	 */
	public String getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}

	/**
	 * @return the imageTama
	 */
	public String getImageTama() {
		return imageTama;
	}

	/**
	 * @param imageTama the imageTama to set
	 */
	public void setImageTama(String imageTama) {
		this.imageTama = imageTama;
	}

	/**
	 * @return the typeTexte
	 */
	public String getTypeTexte() {
		return typeTexte;
	}

	/**
	 * @param typeTexte the typeTexte to set
	 */
	public void setTypeTexte(String typeTexte) {
		this.typeTexte = typeTexte;
	}

	

	

	
	
	
}
