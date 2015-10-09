Space Invaders - The Return of Jar-Jar Binks

H�pme�limir:	

Bj�rn Sigur�sson - bjs45@hi.is
Halld�r Vilhj�lmsson - hav11@hi.is
�orvaldur Gautsson - thg50@hi.is

--------------------

Athugasemdir:

Til �ess a� spila leikinn �arf a� sl� eftirfarandi skipun � skelinni >java Game

Leikurinn er spila�ur me� t�kkunum LEFT, RIGHT og SPACE. �egar leikurinn er keyr�ur �arf spilari a� gefa upp nafn
sem er svo nota� fyrir high scores lista.

H�pme�limir hafa teki� eftir �v� a� leikurinn � �a� til a� lagga � h�gari t�lvum. �st��ur �essa eru hlj��in sem 
eru keyr� me� StdAudio; ef l�na 42 ( StdAudio.loop("Prelude.mid"); ) er kommentu� �t � Prelude.java og l�na 146
( StdAudio.play("gunshot.wav"); ) og l�na 169 ( StdAudio.play("LAZER.wav"); ) � Game.java keyrir leikurinn
vel � �llum �eim v�lum sem h�pme�limir hafa pr�fa� hann �.

--------------------

Efirfarandi klasar voru skrifa�ir:


Game:		

�essi klasi er � raun mi�ja leiksins. � �essum klasa m� finna a�fer�ir sem stilla upp og spila leikinn.
A�fer�in initialize() stillir b�r til og stillir upp leikm�nnum. A�fer�in play() keyrir svokalla�a game-l�ppu
sem keyrir �anga� til leikma�ur hefur tapa�. � Game klasanum eru einnig a�fer�ir sem er kalla� � � game-l�ppunni.
Nefna m� moveTieFighters() sem hreyfir alla eftirlifandi �vini og fightersFire() sem stj�rnar �v� hven�r �vinir skj�ta.

--------------------	

Xwing:		

�essi klasi heldur utan um geimskip sem notandinn st�rir. Breyta af taginu Xwing hefur hnit (x,y), breidd, h��, hra�a, mynd
og Rectangle sem umlykur geimskipi� (n�tist til �ess a� athuga �rekstra vi� skot). Klasinn hefur einnig a�fer�ir til �ess 
a� hreyfa Xwing (�.e. breyta um hnit), n� � Rectangle og til �ess a� athuga hvort hann s� enn � l�fi.

--------------------	

TieFighter:	

�essi klasi heldur utan um �vinageimskip. Breyta af taginu TieFighter hefur hnit (x,y), breidd, h��, hra�a, mynd, stefnu og
Rectangle. Klasinn hefur a�fer�ir til �ess a� hreyfa TieFighter, n� � Rectangle, n� � stefnu, breyta um stefnu, n� � x- og y-hnit,
og prenta TieFighter � skj�inn.	 

--------------------	

Prelude:	

�essi klasi er � raun undanfari Game klasans. � klasanum er fall sem spyr um nafn spilarans og skilar �v� svo fr� s�r.
Klasinn hefur einnig skipun um spil � lagi sem er spila� undir leiknum, birtir � �rf�ar sek�ndur uppl�singar
um me� hva�a lyklabor�st�kkum leikurinn er spila�ur og s�nir svo textas�ningu a l� Star Wars.

--------------------	

HighScores:	

�essi klasi er eftirfari Game klasans og hefur �ann tilgang a� halda utan um High Scores lista. �egar spilari deyr
er kalla� � falli� Start() � �essum klasa, en �a� keyrir tv� f�ll; �a� fyrra setur nafn spilarans og skor hans �
high score listann ef hann komst �anga�, og �a� s��ara birtir svo listann.

--------------------	


Eftirfarandi klasar voru teknir af heimas��u b�karinnar:


StdDraw:

�essi klasi er nota�ur til �ess a� teikna skj�myndina �samt �v� a� lesa inn st��u � t�kkum.

--------------------

StdIn:

�essi klasi er nota�ur til �ess a� lesa inn strengi �r skelinni.

--------------------

StdAudio:

�essi klasi er nota�ur til �ess a� spila undirspilslagi� (Star Wars �ema�) � .mid formi, og hlj�� �egar
spilari sk�tur af byssu og �egar �vinir skj�ta � m�ti spilara (b��i � .wav formi)

--------------------	

Stopwatch:

�essi klasi er nota�ur � t�mat�ku � Prelude.java (til �ess a� birta myndina sem uppl�sir um hva�a lyklabor�stakka
�arf a� nota fyrir leikinn � bara �kve�inn t�ma, og til �ess a� �kvar�a hven�r flj�tandi textinn birtist) og �
Game.java til �ess a� �kvar�a hversu lengi "Next level" skj�rinn birtist.

--------------------	

In:	

�essi klasi er nota�ur til �ess a� lesa inntak �r tveimur .csv skr�m. � fallinu HighScoreScreen() � klasanum HighScores er 
In klasinn nota�ur til �ess a� lesa inn gildin � skr�nni Highscores.csv og �au svo birt � lista.

--------------------	

Out:

�essi klasi er nota�ur til a� skrifa �t � tv�r .csv skr�r. Ef spilari hefur komist � high score lista er nafn hans skrifa� 
� skr�rnar, og ef �tt er � lykilinn R � me�an high score listinn er � skj�num skrifast 10 l�nur me� t�mum streng fyrir gildi
nafns spilara og 0 fyrir skori�.

--------------------	


Eftirfarandi klasar voru teknir af vikubla�i 10:


Interval:

�essi klasi er nota�ur af Rectangle klasanum til �ess a� skilgreina bil � talna�s.

--------------------	

Point2D:

�essi klasi er nota�ur af Rectangle klasanum til �ess a� skilgreina mi�ju r�tthyrningsins.

--------------------	

Shape:

Rectangle erfir fr� �essum klasa. Hann er �� l�ti� nota�ur �ar sem einungis eru nota�ir r�tthyrningar. Me� �essum klasa er au�veldlega
h�gt a� b�ta vi� hringlaga hlutum � framt��inni, svosem sm�stirnum. 

--------------------	

Rectangle:

�essi klasi er nota�ur til �ess a� skilgreina form geimskipana. Hann er �v� nota�ur til �ess a� athuga hvort a� �rekstrar eigi s�r sta�.
