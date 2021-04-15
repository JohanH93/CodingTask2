
# Daimler TSS – Coding Task 2 | Johannes Holzmann

# Aufgabe
Ziel der Aufgabe war es, einen Algorithmus zu entwickeln der, ausgehend von einem 2D Integer Array mit sich potenziell überlappenden Intervallen, eine Liste mit Intervallen zurückgibt, in denen die sich überlappenden Intervalle zusammengefügt (merged) sind.

# Lösung
Die finale Version sortiert das erhaltene Array mit Intervallen zunächst aufsteigend nach dem unteren Intervallwert. „Null“ Werte innerhalb des erhaltenen Arrays werden an das Ende sortiert. Es wird eine neue LinkedList erstellt, in welche die zusammengefügten Intervalle eingefügt werden sollen. Anschließend wird über die Intervalle des Original Arrays iteriert. Falls der aktuelle Wert „null“ ist und somit der theoretische Bereich von „null“ Werten am Ende des sortierten Original Arrays erreicht ist, wird die Iteration abgebrochen. Falls noch kein Intervall in der LinkedList mit den zusammengefügten Intervallen ist, wird das aktuell betrachtete Intervall eingefügt. Falls das untere Limit des aktuell betrachteten Intervalls größer ist als das obere Limit des letzten zusammengefügten Intervalls überlappen diese nicht. Aufgrund der Sortierung können auch keine darauffolgenden Intervalle des Original Arrays mit dem letzten zusammengefügten Intervall überlappen. Auch in diesem Fall wird das aktuell betrachtete Intervall der Liste mit zusammengefügten Intervallen hinzugefügt. Treffen diese beiden Fälle nicht zu überlappen die Intervalle. In diesem Fall wird geprüft, ob das obere Limit des letzten zusammengefügten Intervalls oder des aktuell betrachteten aus dem Original Array größer sind. Der größere der beiden Werte wird als das obere Limit des zusammengefügten Intervalls gesetzt. Nachdem über alle Intervalle des Original Arrays iteriert wurde wird die erhaltene LinkedList mit den zusammengefügten Intervallen zu einem Array konvertiert und von der Methode zurückgegeben.

# Effizienz
Die Laufzeitkomplexität für das Iterieren über das sortierte Original Array beträgt O(n). Allerdings muss das Array vorher sortiert werden. Die Laufzeitkomplexität des verwendeten Sortieralgorithmus beträgt O(n log n), welche somit dominierend ist. Es wurde eine LinkedList als Datenstruktur für die zusammengefügten Elemente gewählt. Die Speicherkomplexität hierfür beträgt O(n). Die Laufzeitkomplexität für die beiden benötigten Operationen, Hinzufügen am Ende der LinkedList und Abrufen des letzten Elements, betragen jeweils O(1). Als Vergleich kann das Hinzufügen eines Elementes an eine ArrayList im schlechtesten Fall O(n) betragen, da das zugrundeliegende Array vergrößert und die Werte kopiert werden müssen. Allerdings haben LinkedLists einen höheren Speicherbedarf pro Datenelement als ArrayLists. Alternativ könnte eine ArrayList genutzt werden deren Größe direkt im Bereich der ursprünglichen Intervallliste definiert wird. Allerdings braucht die ArrayList in diesem Fall so viel Speicher wie für die Größe zugewiesen ist, unabhängig davon, ob diese Elemente gefüllt werden oder nicht, was bei vielen sich überschneidenden Intervallen unnötigen Speicherplatz belegt. 

Die Robustheit des Codes bei großen Eingabemengen kann durch eine möglichst effiziente Implementierung hinsichtlich Laufzeitkomplexität und Speicherkomplexität optimiert werden. Für eine möglichst hohe Robustheit sollte die Funktion auch gegen fehlerhafte Eingabeparameter wie „null“ Werte für Intervallarrays geschützt sein. Dies erfolgt durch den Umgang mit null Werten in der Sortierfunktion und im Schleifenabbruch, wenn der Bereich der null Werte erreicht wird. 

# Implementierung
Die Lösung ist in Java implementiert und kann mittels Maven gebaut werden. Die Klasse MergeIntervalsSolution enthält die Methode merge, welche ein 2D Integer Array entgegennimmt und ein zusammengefügtes 2D Integer Array zurückgibt. In der Main Methode wird die Funktion auf das in der Aufgabenstellung genannte Beispiel angewandt und das Ergebnis ausgegeben. Zudem sind in der Klasse MergeIntervallsTest mehrere Unit Tests definiert. Ein mittels Maven erzeugtes .jar file befindet sich in /target. 

Die Bearbeitungszeit betrug ca. einen Tag.
