Space Invaders - The Return of Jar-Jar Binks

Hópmeðlimir:	

Björn Sigurðsson - bjs45@hi.is
Halldór Vilhjálmsson - hav11@hi.is
Þorvaldur Gautsson - thg50@hi.is

--------------------

Athugasemdir:

Til þess að spila leikinn þarf að slá eftirfarandi skipun í skelinni >java Game

Leikurinn er spilaður með tökkunum LEFT, RIGHT og SPACE. Þegar leikurinn er keyrður þarf spilari að gefa upp nafn
sem er svo notað fyrir high scores lista.

Hópmeðlimir hafa tekið eftir því að leikurinn á það til að lagga á hægari tölvum. Ástæður þessa eru hljóðin sem 
eru keyrð með StdAudio; ef lína 42 ( StdAudio.loop("Prelude.mid"); ) er kommentuð út í Prelude.java og lína 146
( StdAudio.play("gunshot.wav"); ) og lína 169 ( StdAudio.play("LAZER.wav"); ) í Game.java keyrir leikurinn
vel á öllum þeim vélum sem hópmeðlimir hafa prófað hann á.

--------------------

Efirfarandi klasar voru skrifaðir:


Game:		

Þessi klasi er í raun miðja leiksins. Í þessum klasa má finna aðferðir sem stilla upp og spila leikinn.
Aðferðin initialize() stillir býr til og stillir upp leikmönnum. Aðferðin play() keyrir svokallaða game-lúppu
sem keyrir þangað til leikmaður hefur tapað. Í Game klasanum eru einnig aðferðir sem er kallað á í game-lúppunni.
Nefna má moveTieFighters() sem hreyfir alla eftirlifandi óvini og fightersFire() sem stjórnar því hvenær óvinir skjóta.

--------------------	

Xwing:		

Þessi klasi heldur utan um geimskip sem notandinn stýrir. Breyta af taginu Xwing hefur hnit (x,y), breidd, hæð, hraða, mynd
og Rectangle sem umlykur geimskipið (nýtist til þess að athuga árekstra við skot). Klasinn hefur einnig aðferðir til þess 
að hreyfa Xwing (þ.e. breyta um hnit), ná í Rectangle og til þess að athuga hvort hann sé enn á lífi.

--------------------	

TieFighter:	

Þessi klasi heldur utan um óvinageimskip. Breyta af taginu TieFighter hefur hnit (x,y), breidd, hæð, hraða, mynd, stefnu og
Rectangle. Klasinn hefur aðferðir til þess að hreyfa TieFighter, ná í Rectangle, ná í stefnu, breyta um stefnu, ná í x- og y-hnit,
og prenta TieFighter á skjáinn.	 

--------------------	

Prelude:	

Þessi klasi er í raun undanfari Game klasans. Í klasanum er fall sem spyr um nafn spilarans og skilar því svo frá sér.
Klasinn hefur einnig skipun um spil á lagi sem er spilað undir leiknum, birtir í örfáar sekúndur upplýsingar
um með hvaða lyklaborðstökkum leikurinn er spilaður og sýnir svo textasýningu a là Star Wars.

--------------------	

HighScores:	

Þessi klasi er eftirfari Game klasans og hefur þann tilgang að halda utan um High Scores lista. Þegar spilari deyr
er kallað á fallið Start() í þessum klasa, en það keyrir tvö föll; það fyrra setur nafn spilarans og skor hans á
high score listann ef hann komst þangað, og það síðara birtir svo listann.

--------------------	


Eftirfarandi klasar voru teknir af heimasíðu bókarinnar:


StdDraw:

Þessi klasi er notaður til þess að teikna skjámyndina ásamt því að lesa inn stöðu á tökkum.

--------------------

StdIn:

Þessi klasi er notaður til þess að lesa inn strengi úr skelinni.

--------------------

StdAudio:

Þessi klasi er notaður til þess að spila undirspilslagið (Star Wars þemað) á .mid formi, og hljóð þegar
spilari skýtur af byssu og þegar óvinir skjóta á móti spilara (bæði á .wav formi)

--------------------	

Stopwatch:

Þessi klasi er notaður í tímatöku í Prelude.java (til þess að birta myndina sem upplýsir um hvaða lyklaborðstakka
þarf að nota fyrir leikinn í bara ákveðinn tíma, og til þess að ákvarða hvenær fljótandi textinn birtist) og í
Game.java til þess að ákvarða hversu lengi "Next level" skjárinn birtist.

--------------------	

In:	

Þessi klasi er notaður til þess að lesa inntak úr tveimur .csv skrám. Í fallinu HighScoreScreen() í klasanum HighScores er 
In klasinn notaður til þess að lesa inn gildin í skránni Highscores.csv og þau svo birt á lista.

--------------------	

Out:

Þessi klasi er notaður til að skrifa út á tvær .csv skrár. Ef spilari hefur komist á high score lista er nafn hans skrifað 
í skrárnar, og ef ýtt er á lykilinn R á meðan high score listinn er á skjánum skrifast 10 línur með tómum streng fyrir gildi
nafns spilara og 0 fyrir skorið.

--------------------	


Eftirfarandi klasar voru teknir af vikublaði 10:


Interval:

Þessi klasi er notaður af Rectangle klasanum til þess að skilgreina bil á talnaás.

--------------------	

Point2D:

Þessi klasi er notaður af Rectangle klasanum til þess að skilgreina miðju rétthyrningsins.

--------------------	

Shape:

Rectangle erfir frá þessum klasa. Hann er þó lítið notaður þar sem einungis eru notaðir rétthyrningar. Með þessum klasa er auðveldlega
hægt að bæta við hringlaga hlutum í framtíðinni, svosem smástirnum. 

--------------------	

Rectangle:

Þessi klasi er notaður til þess að skilgreina form geimskipana. Hann er því notaður til þess að athuga hvort að árekstrar eigi sér stað.
