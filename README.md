# OPEN/CLOSE - Exemple & kata 

## Shapes
L'exemple sur les formes a pour but d'illustrer la différence entre un code respectant l'OCP et un 
ne le respectant pas.

Les classes *ocp_compliant* et *no_ocp* présentent chacun des cas.
Pour plus de détails, voir les supports de cours sur le drive.

## OCP DOJO
Pour la session pratique du 21 Février, nous utileserons le bowling kata.
Le kata est décrit par Uncle Bob [ici](http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt)


La contrainte de cette session est de coder le kata avec les règles de l'*OCP Dojo* de Matteo Vaccari présenté [ici](http://matteo.vaccari.name/blog/archives/293)


## Règles de l'OCP DOJO 

1. Ecrire un test non passant
2. Créer un factory (un aggrégat) qui fait passer le test
	- La factory ne doit pas posséder de conditionnel
3. Ecrire le prochain test non passant
4. Pouvez-vous faire passer ce test en changeant uniquement la factory et/ou en créant de nouvelles classes?

	A. Oui : Super! Retournez à l’étape 3 <br/>
	B. Non: Refactorez jusqu’à ce que cela devienne possible <br/> 

### Exemple avec le Bowling Kata
#### cas de test 1 : le Gutter Game 
    Nombre de lancées: 20 
    Score attendu : 0

    - Créer une instance de la classe *Game* en utilisant une *factory*.
    - Faire passer le cas de test
    - Ecrire le cas d'une quille touchée par lancée 

#### cas de test 2: 1 quille touchée par lancée
    Nombre de lancées: 20 
    Score attendu : 20
    
    - Ce test peut-il passer au vert en modifiant uniquement la factory?
    - Si oui:
        - Modifiez la factory et faites passer le test
        puis Ecrivez le prochain test non passant.
    - Si non, refactorez le code de façon à ne modifier que la factory.

Note: Pour tous les cas de tests voir [ici](http://codingdojo.org/kata/Bowling/) 

## Variations du Bowling kata

Pour varier les plaisirs, Matteo Vaccari, propose d'implémenter ces changements.
Vous pouvez pour cela reprendre le code existant dans le package `BowlingGame` du repo.

 

 


   
