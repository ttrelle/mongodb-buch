# Test-Daten #
Hier können Sie die Test-Daten herunterladen, die im Buch häufig verwenden. Zum Entpacken der Dateien können sie z.B. das kostenlose Tool [7-Zip](http://www.7-zip.de) verwenden.

## Twitter-Datenbank ##
In Kapitel 2 wird beschrieben, wie Sie eine Collection mit Tweets importieren. Die Daten können Sie als [gezippte BSON-Datei](tweets.zip?raw=true) (ca. 18MB) herunterladen, entpacken und danach importieren:
    
    $ mongorestore -d twitter -c tweets /pfad/zu/tweets.bson 

## Enron Mail-Datenbank ##
Zur Illustration von Map/Reduce wird ein öffentlich zugänglicher Auszug auf der Enron Mail-Datenbank verwendet, die Sie als [komprimierte BSON-Datei](http://mongodb-enron-email.s3-website-us-east-1.amazonaws.com/) herunterladen, entpacken und ebenfalls importierten können:

    $ mongorestore -d enron_mail /pfad/zum/archiv/dump/enron_mail 

