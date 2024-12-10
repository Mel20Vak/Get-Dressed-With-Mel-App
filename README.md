# Get-Dressed-With-Mel-App
 The purpose of my app is to help people decide what they what to wear by providing them with a virtual assistant doll they can mix and match outfits on.

**Get Dressed With Mel App**
The Future Fashion App is a Java-based GUI application that allows users to virtually try on clothing items, manage their selection history, and visualize outfit layers. It provides an intuitive interface for exploring a collection of clothing and managing outfit choices using stacks and queues for efficient data handling.

**Features**

Virtual Fitting Room:
Try on clothing items from a predefined list.
Visualize layered clothing on an avatar.
**Item Selection Management:**
Uses a Stack to handle the "Remove Last Item" functionality (LIFO behavior).
Uses a Queue to maintain the history of selected items (FIFO behavior).
**User History:**
Displays a log of all tried-on items in a scrollable history panel.
Checkout functionality to review selected items.
**Modern UI:**
Gradient background, styled buttons, and a tabbed pane interface.
Consistent color themes for an aesthetically pleasing user experience.
Technologies Used

**Java Swing:** For creating the graphical user interface.
**Data Structures:**
Stack<String>: Used to manage selected items.
Queue<String>: Used to track the history of selections.
Object-Oriented Design: Modular and reusable components (e.g., AvatarPanel for layered clothing visualization).
How to Run

Ensure you have Java Development Kit (JDK) installed.
**Compile the program using:**
javac EnhancedAppGUI.java
**Run the program using:**
java EnhancedAppGUI
Usage

**Trying On Items:**
Select an item from the list and click "Try On" to add it to the avatar and the history.
**Removing Items:**
Click "Remove Last Item" to remove the most recently added item.
**Viewing History:**
Click "Checkout" to see a list of all tried-on items in a styled dialog box.
**User History Panel:**
The left panel displays all tried-on items in a scrollable view.
Screenshots

**License**

This project is licensed under the MIT License. 

