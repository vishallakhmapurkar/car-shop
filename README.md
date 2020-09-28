# car-shop
this is car shop example with angular 10 and spring boot api

#Start API 
#Tech - java 8 spring boot 2.x , gradle 

#run below command from command prompt . Note java 8 should installed 
java -jar build/libs/franks-carshop-api-1.0.jar


#API URl 

Note - below api is created based on mock api 
https://api.jsonbin.io/b/5ebe673947a2266b1478d892

http://localhost:9987/car-api/allcarsbydateadded

#Response:
[
{
"id": 55,
"warehousename": "Warehouse C",
"lat": "39.12788",
"lng": "39.12788",
"location": "Suid wing",
"make": "Volvo",
"model": "850",
"yearModel": 1995,
"price": 25762.080078125,
"licensed": true,
"dateAdded": "2017-10-03T00:00:00.000+00:00"
},
{
"id": 22,
"warehousename": "Warehouse B",
"lat": "15.95386",
"lng": "15.95386",
"location": "East wing",
"make": "Infiniti",
"model": "I",
"yearModel": 2002,
"price": 6910.16015625,
"licensed": false,
"dateAdded": "2017-10-15T00:00:00.000+00:00"
},
{
"id": 52,
"warehousename": "Warehouse C",
"lat": "39.12788",
"lng": "39.12788",
"location": "Suid wing",
"make": "Porsche",
"model": "Cayenne",
"yearModel": 2011,
"price": 17066.310546875,
"licensed": true,
"dateAdded": "2017-10-19T00:00:00.000+00:00"
},



#Front End 

UI is done in angular 10 and using API mentioned above

http://localhost:9986/dist/franks-car-shop-app

