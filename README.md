# 1. Hello Spring

## Welcome Page

![image](https://user-images.githubusercontent.com/76544061/150881346-6a321e3a-43ae-43b8-a794-9126e8a95abb.png)

static/index.html is considered a static view file in Spring


![image](https://user-images.githubusercontent.com/76544061/150881302-09a666ec-212c-4408-a9be-30d278e9dd90.png)

![image](https://user-images.githubusercontent.com/76544061/150881395-280eba35-806b-4a2b-8ae1-4fd9c7ce8149.png)

HelloController returns "hello" in String, then, viewResolver will find "hello.html"

![image](https://user-images.githubusercontent.com/76544061/150882126-9ca5be0e-46c0-4515-ad94-64993e88cd0e.png)

# Web Development

Static, MVC, API.

## MVC
Model, View, Controller.
The key of MVC is that manage seperately data(model), frontend side(view) and backend side (controller -> business logic). <br>
<img width="629" alt="Screen Shot 2022-01-24 at 7 35 57 PM" src="https://user-images.githubusercontent.com/76544061/150888542-491dd512-9382-422c-accd-e3aebe9b1b75.png">

<img width="612" alt="Screen Shot 2022-01-24 at 7 35 18 PM" src="https://user-images.githubusercontent.com/76544061/150888468-26ab1b86-7711-49d7-9177-7a88ced15d43.png">

From https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm


## Parameter binding
Taking a parameter from web browser and change the view point <br>

<img width="614" alt="Screen Shot 2022-01-24 at 7 26 55 PM" src="https://user-images.githubusercontent.com/76544061/150887706-1e2e4014-a97f-423a-b125-c89aa5e0bfc6.png">
<img width="466" alt="Screen Shot 2022-01-24 at 7 26 16 PM" src="https://user-images.githubusercontent.com/76544061/150887825-889f62e2-e602-4977-a842-f053a8a1b50e.png">

## API
Spring returns data, not a template or HTML file. Spring returns an object to client in JSON <br>
The data is being converted by HttpMessageConverter, such as JsonConverter, StringConverter, instead of viewResolver <br>
HTTP response body contains the data.

<img width="576" alt="Screen Shot 2022-01-24 at 9 13 04 PM" src="https://user-images.githubusercontent.com/76544061/150898212-ebd6d27d-230c-4a21-925f-aa5cd5023e79.png">
<img width="437" alt="Screen Shot 2022-01-24 at 9 12 46 PM" src="https://user-images.githubusercontent.com/76544061/150898219-ba7577b8-1645-45c7-ab37-8901a9bf377a.png">

# 2. Developing member management system
  * Business requirement : Data - name, ID / Funtionality - signup, find ID / Database -  Local DB  
  * Required implementation of an interface for repository in order to simply switch the project's database in the future. 

## Basic Web Application Architecture
  * Controller - web MVC's controller
  * Service - core business logic
  * Repository - accessing Database, manage domain object
  * Domain - business domain object (ex) member, order
### Domain - Member class definition
![image](https://user-images.githubusercontent.com/76544061/153896669-d4d08c8d-8ad3-48a9-9526-19f62d596657.png)
### Repository Interface 
![image](https://user-images.githubusercontent.com/76544061/153896786-fedadc19-29f6-4977-8eb5-ca74b8eaf985.png)
### Testing Member Respository
Testing join(), duplicatedMember() <br>
![image](https://user-images.githubusercontent.com/76544061/153900438-f4c005f9-04dc-407b-926d-8fbedc20ef11.png)
![image](https://user-images.githubusercontent.com/76544061/153899945-6125df3f-627b-4ea6-928a-f6d832c1d4b4.png)

### Member Service 
![image](https://user-images.githubusercontent.com/76544061/153900954-78686ee7-04ea-4f58-b426-cd7c4cff3386.png)

### Member Controller : This controller needs to be depended to MemberService
![image](https://user-images.githubusercontent.com/76544061/153902363-f6255a77-b96d-4e96-ae22-bfefb19a53e1.png)

## 2 ways for Dependency Injection
1. Component Scan : Spring automatically registers classes having @Controller, @Service, @Respository annotations. <br>
2. Registering a bean manually : Use SpringConfig class <br>
![image](https://user-images.githubusercontent.com/76544061/153903191-e5a332f9-1f63-4dfb-8033-d050d5a9d49d.png)

### GET and POST mapping - Assigning HTTP end point to provide contents
![image](https://user-images.githubusercontent.com/76544061/153906021-240a4d13-111e-4d9c-81c7-afe15f3ce118.png)

## Spring Data accessing 
1. H2 
2. JDBC & JDBC template
3. JPA & Spring Data JPA
