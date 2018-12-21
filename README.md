# TTS/DevOps Bootcamp - Team Project 01
## The Spoon
A Recipe Sharing Web App
## Team Members
- David Keith
- Sam Moore
- [Ben Nowak](https://bennowak.github.io)
## Overview
This project was an exercise in both teamwork and fundamentals of application programming in Java using Spring Boot, Thymeleaf, and the Java Persistence API (JPA).  Team DSB was tasked with designing and developing a working CRUD web application that exhibited basic functionality common to database operation.
### Project Choise
We chose a recipe sharing app because the team agreed it was a great way to explore and put into practice the skills in Java, templating, MVC archtecture, and CRUD.
... and we were hungry!
### Tech Stack Detials
- Java/SpringBoot/Thymeleaf/JPA
- HTML5/CSS
- Bootstrap
- JavaScript
- Maven
- H2
### Developemnt Environment Details
- Eclipse / Spring Tools Suite
- IntelliJ
- VSCode
- Postman
### Areas for Future Development
- User authentication and security
- Image upload
- Dynamically generated list form for multi-part inputs (ie: recipe ingredients and preparation steps)
- Dual datasource utilization (MySQL and MongoDB)
- Session tracking and user tokenization
## Data Models and Attributes
### Recipe (id, user, title, imgURL, [{ingredients}, ...], [steps, ...])
- user : matching the user who submitted the recipe
- title : title of the recipe
- imgURL : URL pointing to the image
- [{ingredients}] : A list of JSON objects that include ingredient properties
   - "name" : name of the ingredient
   - "notes" : specific or extra info about the ingredient
   - "amount" : quantity of units of the ingredient
   - "units" : unit of measurement of the ingredient
- [steps] : A list of the steps to preparing the recipe
### SiteUser (id, username, email, firstName, lastName, hash, token, agree)
- username : unique username
- email : user's email address
- firstName : first name
- lastName : user's last name
- hash : stored hash of the user's password
- token : stored authorization token to track session and expire authoriztions
- agree : boolean indicating whether user agreed that `ALL YOUR BASE ARE BLONG TO US` ;)
## Aknowledgements
Team DSB would like to thank [Tech Talent South](https://www.techtalentsouth.com) and [Cognizant](https://www.cognizant.com) for comming together to give us the great opportunity to learn and grow.  We also want to thank our istructors [Eric Shwartz](https://github.com/erics273) and [Leslie Alvarado](https://github.com/lealvarado) for guiding us to this poing.  We look forward to what the following weeks and months bring.
