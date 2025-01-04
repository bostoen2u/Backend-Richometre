Richomètre – Gestion de Portefeuille

Bienvenue dans l’application Richomètre !

Notre application permet d’ajouter vos différentes positions (nom, quantité, prix d’achat, etc.). De suivre le cours du jour ainsi que vos plus-value ou moins-value.
Un indicateur est disponible sur notre page d'accueil, il estime votre « niveau de richesse » global.

1. Partie Frontend

   Fonctionnalités :
        Pages dédiées pour les Actions et les Cryptos (ajout, affichage, calcul de valeur totale)
        Formulaires pour créer de nouvelles transactions
        Page d'accueil indique un message selon votre montant total
        Login et Register : Pour se connecter ou créer un compte


2. Partie Backend

    Fonctionnalités :
        Gestion des transactions : Endpoint /portefeuille pour créer et récupérer les actions/crypto
        Services : Calcul de cours du jour via l'API Alpha Vantage (gratuite donc limité). Nous avons quelque soucis avec cette API,
           dans le cas ou la rêquete n'abouti pas nous simulons le cours du jour (valeur au hasard).


4. Comment lancer l’application

    Backend :
        Cloner le repo du backend : 
        Exécuter sprint boot depuis votre ide
        Le serveur tourne sur http://localhost:8080

    Frontend :
        Cloner le repo du frontend :
        Lancer l’application : npm run dev
        L’application tourne sur http://localhost:3000
