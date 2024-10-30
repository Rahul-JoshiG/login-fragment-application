# Login Fragment Application
</br>

## Introduction
  Welcome to My Application! This application is designed to provide a simple and intuitive user experience for logging in and accessing a personalized dashboard. 
  Below you'll find an overview of the features and functionality included in this application.

## Features
  Login Screen
    Email Field: Enter your email address.
    Password Field: Enter your password.
    Remember Me Checkbox: Check this box to save your login credentials for future sessions.
    Login Button: Press this button to submit your credentials and log in.

## Dashboard
  Greeting Message: After logging in, you will be greeted with a message that includes your email address.
  Move To Log out Button: A button is pass you to log out fragment.

## Log Out
  Prevous Button: A button is provided to go to dashboard fragment.
  Logout Button: A button is provided to log out of the application.
  
## Screens and Navigation
  Login Screen
    The login screen is the initial screen presented to the user. It contains three key elements:
      
      Email EditText: A text field where the user enters their email address. By default value is "rahul123@gmail.com"
      Password EditText: A text field where the user enters their password. By default value is "1234"
      Remember Me Checkbox: A checkbox that allows the user to save their login credentials for future use.
      Login Button: When clicked, this button validates the user's credentials and, if successful, navigates to the dashboard activity.

## Dashboard Activity
  Upon successful login, the user is redirected to the dashboard activity, which contains dashboard fragment:

## Dashboard Fragment: 
  This fragment displays a personalized greeting message that includes the user's email address.
  Move to Log out Button: A button within the dashboard fragment that, when clicked, navigates the user to the logout fragment.

## Log Out Fragment:
  This fragment displalys three views element:
  Log Out Text View: This view display that it is Log Out Fragment.
  Previous Button: This button helps user to navigate to user to dashboard fragment.
  Log Out Button: A button clicked the user log out from the app and navigate to the Log In activity.
