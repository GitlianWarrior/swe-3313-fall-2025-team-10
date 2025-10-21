# Requirements for Rare Car E-Commerce Website

## Introduction
This document details the functional and non-functional requirements for an  e-commerce website specializing in rare cars. The website will allow  users to browse, search, and purchase unique vehicles, with  administrative features for inventory and sales management. Requirements are organized by Version, Epic, and Story, with associated priority,  estimated effort, and functional/non-functional classifications.

## Version 1
### Epic: Manage User Authentication (T10E-1)

- Story: User Self-Registration (T10S-1)
  - Priority: MUST HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Functional
  - Description: The system must  allow new users to create an account by providing a unique username and a password (minimum 6 characters). The system must validate the  username’s uniqueness.
- Story: User Login (T10S-2)
  - Priority: MUST HAVE
  - Estimated Effort: 0.5 days
  - Functional/Non-Functional: Functional
  - Description: Registered users must be able to log in using their username and password. The system  must display an error message for invalid credentials.

 
### Epic: Manage Car Inventory (T10E-2)

- Story: Display Car Inventory (T10S-3)
  - Priority: MUST HAVE
  - Estimated Effort: 2 days
  - Functional/Non-Functional: Functional
  - Description: The system must  display a list of available cars, sorted by price (highest to lowest).  Each car listing must include a short name, a high-quality image, price  (formatted with a $ sign, commas, and decimal points), a brief  description (maximum 100 words), and a button to add to the shopping  cart. Cars that have been sold must not be displayed.
- Story: Car Search (T10S-4)
  - Priority: MUST HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Functional
  - Description: Users must be  able to search for cars by entering keywords. The system must perform a  case-insensitive search matching keywords against car name and  description. Search results must be displayed in the same format as the  main inventory list.

### Epic: Manage Shopping Cart & Checkout (T10E-3)


- Story: Add Car to Shopping Cart (T10S-5)
  - Priority: MUST HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Functional
  - Description: Users must be  able to add cars to their shopping cart. The system must display a  confirmation message upon addition.
- Story: View and Modify Shopping Cart (T10S-6)
  - Priority: MUST HAVE
  - Estimated Effort: 1.5 days
  - Functional/Non-Functional: Functional
  - Description: Users must be  able to view the contents of their shopping cart, remove items, and see  the subtotal (calculated as the sum of item prices). If the cart is  empty, the system must redirect to the main inventory screen. The cart  data must persist across sessions using browser cookies. Users cannot  proceed to checkout if the cart is empty.
- Story: Checkout - Shipping Information (T10S-7)
  - Priority: MUST HAVE
  - Estimated Effort: 1.5 days
  - Functional/Non-Functional: Functional
  - Description: Users must be  able to enter their shipping address, including name, address, city,  state, zip code, and phone number. The user must select a shipping  speed: Overnight ($29), 3-Day ($19), or Ground ($0).
- Story: Checkout - Payment Information (T10S-8)
  - Priority: MUST HAVE
  - Estimated Effort: 2 days
  - Functional/Non-Functional: Functional
  - Description: Users must be  able to enter their payment information (card number, expiration date,  CVV). The system must validate the card number format. Actual payment  processing will be simulated for this version.
- Story: Checkout - Order Confirmation (T10S-9)
  - Priority: MUST HAVE
  - Estimated Effort: 1.5 days
  - Functional/Non-Functional: Functional
  - Description: Before  finalizing, the system must display an order confirmation page with a  list of items (name and price), subtotal, tax (6% of the subtotal),  shipping cost, and total (e.g., $325 + $19.50 (6%) + $29 = $373.50).  Users must click "Complete Order" to finalize. Upon completion, the  items are removed from inventory, and a receipt is generated. The cart  is cleared.
- Story: Checkout - Receipt Generation (T10S-10)
  - Priority: MUST HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Functional
  - Description: Upon  successful completion, the system must display a receipt page with order details, the subtotal, tax, shipping, total, and the last four digits  of the credit card. The receipt will be displayed in the browser,  simulating an email. The user can click "OK" to return to the main page.

### Epic: Administer System (T10E-4)


- Story: Admin Login (T10S-11)
  - Priority: MUST HAVE
  - Estimated Effort: 0.5 days
  - Functional/Non-Functional: Functional
  - Description: Administrators must be able to log in using their username and password to access  extended features. An existing admin must elevate a registered user to  admin status (manual process if UI is not implemented).
- Story: Admin - Add/Edit Car Inventory (T10S-12)
  - Priority: MUST HAVE
  - Estimated Effort: 3 days
  - Functional/Non-Functional: Functional
  - Description: Administrators must be able to add new cars to the inventory, including name, picture  (upload functionality), price, description, and availability status (in  stock/out of stock). They must also be able to edit existing car  details. If UI is not feasible, provide instructions for manual  database/file entry to populate initial inventory.
- Story: Admin - View Sales Report (T10S-13)
  - Priority: MUST HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Functional
  - Description: Administrators must be able to view a sales report showing all purchased cars, the  purchaser’s name, the purchase date, and the total amount.
- Story: Admin - Export Sales Report (T10S-14)
  - Priority: NEEDS TO HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Functional
  - Description: Administrators must be able to export the sales report to CSV format.

## Version 2 – Future Considerations

- Multiple pictures per car inventory item
- User interface for elevating users to admin status
- Ability to click on a sold item in the sales report to view the associated receipt
- Actual email sending for receipts and notifications (e.g., order confirmation, shipping updates)

## Non-Functional Requirements

- Story: System Performance (T10S-15)
  - Priority: MUST HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Non-Functional
  - Description: The system must load pages within 3 seconds.
- Story: System Security (T10S-16)
  - Priority: MUST HAVE
  - Estimated Effort: 1.5 days
  - Functional/Non-Functional: Non-Functional
  - Description: The system must protect user data and prevent unauthorized access.
- Story: System Usability (T10S-17)
  - Priority: MUST HAVE
  - Estimated Effort: 0.5 days
  - Functional/Non-Functional: Non-Functional
  - Description: The system  must be intuitive and easy to navigate, with user-friendly language,  multiple navigation options (forward/back/cancel), and confirmations for irreversible actions.
- Story: System Scalability (T10S-18)
  - Priority: NEEDS TO HAVE
  - Estimated Effort: 1 day
  - Functional/Non-Functional: Non-Functional
  - Description: The system must handle a large number of users and transactions.
- Story: Data Integrity (T10S-19)
  - Priority: MUST HAVE
  - Estimated Effort: 0.5 days
  - Functional/Non-Functional: Non-Functional
  - Description: Prices must be stored in base-10 decimal format. All data must be persisted reliably  (e.g., using JSON, SQLite, or CSV) across restarts.
