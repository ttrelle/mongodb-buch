# Java Beispiele #
Hier finden Sie die Programmierbeispiele in Java aus dem Buch [MongoDB - Ein praktischer Einstieg](../	).

Die Beispiele können mittels des Build-Tools [Maven](http://maven.apache.org/) gebaut werden ...

	mvn clean compile

... und haben Abhängigkeiten zum [Java-Treiber für MongoDB](https://github.com/mongodb/mongo-java-driver) und dem O/D-Mapper [Jongo](http://www.jongo.org). 

Wenn Sie mit einer IDE wie z.B. [Eclipse IDE](http://www.eclipse.org/downloads/) arbeiten, können Sie die Projekt-Dateien mittels

	mvn eclipse:eclipse

erzeugen lassen.

Darüber hinaus benötigen Sie eine MongoDB-Instanz, die unter <code>localhost:27017</code> läuft.

Ggfs. müssen Sie für einige Beispiele auch erst die [Testdaten](../data/README.md) importieren.

Viel Spass beim Ausprobieren!

## Object/Document-Mapper ##

Ausführliche Beispiele zu Object/Document-Mappern, die im Buch leider nur kurz gestreift wurden, finden Sie in den folgenden Repositories:

- [Spring Data MongoDB](https://github.com/ttrelle/spring-data-examples/tree/master/springdata-mongodb)
- [Morphia](https://github.com/ttrelle/morphia-mongodb-examples)
- [Jongo](https://github.com/ttrelle/jongo-examples)
- [Hibernate OGM](https://github.com/ttrelle/hibernate-ogm-examples)
