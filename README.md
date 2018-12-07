# CS3398-Fall2018-AndrroidApp

# Status of Project
We connected frontend and backend parts. The app now can login, signup, order, check the order history and edit the user acccount. Upon signing up, new users will recieve a confirmation email. On the frontend we also added a user, menu, information and favorites page, and added backend information processing. We also have an offsite database that stores all of our user and item information. Our efforts to accomplish this are detailed below:

* Andrew Hyatt: Status - During sprint 3 I was able to add order history for each customer, as well as the ability to edit information. My next steps would be to add more information to customer profile page, and allow customers to edit more information than just email and phone number.
* Danh Pham: Status - Completed sprint 3 work, which included adding orders to backend, as well as assist Andrew with editing customer information. My next step would be to split the order database to smaller parttern: order and payment. Configurate to order multiple food.
* Le Cuong: Status - Designed the Homepage and Menu, as well as linked these buttons to the log in page. My next step would be to alter the color scheme of our app, as it seemed to be difficult to read at times during our demo.
* Zak King: Status - Worked with Andrew on the layout of the menu. I also worked with Danh on the cart page. My next step would be to reorganize the user interface for our app, specifically making the menu and cart pages look even better.
* Alexander Muyshondt: Status - Polished up user profile page and helped connect existing frontend with backend for sprint 3. My next step would be to edit the layout of the user profile page, and make the elements flow better.

# How to run the app (for Android device)
 - Download the file <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/tree/master/apk">Mimas_12_04.apk</a> to your android phones.
 - Install and run this app in your android phones
 - Current features of app: Login, SignUp (You will receive an confirmation email if you enter a valid email), Order (One item at a time), Payment, Order History and Editing Account.
 
# How to build and run the app (with Android Studio)
- Only other way to build and run program is with Android Studio. Make sure to download Android Studio and install.
- Copy this GitHub repository using GitHub Desktop. 
- Change directory to this repository, and make sure current branch is master (should be by default).
- Open Android Studio, click the build icon (which appears like a hammer - similar to other IDEs).
- Once progress shows successful build, click the green play button, and download an emulator (suggested APIs are either 22 or 24). This will automatically run our app on the emulator once it finishes downloading and installing. Enjoy!
Note: If build does not succeed, likely cause is a dependency issue with Android Studio on your personal device. Some of our group members faced this issue while others did not.

# Individual (Artifact References and Proof of Work)
Andrew Hyatt
- I worked on creating a table for storing menu items in the database. 
- On my aHyatt-menu-db branch, I created <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/aHyatt-menu-db/app/src/main/java/com/example/danhpham/group2/Menu.java">Menu.java</a> to retrieve these menu items from the database. 
- On my aHyatt-email branch, I updated <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/aHyatt-email/app/src/main/java/com/example/danhpham/group2/SignUp.java">SignUp.java</a> to send an email when a new user signs up for our app (this branch has been merged to master). 
- On my aHyatt-customer-rewards branch, I've added a <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/tree/aHyatt-customer-rewards/app/src/main/java/com/example/danhpham/group2/reward">reward package</a> which includes CurrentRewards.java (a file which tracks the user's current rewards), Reward.java (a parent class for objects of type Reward), DiscountReward.java (a sub-class that inherits from Reward class, which introduces basic discount functionality), and IRewardable.java (which is an interface for applying a customer's reward). 

Danh Pham
- I worked on database and contribute to write the login and signup php file to receive the login and signup information from the android app. Search those information in database (with login) and Fill in those signup information.
- Contribute to <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/Login.java">Login.java</a>, <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/SignUp.java">SignUp.java</a> (to send information to server), <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/cart.java">cart.java</a> (send the order information to server)

Le Cuong 
  - I woked on the Homepage and add some items to Menu, also connect them to logging page  <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/zacharyking2016/app/src/main/java/com/example/danhpham/group2/HomePageActivity.java">Homepage.java</a> and  <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/zacharyking2016/app/src/main/java/com/example/danhpham/group2/Menu.java">Menu.java</a>
  


Zak King 
 - I created the <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/res/layout/activity_menu.xml">Menu</a> and the <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/res/layout/activity_cart.xml">Cart page.</a> 
 - I also created some backend information processing before information is sent to the database for the  <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/Menu.java">Menu.java</a> and <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/cart.java">Cart.java</a> pages, in collaboration with Andrew and Danh respectively. 


Alexander Muyshondt
- Created the user <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/res/layout/activity_user.xml">profile page</a>, including user avatar and user-specific attributes such as username, password, credit card information and Favorites button. 
- Created the <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/res/layout/activity_edit_account.xml">edit account layout xml file</a>.
- For Sprint 3, functionality was added for the user to change their credit card information and look at their favorite meals using the button in their profile.
- If there was another Sprint, more fields may be added to the user account as well as the option to edit the user profile picture.
