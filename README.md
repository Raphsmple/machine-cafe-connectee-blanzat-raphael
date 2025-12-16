# Machine à café connectée

TP de programmation Java.

La machine à café est autonome :
- elle gère ses stocks
- elle encaisse l'argent
- elle peut tomber en panne si elle n'est pas entretenue

## Fonctionnement

La machine possède :
- un stock d'eau, de grains et de gobelets
- un compteur de cafés servis (usure)
- un système de crédit et de caisse

Deux boissons sont disponibles :
- Café court (1,50 €)
- Café long (2,00 €)

Après 5 cafés servis, la machine se bloque et doit être détartrée via le menu technicien.

## Menu
- Insérer de la monnaie
- Commander un café
- Menu technicien :
  - Recharger les stocks
  - Détartrer la machine
  - Récupérer l'argent
- Quitter

## Lancement du programme

Compilation :
javac src/*.java
