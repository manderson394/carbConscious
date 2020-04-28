# Matt Anderson's Individual Project - CarbConscious

This repository contains information and code for the CarbConscious web application.

### Problem Statement
Every day, people with diabetes must carefully balance diet and exercise together with their natural body chemistry to manage insufficient insulin production. 
Without sufficient insulin, a person's blood sugar can rise to dangerous levels, resulting in acute conditions such as nausea, dizziness, and fainting or chronic illnesses like heart and kidney disease--to name a few.
Type 1 diabetics are particularly conscientious of this balance and these complications since their body does not make any insulin. Since one of the primary factors of blood sugar elevation is carbohydrate consumption, they must carefully calculate the amount of insulin to take to reduce their blood sugar based on the carbohydrates they are about to consume for a meal.

Fortunately, most packaged foods in the US come with nutrition information. This allows a Type 1 diabetic patient to review the serving size and carbohydrates and calculate a carbohydrate total for their meal with relative ease.
Modern day food guides and applications also allow for these folks to quickly reference how many carbohydrates are in the foods of many raw foods (such as vegetables and fruits) as well as foods at chain restaurants (from McDonalds to McCormick and Schmicks).
However, for local food chains and restaurants, there is still not a single repository for this information--likely due to barriers for a single entity to efficiently calculate, routinely update, and store nutrition information for hundreds of thousands of locations of varying notoriety.
The goal of this project is to take advantage of an open source web application that allows diabetics to share estimates of carbohydrate content for local restaurants where existing nutrition information does not yet exist. 
The goal is to provide improved carbohydrate information for better insulin injection estimation and improved blood sugar outcomes in diabetic patients.

### Project Technologies/Techniques

* Security and Authentication
    * Tomcat JDBC Realm Authentication
    * Roles: Registered User, All
    * Access:
        * Registered User: add carbohydrate information, store favorites, and search for menus, menu items, and carbohydrate information
        * All: search for menus, menu items, and carbohydrate information
* Database
    * MySQL
    * Stores users, profiles, carbohydrate, and menu item information
* ORM Framework
    * Hibernate 5
* Dependency Management
    * Maven
* Web Services Consumed Using Java
    * Spoonacular
    * JavaMail (?)
    * IP Geo Location (? - Stretch Goal)
* CSS
    * Bootstrap
* Data Validation
    * JQuery Validation (?)
    * Hibernate Validation (?)
* Logging
    * Log4J
* Hosting
    * Amazon Web Services (EC2 Instance)
* Independent Research Topics
    * Hibernate Validation (?)
    * Project Lombok
    * AWS Code Pipeline (?)
    * Enumerations
* Unit Testing
    * JUnit
    * Achieve 80%+ code coverage
* Version Control
    * Git and GitHub
* IDE
    * IntelliJ IDEA

### Design

* [User Stories](designDocuments/userStories.md)
* [Screen Design](designDocuments/screenDesigns.md)
* [Application Flow](designDocuments/applicationFlow.md)
* [Database Design](designDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)

### [Weekly Reflection](WeeklyReflection.md)