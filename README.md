## description
Cet outil permettra  aux étudiants de rapidement retrouver les devoirs et examens des années précédentes afin de s'y préparer en conséquence. les documents seront classés par catégorie (classe, année, filière), l'outil possèdera toutes les fonctionnalités nécessaire aux opérations CRUD (ajout, lecture, modification, suppression) et sera doté d'un système de gestion des utilisateurs: avec l'admin en tant qu'utilisateur suprême chargé d'ajouter et de supprimer des comptes utilisateurs (simples et archivistes), les archivistes qui se chargeront de l'ajout, la suppression, la modification des documents et des utilisateurs lambda qui eux ne pourront que consulter et télécharger ces documents.

## profiles utilisateurs
- Admin 
- Archiviste 
- etudiant

## liste des fonctionnalités par profile
-Admin
*signup
*login
*creer un archiviste (par defaut tous les autres profiles sont etudiants mais l'admin se charge d'accorder les droits d'archiviste à qui il veut)
*supprimer un archiviste
*creer un document
*consulter un document
*modifier un document
*supprimer un document

Archiviste
*signup
*login
*creer un document
*consulter un document
*modifier un document
*supprimer un document

-Etudiant
*signup
*login
*consulter un document

##documentation d'utilisattion

compiler l'AppDocuments et l'AppUsers séparement pour obtenir 
un menu different pour la manipulation des documents et des
utilusateurs, puis entrez votre choix selon le menu

là où l'id est demandé entrer un nombre compris entre 1 et 3
se refferer sur la base de donnée pour voir les contraintes
d'intégrité du document et de l'utilisateur

exemple 
faculté: 1 = genie logiciel, 2 = reseaux, 3 = reseaux telecom
format: 1 = png, 2 = jpg, 3 = pdf
type document: 1 = document scolaire, 2 = doc administartif
role_users: 1 = admin, 2 = archiviste, 3 = utilisateur

les formats de date sont considérés comme string pour le moment

