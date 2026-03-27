# ATM Project

**Overview**  
This program is the Atm System. It lets a customer log in and manage two accounts: a checking account and a savings account. Each account has its own menu where you can check the balance, make a deposit, or make a withdrawal. The savings account also has an interest rate. You can also login as admin to create new accounts and passwords as well as apply the interest rates to savings accounts. This system will update the banks and customers files when logged out of to update the system instead of restarting to factory code.

A default customer named Alice with PIN 0000 is included.
The default admin login is named Admin with PIN 0000 as well.

---

**Menu Algorithm**  
Print the menu options  

Ask the user to enter a choice  

Return the choice  

This pattern is used in the checking account, savings account, and customer menus.

---

**Main Loop (Customer)**  
Show the customer menu  

1, opens the checking account menu  

2, opens the savings account menu  

3, lets the user change their PIN  

Repeat until the user enters 0  

---

**Checking Account Algorithm**  
Show the account menu  

If the user chooses check balance, print the balance  

If the user chooses deposit, ask for an amount and add it  

If the user chooses withdraw, ask for an amount and subtract it  

---

**Savings Account Algorithm**  
Same menu as the checking account  

Stores an extra value called interestRate  

calcInterest() adds interest to the balance  

Interest is not used yet in this part of the project  

---

**User Login Algorithm**  
Ask for username  

Ask for PIN  

Compare both to the stored username and PIN  

If they match, login succeeds  

If not, login fails  

---

**Customer Algorithm**  
Create a checking account  

Create a savings account  

Ask the user to log in  

If login works, show the customer menu  

Let the user manage their account or change their PIN  

Exit when the user chooses 0  

**Admin Algorithm**
Create new accounts and passwords

Apply interest rates to accounts

View all accounts and balances in the bank