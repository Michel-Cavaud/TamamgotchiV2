## **Projet Tamagotchi Michel CAVAUD CDA 2020 - 2021 GRETA Montpellier**

**Version 2 du projet (voir version 1 [ICI](https://github.com/Michel-Cavaud/Tamamgotchi))**

**Historique du projet**
Une première version du Tamagotchi a été réalisé, en utilisant les objets en JAVA et répondre aux actions et caractéristiques suivantes.
- action : manger  
- action : aller au toilette  
- action : se teindre les cheveux, mais en roux  
- action : se reposer  
- caractéristique : couleur  
- action : se reproduire  
- action : exprimer son humeur ex : sauter de joie  
- action : voir des amis  
- caractéristique : santé, ex : s'il fume sa santé diminue, et sa faim augmente.  
- action : Faire du sport : augmente la santé  
- action : mourir  
- caractéristique : taille ( en cm ou en mètre )  
- action : il peut enlever le masque ( caractéristique : masqué ou non )  
- caractéristique : espérance de vie  
- action : se laver  
**Bonus :**  
- Caractéristique : Nom  
- Action : Choisir un type ( Tamagotchi de type chien / Chat ... Dragon ) à la création.

Chaque Tamagotchi a été « corrigé » par trois autres stagiaires de la formation. Et à partir de là j’ai fait une 2ème version en tenant compte des remarques des corrections et en utilisant des class différentes pour chaque type de Tamagotchi. Chaque type de Tamagotchi (les enfants) héritant d’une class Tamagotchi générique (le parent).

**Travail sur la version 2**

 - Copie de la version 1 dans un nouveau projet Eclipse et Github
 - La class Tamagotchi est transformée en class « abstract » afin de ne
   pas pouvoir être utilisée directement. Il faudra passer par une class
   enfant pour utiliser cette class.
 - Toutes les variables utilisées dans les autres class enfants sont
   écrites dans la class Tamagotchi avec leur getter et setter.
 - La méthode setMenu() devient une class abstract car elle doit exister
   dans chaque class enfant.
 - La class « specificShoutAction() »devient abstract pour être
   créer dans chaque class enfant.
 - Une class « TamaTama » est créée pour pouvoir avoir un type de
   Tamagotchi simple.
 - La class mainScript est réécrite afin de pouvoir créer suite au choix
   de l’utilisateur chaque sorte de Tamagotchi par la création de la
   class enfant correspondante.
 - Quelques corrections dans le fichier mainScript pour modifier le jeu
   suite aux retours des correcteurs de la version 1

**Les améliorations à prévoir :**
Pour l’expérience utilisateur il est difficile de jouer au Tamagotchi dans la console. Même en ajoutant des lignes dans la console pour une meilleure lisibilité, suivant la taille de la console le rendu n’est pas assez satisfaisant. La prochaine version devra avoir un affichage en fenêtre pour une meilleur expérience utilisateur.

![Diagramme de class](https://github.com/Michel-Cavaud/TamamgotchiV2/raw/master/Images/Diagramme%20de%20class%20Tamagotchi%20V2.png)
