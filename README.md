# Expense-Tracker

💰 CLI Expense Tracker (Java)

A simple Command Line Expense Tracker built in Java that allows users to manage daily expenses efficiently.
This project demonstrates file handling, object-oriented programming, and basic CRUD operations.

🚀 Features
➕ Add new expenses
📋 View all expenses
❌ Delete an expense
✏️ Update an expense
📊 Calculate total expenses
💾 Persistent storage using a file (expenses.txt)
🛠️ Tech Stack
Language: Java
Concepts Used:
OOP (Classes & Objects)
File Handling
Collections (ArrayList)
Exception Handling
CLI-based interaction
📂 Project Structure
Expense.java   -> Expense class (model + file handling)
Main.java      -> Main logic & user interaction
expenses.txt   -> Stores all expense data
▶️ How to Run

Compile the code:

javac Main.java

Run the program: 

java Main

🧠 How It Works
Expenses are stored as objects with:
id
description
price

Data is saved in a file (expenses.txt) in CSV format:

id,description,amount
On startup:
The program loads existing expenses from the file
After every modification:
Data is saved back to the file

📸 Menu Options
1. Add Expense
2. View Expenses
3. Delete Expense
4. Update Expense
5. Total Expense
6. Exit
7. 
⚠️ Limitations
No input validation (e.g., negative amounts)
No categories or dates
File format is simple (CSV, no encryption)

🔥 Future Improvements
Add categories (Food, Travel, etc.)
Add date tracking
Search & filter expenses
GUI version (JavaFX / Swing)
Export to Excel/CSV

👨‍💻 Author

Aryan Kumar Prajapati

https://roadmap.sh/projects/expense-tracker
