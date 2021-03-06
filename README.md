
#π‘μ€λ§νΈ μμ΄μ»¨μμ€ν 

**[π¦]**  
1μΈκ°κ΅¬ μ£Όκ±°κ³΅κ°μ μ¬λ¦μ²  μ¨μ΅λλ₯Ό IoT κΈ°κΈ°μ AWS μλΉμ€λ₯Ό μ΄μ©ν IoT ν΄λΌμ°λ νλ«νΌμ κ΅¬μΆνμ¬ μλμΌλ‘ μ μ΄νλ μμ€ν κ΅¬μΆ

___
## μ μ©λ AWS μλΉμ€ 
  <li>AWS IoT Core</li>
  <li>AWS Lambda</li>
  <li>Amazon DyanmoDB</li>
  <li>Amazon API Gateway</li>
  
## HW κ΅¬μ±
  <li>MKRWiFi1010 λ³΄λ</li>
  <li>SG90 μλ³΄λͺ¨ν° : D3 </li>
  <li>DHT11 μ¨λ μ΅λ μΌμ : D2</li>
  <li>TEMT6000 μ‘°λμΌμ : A1</li>
  
  ![image](https://user-images.githubusercontent.com/72599051/144745942-1e4392ea-9d46-4c16-b18a-196ae228a6a1.png)

  
___ 

## μλΉμ€ κ΅¬μ±λ
API Gatewayλ₯Ό ν΅ν΄ APIλ₯Ό νΈμΆνμ¬  μλλ‘μ΄λ appμμμ μ¬λ¬Όμ μνλ₯Ό νμΈ λ° μμ μ ν  μ μμ΅λλ€. 
λν Dynamodbμ μ μ₯νμ¬ μ¬λ¬Όμ λ‘κ·Έλ₯Ό μ‘°ννκ±°λ λμκ°μ λΆμν  μ μλ λ°μ΄ν°λ‘ μ¬μ©μ΄ κ°λ₯ν΄ μ§λλ€.
μλμκ°μ λ€μν AWSμ μλΉμ€λ€μ μ΄μ©νμ¬ μ¬λ¬Όμ μ’ λ νΈλ¦¬νκ³  μ½κ² λ€λ£° μ μκ² λ©λλ€.
![image](https://user-images.githubusercontent.com/72599051/143241035-e962d196-8519-418c-a038-5cf6dc6108d7.png)

___ 

## μλλ‘μ΄λ APP νλ©΄ μμ 
μΌμμ μν΄ μΈ‘μ λ κ°λ€μ AWSμμ mqtt ν΄λΌμ΄μΈνΈμ μν΄ κ΅¬λλμ΄μ Έμ κ΅¬μΆν΄λ REST API λ₯Ό ν΅ν΄ μ¬μ©μκ° APPμμμ νμΈ λ° μ¬λ¬Όμ μνλ₯Ό μ μ΄ν  μ μμ΅λλ€.
![image](https://user-images.githubusercontent.com/72599051/144988777-40561d91-c9ee-4e11-b669-2ac964e43a50.png)

___ 


## 1. REST API μ€κ³
λ€μ νλ‘κ·Έλ¨ μ½λλ₯Ό μ€νμν€κΈ° μν΄μλ λ€μ νμμ REST APIκ° μ€λΉλμ΄ μμ΄μΌ ν©λλ€.
- λλ°μ΄μ€ λ‘κ·Έ μ‘°ν 
```
 GET /devices/{deviceId}/log?from=yyyy-mm-dd hh:mm:ss&to=yyyy-mm-dd hh:mm:ss
```
- λλ°μ΄μ€ μν μ‘°ν : μ¨μ΅λ , μμ΄μ»¨ μν νμΈ(ON/OFF)
```
GET /devices/{deviceId}
```
- λλ°μ΄μ€ μν λ³κ²½ : μμ΄μ»¨ ON/OFF
```
 PUT /devices/{deviceId}
```
  <li>message body (payload)</li>
  ```
  { 
 	"tags" : [
 		{
 			"attrName": "temperature",
 			"attrValue": "27.0"
 		},
 		{
 			"attrName": "LED",
 			"attrValue": "OFF"
 		}
 	]
 }
```

### Prerequisites / μ ν μ‘°κ±΄


```
- Arduino IDE 
- Android Mobile Phone or Android Studio IDE + Emulater
- AWS Account 

μ°Έκ³ μ¬ν­ : 
- AWS IoT μ MKRWiFi1010 μ°κ²°λ°©λ² : https://kwanulee.github.io/AWS_IoT_DHT11/
- λλ°μ΄μ€ μλμ° μ¬μ©λ² : https://kwanulee.github.io/AWS_IoT_DHT11/device-shadows.html
- AWS IoT μ¬μ©λ² : https://kwanulee.github.io/AWS_IoT_DHT11/
- API Gateway μ¬μ©λ² : https://kwanulee.github.io/APIGatewayPractice/

```


## Running the tests / νμ€νΈμ μ€ν

( μ νμ‘°κ±΄μ΄ λ§μ‘±λμλ€κ³  κ°μ  )
1. μΌμ λ° λͺ¨ν°κ° μ°κ²°λ MKRWiFi1010 λ³΄λμ μ μμ κ³΅κΈ.
2. μλλ‘μ΄λ Appμ λ€μ΄λ‘λ νΉμ μλ?¬λ μ΄ν°λ‘ μ€ν.
3. μλλ‘μ΄λ Appμ ννλ μ¬λ¬Όμ μνλ₯Ό νμΈ λ° μ μ΄.


### νμ€νΈλ μ΄λ° μμΌλ‘ λμν©λλ€

```
μ μ  μ¨λ λ° μ΅λλ₯Ό λ²μ΄λλ©΄ μ€λ§νΈμμ€ν μνκ° ON μΌ κ²½μ°μ μ μ μ¨λ λ° μ΅λλ₯Ό μ μ§νκΈ° μν΄ μμ΄μ»¨ λ° μ μ΅κΈ°λ₯Ό μ μ΄κ°λ₯.
```
___ 

## μλμ΄λΈ μ½λ ν΅μ¬ flow  
![image](https://user-images.githubusercontent.com/72599051/144989300-7d5f013e-73c2-4334-b0f4-92b863ca6a8a.png)

___ 



## Built With / λκ΅¬λ λ§λ€μλμ?

* [1791320_μ΅μ’ν](https://github.com/TonyJHC) 
   1. μλλ‘μ΄λ APP κ°λ° β

       -  μ¨μ΅λ , μμ΄μ»¨ μν νμΈ  (μλ£)β

       -  μ€λ§νΈ μμ΄μ»¨ μμ€ν μ μ΄ (μλ£)β
     

   2.  AWS IoT ν΄λΌμ°λ νλ«νΌ κ΅¬μΆβ

       - GET : μ¨μ΅λ , μμ΄μ»¨ μν νμΈ   (μλ£)β

       - PUT : μ€λ§νΈ μμ΄μ»¨ μμ€ν μ μ΄  (μλ£)β

       - Dynamodb tableμ μ μ₯ (μλ£)β
      

   3. μλμ΄λΈ HW/SW κ°λ° β

       - μ¨μ΅λ , LED, μ‘°λμΌμ , μλ³΄λͺ¨ν° μ°κ²° λ° κΈ°λ³Έμ€μ (μλ£)β

       - APP μμ μ€λ§νΈ μμ΄μ»¨ μμ€ν μλ μ μ¬λ¬Όμ μνμ λ°λΌ μμ΄μ»¨ ON/OFF (μλ£)β


   4.  ppt μ μ λ° github κ΄λ¦¬ λ° read.me μμ±β


* [1771391 μ μ§λ§](https://github.com/jiman-you) - μμ λ΄μ©

   1. μλλ‘μ΄λ APP κ°λ°β

      -  λ‘κ·Έμ‘°ν νλ©΄ μ°λβ

   2.  AWS IoT ν΄λΌμ°λ νλ«νΌ κ΅¬μΆβ

       - λ‘κ·Έμ‘°ν νλ©΄ μ°λβ

       - SNSμ΄λ©μΌ μ°λβ

   3. μμ° λμμ μ΄¬μβ
      https://youtu.be/_r9dTBWbfAUβ
      

## Contributiong / κΈ°μ¬
   1. μλλ‘μ΄λ APP κ°λ° β

         -  [1791320 μ΅μ’ν] 

         ![image](https://user-images.githubusercontent.com/72599051/144746833-3f8a75c0-0d32-4cd3-aa9d-660eb0970a34.png)   



         -  [1771391 μ μ§λ§] 
          
         ![image](https://user-images.githubusercontent.com/72599051/144746687-d5807104-000e-490c-95b6-171c6c920afb.png)


   2.  AWS IoT ν΄λΌμ°λ νλ«νΌ κ΅¬μΆβ

         -  [1791320 μ΅μ’ν] 
        
          ![image](https://user-images.githubusercontent.com/72599051/144746754-36df46a4-048d-4c19-b56d-1b2648dbde3f.png)
  
      
         -  [1771391 μ μ§λ§] 
         
          ![image](https://user-images.githubusercontent.com/72599051/144746766-fc33e95a-3b14-4a52-83c2-4ca500f05f04.png) 


   3. μλμ΄λΈ HW/SW κ°λ° β

         -  [1791320 μ΅μ’ν] 
         
         ![image](https://user-images.githubusercontent.com/72599051/144746722-feed2e11-ab9b-4882-a2e0-555576392a09.png)


Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us. / [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) λ₯Ό μ½κ³  μ΄μ λ§μΆμ΄ pull request λ₯Ό ν΄μ£ΌμΈμ.

## License / λΌμ΄μΌμ€

This project is licensed under the MIT License - see the [LICENSE.md](https://gist.github.com/PurpleBooth/LICENSE.md) file for details / μ΄ νλ‘μ νΈλ MIT λΌμ΄μΌμ€λ‘ λΌμ΄μΌμ€κ° λΆμ¬λμ΄ μμ΅λλ€. μμΈν λ΄μ©μ LICENSE.md νμΌμ μ°Έκ³ νμΈμ.

