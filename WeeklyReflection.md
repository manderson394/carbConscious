# Weekly Reflection

### Week 1

1/21/2020 - 4 hours

Tasks Completed:
* VM Environment Setup
* Individual Project Selection

I'm pretty confident I want to go with my idea for an open source carbohydrate counting web application for establishments without nutrition information available on the web. 
I don't have a clear idea yet of the screen design, but I generally have my user cases. 

When looking for services that could fit my need, I did find at least one:

* I found an api that grabs [US Restaurant Menus](www.rapidapi.com/restaurantmenus/api/us-restaurant-menus).
* Seems like [www.rapidapi.com] could be a good website if I need to find some other api that are available. 

### Week 2

1/28/2020 - 13 hours

Tasks Completed:
* Individual Project:
    * Problem Statement Written
    * Time Log file created
    * Weekly Reflection file created
    * User Stories created
    * High Level Directories Created (*on VM only*)
* Exercise 2 Completed

I'm still stuck on a Java version exception when trying to configure the week 1 exercise to work on my Windows laptop; I'd like to have that resolved soon so I don't need to use my VM at home.
That being said, my VM is working fine at the moment, and I've been making solid progress in terms of supporting documents to the project (weekly reflection, time logging, problem statement).
My biggest struggle this week was navigating the code I needed for the front end behavior I wanted; I anticipate this will be a continued trend since it isn't my strength.
I'm actually looking forward to getting more familiar with front end development through this project, though. 

Aside from week 3 work, I really want to focus on rounding out my project design in the upcoming week. 

### Week 3

2/4/2020 - 10.75 hours

Tasks Completed:
* Individual Project:
    * Create Log4J.properties file
    * Create Project Plan
    * Page designs
    * Database diagrams
    * Application Flow document 
* Exercise 3

While crating my wireframes, I realized that the original API for menus that I was expecting to use was no longer available (panic!).
I was able to find this other API that still has the functionality I'm looking for: https://menuapi.xyz/docs

It took me awhile to figure out my project plan. Though I now feel like I have a good idea of what the final product will look
like, I can't be certain that I've outlined all of the steps that I'll need to complete. 


### Week 4

2/11/2020 - 11.25 hours

Tasks Completed:
* Individual Project:
    * Add hibernate dependencies
    * Complete design documents and problem statements for Checkpoint #1

I'm thinking a lot about my database and class setup in relationship to the API I'll be using for restaurants. I was intending
not to save too much of that data into the database, but introducing favorites for users necessitates it to prevent data loss. The
other aspect that has me wondering is creating a sort of average of the carbohydrate estimates from users. It doesn't make sense
to calculate the average every time a user tries to view this data. It would be more efficient to calculate it once per day and cache it somehow.
After chatting about this with Paula, I'm got explore calculating the average carbs for a given menu item on the fly at first, only loading 
the items that appear on the user's screen (if multiple pages to a table). 

Now that I'm beginning work on the code for my project, I definitely am finding that I'm running into more questions than I would have expected.
Mostly, they're design questions that I'm used to talking with folks in R&D about at work; it's a little bit of a change in mindset without that resource.

### Week 5

2/18/2020 - ### hours

Tasks Completed:
* Individual Project:
    * Create USERS Table
    * Create User, UserDao, UserDaoTest, and PropertiesLoader 
    * Set up test directory for JUnit tests with MySQL database
* Exercise 4



