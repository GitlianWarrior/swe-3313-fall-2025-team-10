# Requirements for Rare Car E-Commerce Website

## Version 1

### Epic: Manage User Authentication (T10E-1)

- Story: User Self-Registration (T10S-1)
    - Priority: MUST HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: The system must allow new users to create an account by providing a unique username and a password (minimum 6 characters). The system must validate the username’s uniqueness.
- Story: User Login (T10S-2)
    - Priority: MUST HAVE
    - Estimated Effort: 0.5 days
    - Functional/Non-Functional: Functional
    - Description: Registered users must be able to log in using their username and password. The system must display an error message for invalid credentials.

### Epic: Manage Car Inventory (T10E-2)

- Story: Display Car Inventory (T10S-3)
    - Priority: MUST HAVE
    - Estimated Effort: 2 days
    - Functional/Non-Functional: Functional
    - Description: The system must display a list of available cars, sorted by price (highest to lowest). Each car listing must include a short name, a high-quality image, price (formatted with a $ sign, commas, and decimal points), a brief description (maximum 100 words), and a button to add to the shopping cart. Cars that have been sold must not be displayed.
- Story: Car Search (T10S-4)
    - Priority: MUST HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: Users must be able to search for cars by entering keywords. The system must perform a case-insensitive search matching keywords against car name and description. Search results must be displayed in the same format as the main inventory list.

### Epic: Manage Shopping Cart & Checkout (T10E-3)

- Story: Add Car to Shopping Cart (T10S-5)
    - Priority: MUST HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: Users must be able to add cars to their shopping cart. The system must display a confirmation message upon addition.
- Story: View and Modify Shopping Cart (T10S-6)
    - Priority: MUST HAVE
    - Estimated Effort: 1.5 days
    - Functional/Non-Functional: Functional
    - Description: Users must be able to view the contents of their shopping cart, remove items, and see the subtotal (calculated as the sum of item prices). If the cart is empty, the system must redirect to the main inventory screen. The cart data must persist across sessions using browser cookies. Users cannot proceed to checkout if the cart is empty.
- Story: Checkout - Shipping Information (T10S-7)
    - Priority: MUST HAVE
    - Estimated Effort: 1.5 days
    - Functional/Non-Functional: Functional
    - Description: Users must be able to enter their shipping address, including name, address, city, state, zip code, and phone number. The user must also select a shipping speed.
- Story: Checkout - Payment Information (T10S-8)
    - Priority: MUST HAVE
    - Estimated Effort: 2 days
    - Functional/Non-Functional: Functional
    - Description: Users must be able to enter their payment information (card number, expiration date, CVV). The system must validate the card number format. Actual payment processing will be simulated for this version.
- Story: Checkout - Order Confirmation (T10S-9)
    - Priority: MUST HAVE
    - Estimated Effort: 1.5 days
    - Functional/Non-Functional: Functional
    - Description: Before finalizing, the system must display an order confirmation page with a list of items (name and price), subtotal, tax (6% of the subtotal), shipping cost, and total. Users must click "Complete Order" to finalize. Upon completion, the items are removed from inventory, and a receipt is generated. The cart is cleared.
- Story: Checkout - Receipt Generation (T10S-10)
    - Priority: MUST HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: Upon successful completion, the system must display a receipt page with order details, the subtotal, tax, shipping, total, and the last four digits of the credit card. The receipt will be displayed in the browser, simulating an email. The user can click "OK" to return to the main page.

### Epic: Administer System (T10E-4)

- Story: Admin Login (T10S-11)
    - Priority: MUST HAVE
    - Estimated Effort: 0.5 days
    - Functional/Non-Functional: Functional
    - Description: Administrators must be able to log in using their username and password to access extended features. An existing admin must elevate a registered user to admin status (manual process if UI is not implemented).
- Story: Admin - Add/Edit Car Inventory (T10S-12)
    - Priority: MUST HAVE
    - Estimated Effort: 3 days
    - Functional/Non-Functional: Functional
    - Description: Administrators must be able to add new cars to the inventory, including name, picture (upload functionality), price, description, and availability status (in stock/out of stock). They must also be able to edit existing car details. If UI is not feasible, provide instructions for manual database/file entry to populate initial inventory.
- Story: Admin - View Sales Report (T10S-13)
    - Priority: MUST HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: Administrators must be able to view a sales report showing all purchased cars, the purchaser’s name, the purchase date, the total amount and the car's model name.
- Story: Admin - Export Sales Report (T10S-14)
    - Priority: NEEDS TO HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: Administrators must be able to export the sales report to CSV format.

## Version 2

### Epic: Enhance Car Inventory (T10E-5)

- Story: Multiple Pictures per Car Inventory Item (T10S-15)
    - Priority: NEEDS TO HAVE
    - Estimated Effort: 3 days
    - Functional/Non-Functional: Functional
    - Description: The system must support multiple pictures per car inventory item, allowing administrators to upload multiple high-quality images during addition or editing, and displaying them in the car listing and search results.

### Epic: Enhance Admin System (T10E-6)

- Story: User Interface for Elevating Users to Admin Status (T10S-16)
    - Priority: NEEDS TO HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: The system must provide a user interface for administrators to elevate registered users to admin status, replacing the manual process.

- Story: Click on Sold Item to View Associated Receipt (T10S-17)
    - Priority: NEEDS TO HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Functional
    - Description: In the sales report, administrators must be able to click on a sold item to view the associated receipt, including all order details.

### Epic: Enhance Shopping Cart & Checkout (T10E-7)

- Story: Actual Email Sending for Receipts and Notifications (T10S-18)
    - Priority: NEEDS TO HAVE
    - Estimated Effort: 2 days
    - Functional/Non-Functional: Functional
    - Description: The system must implement actual email sending for receipts (instead of browser simulation) and notifications, such as order confirmation and shipping updates.

### Epic: System Quality (T10E-8)

- Story: System Performance (T10S-19)
    - Priority: MUST HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Non-Functional
    - Description: The system must load pages within 3 seconds.

- Story: System Security (T10S-20)
    - Priority: MUST HAVE
    - Estimated Effort: 1.5 days
    - Functional/Non-Functional: Non-Functional
    - Description: The system must protect user data and prevent unauthorized access.

- Story: System Usability (T10S-21)
    - Priority: MUST HAVE
    - Estimated Effort: 0.5 days
    - Functional/Non-Functional: Non-Functional
    - Description: The system must be intuitive and easy to navigate, with user-friendly language, multiple navigation options (forward/back/cancel), and confirmations for irreversible actions.

- Story: System Scalability (T10S-22)
    - Priority: NEEDS TO HAVE
    - Estimated Effort: 1 day
    - Functional/Non-Functional: Non-Functional
    - Description: The system must handle a large number of users and transactions.

- Story: Data Integrity (T10S-23)
    - Priority: MUST HAVE
    - Estimated Effort: 0.5 days
    - Functional/Non-Functional: Non-Functional
    - Description: Prices must be stored in base-10 decimal format. All data must be persisted reliably across restarts.