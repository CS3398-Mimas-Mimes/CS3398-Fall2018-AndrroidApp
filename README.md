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
- For sprint III, I worked on displaying the contents of our menu. To view this menu, the user must first log in, and then click the menu button. Currently the menu is printed statically, as the database menu table does not necessarily change that often. Here is a link that will show the code related to displaying the menu: <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/Menu.java">Menu.java</a>. Here is a link that will take you to the merge history, which shows which branch I was using on my local machine (and all updates to master branch): <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/commit/36861d99ea9f993f89a08f1ffbd1c29ec1a50325">Merge History</a>.
- For sprint III, I worked on displaying a customer's orders, sorted by date. This feature is used when a user clicks on their account, and navigates to the favorites button. Code that was merged for this can be found by clicking the following link, which will directly take you to the location in this GitHub repository (on master branch): <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/userOrders.java">userOrders.java</a> Here is a link that shows my commit for this file: <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/commit/36861d99ea9f993f89a08f1ffbd1c29ec1a50325">Commit for userOrders.java</a>.
- Additionally, I worked on allowing the user to update their information, namely their email address and phone number. This occurs when the user navigates to their account page and clicks on the edit button, which can be clicked after login. This connects the frontend to our database by updating information in our customer table. Code that was merged for this can be found by clicking the following link, which will directly take you to the location in this GitHub repository (on master branch): <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/EditAccount.java">EditAccount.java</a>. Here is a link that takes you to the commit for this file: <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/commit/b9a52ab8c05123c9b04e9bf5c41ff7da1fa02e54">Commit for EditAccount.java</a>.
- Lastly, I added the backend code to make sure that when a new user registers an account, their passwords entered match. This makes sure that the user did not accidentally mistype a password when registering. The following link will take you directly to the file that does this: <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/SignUp.java">SignUp.java</a> Here is a link that takes you to the commit for this file: <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/commit/f3fc52fd9a175886373b411209589edd35368499">Commit for SignUp.java</a>.

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
