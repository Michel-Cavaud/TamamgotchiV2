package tamagotchiv2;

public class DragonTama extends Tamagotchi {

	public DragonTama(String name, String color, String hairColor) {
		super(name, color, hairColor);
		
		this.size = 4.12; 
		this.life = 150;
		this.typeTexte = " ,  je suis un dragon";
		this.type = "Dragon";
		this.imageTama = "                                                   /===-_---~~~~~~~~~------____"
				+"\n                                                |===-~___                _,-'"
				+"\n                 -==\\                         `//~\\   ~~~~`---.___.-~~"
				+"\n             ______-==|                         | |  \\           _-~`"
				+"\n       __--~~~  ,-/-==\\                        | |   `\\        ,'"
				+"\n    _-~       /'    |  \\                      / /      \\      /"
				+"\n  .'        /       |   \\                   /' /        \\   /'"
				+"\n /  ____  /         |    \\`\\.__/-~~ ~ \\ _ _/'  /          \\/'"
				+"\n/-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`"
				+"\n                  \\_|      /        _)   ;  ),   __--~~"
				+"\n                    '~~--_/      _-~/-  / \\   '-~ \\"
				+"\n                   {\\__--_/}    / \\_>- )<__\\      \\"
				+"\n                   /'   (_/  _-~  | |__>--<__|      |"
				+"\n                  |0  0 _/) )-~     | |__>--<__|     |"
				+"\n                  / /~ ,_/       / /__>---<__/      |"
				+"\n                 o o _//        /-~_>---<__-~      /"
				+"\n                 (^(~          /~_>---<__-      _-~"
				+"\n                ,/|           /__>--<__/     _-~"
				+"\n             ,//('(          |__>--<__|     /                  .----_"
				+"\n           ( ( '))          |__>--<__|    |                 /' _---_~\\"
				+"\n         `-)) )) (           |__>--<__|    |               /'  /     ~\\`\\"
				+"\n        ,/,'//( (             \\__>--<__\\    \\            /'  //        ||"
				+"\n      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'"
				+"\n    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/"
				+"\n  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~"
				+"\n   ;'( ')/ ,)(                              ~~~~~~~~~~"
				+"\n  ' ') '( (/"
				+"\n    '   '  `";
		
		this.imageWhale = "         \":\""
				+"\n    ___:____     |\"\\/\"|"
				+"\n  ,'        `.    \\  /"
				+"\n  |  O        \\___/  |"
				+"\n~^~^~^~^~^~^~^~^~^~^~^~^~";
		
		this.setMenu(); //create all the actions of theTamagotchi that can be displayed by getFunctionList()
	}
	
	/**
	 * The dragon breathes fire life -1 health -10
	 * @return Votre "name" ne peut pas faire de feu !
				<br>Il a maintenant "life" points de vie
				<br>or
				<br>Votre "name" crache des flammes !
				<br>🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥
				<br>Votre "name" a 10 points de santé en moins ! !
				<br>et 1 points de vie en moins
				<br>Il a maintenant "health" points de santé
				<br>Il a maintenant "life" points de vie
	 */
	protected String specificShoutAction() {
		String textReturn = "";
		this.setLife(-1);
		if(!this.checkLife()){
			if(this.health < 30) {
				textReturn ="Votre " + this.name + " ne peut pas faire de feu ! Sa santé est trop basse"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}else {
				this.setHealth(-10);
				textReturn = "Votre " + this.name + " crache des flammes !"
						 + "\n" + "🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥 🔥"
						+ "\n\nVotre " + this.name + " a 10 points de santé en moins ! !"
						+ "\net 2 points de vie en moins"
						+ "\nIl a maintenant " + this.health + " points de santé"
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
					<br>Teindre les cheveux -- > 3
					<br>Se reposer -- > 4
					<br>Se reproduire -- > 5
					<br>Exprimer sa joie -- > 6
					<br>Voir ses amis -- > 7
					<br>Faire du sport -- > 8
					<br>Enlever son masque or  Mettre son masque --> 9
					<br>Se laver -- > 10
					<br>Fumer-- > 11
					<br>Se reproduire à deux -- > 12
					<br>Cracher du feu -- > 13
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
					+ "\nCracher du feu -- > 13"
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
				textReturn = "Votre " + this.name + " a bien mangé sa baleine !"
						 + "\n" + this.imageWhale
						+ "\n\nVotre " + this.name + " a 5 point de faim en plus ! !"
						+ "\net 1 points de vie en moins"
						+ "\nIl a maintenant " + this.hunger + " points de faim"
						+ "\nIl a maintenant " + this.life + " points de vie";
			}
		}
		return textReturn;
	}
	
}
