# TicTacToe

Ook de app van deze week kan zowel in portrait als in landscape modus worden gebruikt.

titleClicked in de MainActivity krijgt dmv een switch de row en column waarde van de aangeklikte tile 
op het board. Deze wordt wordt vervolgens meegegeven aan de choose method van Game.java, die controleert of de 
aangeklikte tile blanco iss en veranderd kan worden of niet. choose returnt de (nieuwe) waarde van de aangeklikte tile.
In tileClicked wordt hier de juiste verandering van de text op de tile gedaan afhankelijk van wat choose heeft gereturnd.
Nu wordt er gecheckt of iemand gewonnen heeft, of dat het gelijkspel (draw) is adhv de won method in Game.

De won method checkt hoe vaak de zojuist aangeklikte tile in die rij, in die kolom en in de diagonalen voorkomt,
krijgt een hiervan de waarde 3 dan heeft de speler die bij de tile state hoort gewonnen. Is movesPlayed 9 dan 
zit het bord vol en is het gelijkspel. 

De screenshots zitten in de file genaamd doc.odt.
