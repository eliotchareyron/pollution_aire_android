# pollution_aire_android

ce dépôt GitHub contient une application Android qui permet d'avoir l'indice de pollution d'une ville.
Elle permet aussi de rechercher des villes et afficher l'indice de pollution de ces villes.


# Ressources 
Pour avoir l'indice de pollution et le nom des villes nous utilisons l'api de AQI disponnible a l'adresse suivante :
<a href="http://aqicn.org/json-api/doc/#api-_"> lien  API AQI </a>  </br>
Cette Api nous fournis un Json comme par exemple celui ci-dessous : 
``` json
{
  "uid": 3028,
  "aqi": "30",
  "time": {
          "tz": "+0100",
          "stime": "2017-04-03 07:00:00",
          "vtime": 1491199200
        },
  "station": {
            "name": "Lyon Centre, France",
            "geo": [
                45.75779318439,
                4.854217317644
            ],
            "url": "france/rhonealpes/rhone/lyon-centre"
         }
}
```
 
 
 J'utilise l'Orm Sugar disponile a cette adresse : <a href="https://github.com/satyan/sugar/blob/master/README.md"> lien ORM Sugar </a>
 L'Orm Sugar permet de créer une base de donnée afin d'y stocker les favoris sélectionné par l'utilisateur.
 
    

## Author
- [Eliot Chareyron] (https://github.com/eliotchareyron)
