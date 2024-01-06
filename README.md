# CloudBeesAssignment_Api
# Train Ticketing System

A simple train ticketing system implemented in Java, consisting of backend APIs for submitting purchases, viewing users and seats, removing users, and modifying seats.

## Features

- **Submit a Purchase:** Allows users to submit a purchase for a train ticket, providing details like from, to, user information, price paid, and seat section.

- **View Users and Seats:** Displays a list of users and their allocated seats in a specified section.

- **Remove a User:** Removes a user from the system based on their email.

- **Modify a User's Seat:** Modifies a user's allocated seat, allowing changes to the seat section and seat number.

## Usage

1. **Run the Backend:**
   - Open the project in Eclipse.
   - Ensure that the backend code is free of errors.
   - Run the main class to start the backend server.

2. **Run the Frontend (Optional):**
   - Frontend code not provided in this repository, but you can integrate it as needed.

3. **Examples:**
   - Use the provided `TicketApiDemo` class to simulate different operations interactively.

## Examples

### Example 1: Submit a Purchase
Enter your choice: 1

Submit a Purchase:
From: City X
To: City Y
First Name: Alice
Last Name: Johnson
Email: alice.johnson@example.com
Price Paid: 75.0
Seat Section (e.g., Section A): Section A


Output:

Receipt Details:
From: City X
To: City Y
User: Alice Johnson
Email: alice.johnson@example.com
Price Paid: $75.0
Seat Section: Section A
Seat Number: 1 // Assuming it's the first seat allocated in Section A
Purchase Date: [current date and time]


### Example 2: View Users and Seats

Enter your choice: 2

View Users and Seats in Section (e.g., Section A): Section A

Output:

Users and Seats in Section Section A:

User: Alice Johnson, Seat: 1

### Example 3: Remove a User

Enter your choice: 3

Remove User (Enter email): alice.johnson@example.com

Output:

View Users and Seats in Section Section A (Before Removal):

User: Alice Johnson, Seat: 1

User removed successfully.

View Users and Seats in Section Section A (After Removal):

### Example 4: Modify a User's Seat

Enter your choice: 4

Modify User's Seat (Enter email): bob.smith@example.com
New Seat Section: Section B
New Seat Number: 3

Output:

View Users and Seats in Section Section A (Before Modification):

User: Alice Johnson, Seat: 1

User's seat modified successfully.

View Users and Seats in Section Section A (After Modification):

Feel free to customize this README template based on your specific project details.


