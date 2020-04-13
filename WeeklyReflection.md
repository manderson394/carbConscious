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

2/18/2020 - 17 hours

Tasks Completed:
* Individual Project:
    * Create USERS Table
    * Create User, UserDao, UserDaoTest, and PropertiesLoader 
    * Set up test directory for JUnit tests with MySQL database
* Exercise 4
* Professional Development Activity

This week seemed like it flew on by! I spent the majority of my time working on my Professional Development Project and 
getting Hibernate Validator setup in my project. The version not pulling in dependencies correctly caused quite a problem with
my User DAO unit tests!

Given all of th time spent on my project and troubleshooting, I'm a bit concerned about staying on track with my project plan; 
there's A LOT to do this week. I think it will be in my best interest to do Exercise 5 as a part of my project.
__
After chatting with Paula, I think I'm going to remove the PHI that I would be storing from my assignment--it really isn't
adding value at this point, though it could be a cool idea for a second iteration. 

### Week 5

2/25/2020 - 11 hours

Tasks Completed:
* Individual Project:
    * Create database tables for the test database
    * Saved database table creation SQL to a file for easy re-creation when needed for PRD
    * Create UserRole class and linked to User class via Hibernate
    * Created a Generic DAO class and updated the User and UserRole classes to use this (as well as unit tests)
* Exercise 5

I struggled pretty hard this week with the ManyToOne mapping for Hibernate. But I feel like a learned quite a bit through
the process. Once I had the USERS and USER_ROLES tables down, the rest of the work went fairly smoothly...until disconnected
my SSD drive from my laptop in the middle of a push to GitHub! Fortunately I learned how to re-clone the directory, move over
the .git folder and continue onward. I wouldn't recommend having to do it at all though...

This week I feel a little behind. I'm definitely lagging on my project plan, and that has me fairly nervous.

### Week 6

3/3/2020 - 10.5 hours

Tasks Completed:
* Individual Project:
    * Create entity classes 
    * Create controller classes (tentative based on future updates)
    * Create some essential JSPs
* Exercise 6

Moving this week took quite a bit of time away from my school work, making it a challenge to keep on track. 
I did get a chance to hop in a create some shell classes, but I certainly feel as though I'm behind on my project...
and my project plan shows it! I need to revisit my plan and make some updates.

My goal for the next week is to get back on track in terms of my project plan.

### Week 6

3/10/2020 - 13.25 hours

Tasks Completed:
* Individual Project:
    * Update database table linkages
    * Improve JSP page structure
    * Add Tomcat Realm Authentication to project
* Exercise 7

I feel like I didn't get to my project much this week (and my ProjectPlan.md shows it). I'm not quite getting to the point that 
I'm comfortable with where I'm at in my project, and I'm still looking to make some big leaps in the next week or so.

It didn't help that most of my time this week, I feel like I spent troubleshooting MySQL issues with time zones and access--I wanted to 
be way more productive! 

I'm still struggling with Hibernate mapping for my Enum class...do I need to creat a customer Enum Type? 

### Week 8

3/17/2020 - 14.5 hours

Tasks Completed:
* Individual Project:
    * Deploy to AWS
    * Integration classes for Spoonacular
* Exercise 8

Yet another snafu with the API I was going to use. As it turns out, it looks like the developer community has identified 
that the API is broken and it doesn't seem like anyone is maintaining it. So, I spent another hour looking for a new, reasonable 
API but with the added difficulty of it needing to allow relative compatibility with the data structure/classes I already have in place.
I think I'll use [Recipe-Food-Nutrition API](rapidapi.com/spoonacular/api/recipe-food-nutrition/pricing) now. We'll see how it goes!

The next week is spring break, but I plan to use the weekend of "social distancing" to hopefully jump forward on the week 8 things 
I haven't yet finished.

### Spring Break

3/24/2020 - 11 hours

Tasks Completed:
* Individual Project:
    * Build test cases for all entities in the database
    * Unit test all remaining entities
    * Unit test all database access for remaining entities

I was projecting a little more ambitious outcome, but getting all of my entities unit tested was quite the feat to its own
(at least it feels like it).

I then ran into all of the problems deploying to my web application and reviewing my wireframes. Since I had to update my API, 
and the new API doesn't send back all of the data I need (restaurant location, etc...). I'm likely going to have to revisit user entry and allow it.
This will be some significant scope creep. 

Not only did I encounter that issue, but my VM lost network connection, and I ended up restoring it to a previous copy I had. 
As a result, I needed to build out a lot of config and password files that weren't on GitHub. 

Let's hope this next week goes better :/

### Week 9

3/31/2020 - 11 hours

Tasks Completed:
* Individual Project:
    * Create Restaurant Results Page
    * Create Menu Items Results Page
    * Enhance Authorization and Authentication functionality
* Exercise 9

I started tackling some of the navigation bar CSS formatting and wow! It's been awhile since touching CSS. That being said, it's not
bad on that front. Right now, it's getting used to Bootstrap--which I haven't used before.

Overall, I've been starting to get caught up with my project plan. I'm still a bit behind where I want to be, but it seems a little
more attainable at this point. We'll see how the team project factors into this!


### Week 10

4/07/2020 - 6 hours

Tasks Completed:
* Individual Project:
    * Add Sign Up Functionality

This week has been a tough week to feel accomplished. Things have really been vamping up at work with COVID-19 (still), 
and I've been doing 11 hour work days. I've started biting off smaller chunks of functionality for my project and trying to accomplish one
of those pieces when I sit down to code.

### Week 11

4/07/2020 - 10 hours

Tasks Completed:
* Individual Project:
    * Start building out Favorites functionality
* Team Project:
    * Build out DAO and County Service class (with supporting classes)

Most of my efforts this week were spent on the team project. It really took a lot of time away from my work with my individual project
that I wanted to do. 

I did get some time to start on the favorites functionality work. It's not perfect yet, but it's a start.

