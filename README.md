Conception & développement d’un module logiciel de gestion des inscriptions d’une solution d'échange de
prestations de services comportant une fonction d’ajout d’un membre de type "tradesman".
\
Détail de la cinématique fonctionnelle :
- Apply for membership (faire une demande d'adhésion)
- Verify Application
    - Not Valid : Error
    - Valid :
        - Process Payment
        - Approve Tradesman (artisan) / contractor (entrepreneur)
    
\
Conception & développement d’un module logiciel de gestion des inscriptions d’une solution e-commerce,
comportant une fonction d’ajout d’un membre.
\
- Respect des patterns logiciels et des concepts objets :
    * pattern Value Object
    * pattern Entity (met en relation des objets dépendants persistants entre eux, la stratégie (façon de mettre en 
      oeuvre l'entité composite) mise en place peut changer sans influer sur les objets dépendants),
    * pattern Repository,
    * pattern strategy (rendre des méthodes interchangeables par encapsulation),
    * utilisation de l'injection de dépendances
    * etc
- Favoriser une approche modulaire du code en gardant un maximum d'options le plus longtemps
  possible
- Favoriser le polymorphisme
- Respecter l’intention métier dans le code.
- Utiliser des objets Stubs ou Dummy
- Justifier certains critères de qualité si besoin.
