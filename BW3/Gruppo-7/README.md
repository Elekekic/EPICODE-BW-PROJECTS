
<div  align="center" >
 <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Angular_Logo_SVG.svg/2560px-Angular_Logo_SVG.svg.png" width="400" height="100" /> 

  This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.2.12. 
</div>


## Development server


- Esegui in terminale : `npm i json-server@0.17.4`,`npm i json-server-auth`, `npm i @auth0/angular-jwt`,  `npm i concurrently`
- Modificare la parte script del package json con questi comandi :
```
"scripts": {
    "ng": "ng",
    "start": "ng serve -o",
    "build": "ng build",
    "watch": "ng build --watch --configuration development",
    "test": "ng test",
    "backend": "json-server-auth --watch db.json --port 4201",
    "fullstack": "concurrently \"npm run backend\" \"npm run start\""
  },
  ```
- Poi: `npm run fullstack` 
- Naviga su: `http://localhost:4200/`.
- L'applicazione si ricaricherà automaticamente se modifichi qualsiasi cosa dai file sorgenti.


### Sono stati utilizzati:

> ![Static Badge](https://img.shields.io/badge/HTML-%23E34F26?style=for-the-badge&logo=html5&labelColor=black)  ![Static Badge](https://img.shields.io/badge/SCSS-%23CC6699?style=for-the-badge&logo=SASS&labelColor=black)
   ![Static Badge](https://img.shields.io/badge/Bootstrap-%237952B3?style=for-the-badge&logo=Bootstrap&labelColor=black)   ![Static Badge](https://img.shields.io/badge/TypeScript-%233178C6?style=for-the-badge&logo=typescript&labelColor=black)

<br> 

<h2 > Come funziona </h2>

 _1. SIGN UP_
 
![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/4a2e0e6a-803c-489a-894c-2c3f74bcd128)

<br>

<div >
  
La pagina sign up, dove l'utente si può registrare al nostro sito in modo da poter creare un account ed eventualmente postare quello che desidera.


</div>

<br>

 _2. LOGIN_
 
 ![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/a416ef77-6a01-4657-b728-7d08e606a8d3)


La login page, qui una volta che l'utente si è registrato può scegliere anche il colore che avrà il tema del sito.

![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/fd737d52-14d0-41b1-a538-a3ff9b9e0211)

> L'utente potrà sempre cambiare il suo colore al momento del Login


<br>

 _3. HOME_

![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/0435acc6-b2bc-4e00-8ccb-c3b98b0bd36b)

La home page, qui vengono visualizzati tutti i post fatti dagli utenti (sia loggati e sia non loggati)

<br>

![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/67b277e3-9d88-4911-95b7-e6b905fc1476)

> nella navbar c'è il button "crea post" dove l'utente loggato potrà pubblicare un post. 


<br>

 _4. EDIT POST_

![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/929826ad-06a0-41dc-9a6e-31c2056d614b)


La modale edit post, questa si apre dopo aver cliccato il button edit e permetterà di modificare il post selezionato. 
> - Chi non è admin può solo modificare i suoi post
> - Chi invece è admin può modificare i post di tutti oltre che al suo
> - Stessa cosa avviene con il button per eliminare


<br>

 _5. MORE POST_

![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/57bfaeb5-9ab1-432f-976a-9c4f272f536d)


La modale more, questa permette di vedere l'intero post (in caso contenesse più di 100 caratteri) in modo da poter leggere tutto
> Chi non è registrato/loggato non può vedere questo button


<br>

 _6. USERS LIST_

![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/f418e3c8-13e4-42d2-a2e2-f4edcedf0aab)


La modale users, dove si possono vedere tutti gli utenti loggati
> Visibile solo per chi ha il ruolo di admin


<br>

 _7. NOT ADMIN USER_


![immagine](https://github.com/Elekekic/EPICODE-BW-PROJECTS/assets/157897660/9bb7f4ef-f103-4627-9450-3417c8518d2c)


Questa rappresenta la schermata di chi non ha il ruolo admin ed ha fatto un semplice accesso.

## Collaboratori

| Membri | Github   |
| :---:   | :---: | 
| Elena Kekic | <a href="https://github.com/Elekekic"> ![Static Badge](https://img.shields.io/badge/Elena%20Kekic-%23e0a633?style=for-the-badge&logo=Github&logoColor=black&labelColor=white) </a>  |
| Martina Cretella | <a href="https://github.com/azakanaa"> ![Static Badge](https://img.shields.io/badge/Martina%20Cretella-%23EA4AAA?style=for-the-badge&logo=Github&logoColor=black&labelColor=white) </a>   |
| Lucian Oprica | <a href="https://github.com/OpricaLucianAndrei"> ![Static Badge](https://img.shields.io/badge/Lucian%20Oprica-%237c10d3?style=for-the-badge&logo=Github&logoColor=black&labelColor=white) </a>   |
| Massimo Berligeri | <a href="https://github.com/Max2002-code"> ![Static Badge](https://img.shields.io/badge/Massimo%20Berlingeri-%23E60012?style=for-the-badge&logo=Github&logoColor=black&labelColor=white) </a>|
| Felice Cesarano | <a href="https://github.com/felicecesarano"> ![Static Badge](https://img.shields.io/badge/Felice%20Cesarano-%233C4211?style=for-the-badge&logo=Github&logoColor=black&labelColor=white) </a>  |

[Torna su!](#development-server)
