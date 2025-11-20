# Technical Design

## Table of Contents

- A. Implementation Language(s)
- B. Implementation Framework(s)
- C. Data Storage Plan
- D. Entity Relationship Diagram (ERD)
- E. Entity/Field Descriptions
- F. Data Examples
- G. Database Seed Data
- H. Authentication and Authorization Plan
- I. Coding Style Guide
- J. Video Presentation

## A. Implementation Language(s)

- **Java 24**: Primary backend language for its strong typing, object-oriented features, and suitability for enterprise-level e-commerce systems. Selected due to team experience and its robustness in data persistence, security, and Spring integration.
  - [Official Java Documentation](https://docs.oracle.com/en/java/javase/23/)
  - [Java Tutorial for Beginners](https://docs.oracle.com/javase/tutorial/)
- **HTML/CSS/JavaScript**: Standard for frontend rendering and interactivity, enabling responsive UIs matching our Marvel mockups.

  - [MDN Web Docs for HTML](https://developer.mozilla.org/en-US/docs/Web/HTML)
  - [MDN Web Docs for CSS](https://developer.mozilla.org/en-US/docs/Web/CSS)
  - [MDN Web Docs for JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

## B. Implementation Framework(s)

- **Spring Boot**: Selected as the primary backend framework built on Spring, leveraging Java's strengths for database integration ideal for managing inventory, carts, and orders in our e-commerce system, as required for the shopping cart functionality.
  - [Spring Boot Documentation](https://docs.spring.io/spring-boot/reference/)
  - [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
- **Bootstrap**: CSS framework for responsive design and pre-built components to accelerate UI development. Specific components include navigation bars for site menus, modals for user interactions like login prompts, and responsive grids for layout adaptability across devices.
  - [Bootstrap Documentation](https://getbootstrap.com/docs/5.3/getting-started/introduction/)
  - [Bootstrap Tutorial](https://www.w3schools.com/bootstrap5/)

## C. Data Storage Plan

- **Database**: SQLite is selected because it provides persistent storage (data survives application restarts). No external server is required.
  - [SQLite Documentation](https://www.sqlite.org/index.html)
- **Libraries and Technologies**:
  - Driver: sqlite-jdbc for JDBC connectivity to SQLite.
- **Implementation Steps**:
  - Configure database connection
  - Define classes for database tables.
  - Create methods for storing and retrieving data.
  - Use scripts for seeding data on startup.
- **Persistence Assurance**: All changes are written to storage, ensuring data durability beyond runtime memory; no fresh start on each launch.

## D. Entity Relationship Diagram (ERD)

```mermaid
erDiagram
    User {
        int UserID PK
        string Username UK
        string Password
        string FirstName
        string LastName
        string Email
        bool IsAdministrator
        string AddressStreet
        string AddressCity
        string AddressState
        string AddressZip
        string Phone
    }

    Order {
        int OrderID PK
        int UserID FK
        datetime OrderDate
        decimal SubTotal
        decimal Tax
        decimal ShippingFee
        decimal Total
        string ShippingAddressStreet
        string ShippingAddressCity
        string ShippingAddressState
        string ShippingAddressZip
        string PaymentCardLastFour
    }

    OrderItem {
        int OrderItemID PK
        int OrderID FK
        int CarID FK, UK
    }

    Car {
        int CarID PK
        string Make
        string Model
        int Year
        string Description
        decimal Price
    }

    User --o{ Order : "places"
    Order --|{ OrderItem : "contains"
    Car ||--o| OrderItem : "is sold in"
```

## E. Entity/Field Descriptions
| User Table            |           |         |      |                |                          |
| --------------------- | --------- | ------- | ---- | -------------- | ------------------------ |
| Field Name            | Data Type | Key     | Null | Default Value  | Description              |
| UserID                | Int       | primary | no   | auto imcrement | Unique ID for each user  |
| Username              | String    | Unique  | no   | none           | User login name          |
| Password              | String    |         | no   | none           | Hashed user password     |
| FirstName             | String    |         | no   | none           | User first name          |
| LastName              | String    |         | no   | none           | User last name           |
| Email                 | String    |         | no   | none           | User email               |
| IsAdministrator       | boolean   |         | no   | FALSE          | User is an admin         |
|                       |           |         |      |                |                          |
| Order table           |           |         |      |                |                          |
| Field Name            | Data Type | Key     | Null | Default value  | Description              |
| OrderID               | int       | primary | no   | Auto imcrement | Unique ID for each order |
| UserID                | int       | foreign | no   | none           | References User          |
| OrderDate             | DateTime  |         | no   | LocalDateTime  | Order Timestamp          |
| SubTotal              | double    |         | no   | 0              | Pre-tax subtotal         |
| Tax                   | double    |         | no   | 0              | Tax amount               |
| ShippingFee           | double    |         | no   | 0              | shippping cost           |
| Total                 | double    |         | no   | 0              | Final order total        |
| ShippingAddressStreet | String    |         | no   | none           | Street                   |
| ShippingAddressCity   | String    |         | no   | none           | city                     |
| ShippingAddressZip    | String    |         | no   | none           | ZIP code                 |
| PaymentCardLastFour   | String    |         | no   | none           | Last 4 digits of card    |
| Phone                 | String    |         | yes  | none           | Phone number             |
|                       |           |         |      |                |                          |
| Car Table             |           |         |      |                |                          |
| Field Name            | Data      | Key     | Null | Default Value  | Description              |
| CardID                | int       | Primary | no   | Auto-Increment | Unique car ID            |
| Make                  | String    |         | no   | none           | Car manufacturer         |
| Model                 | String    |         | no   | none           | car model                |
| Year                  | int       |         | no   | none           | car year                 |
| Description           | String    |         | yes  | none           | car description          |
| Price                 | double    |         | no   | 0              | Car price                |
|                       |           |         |      |                |                          |
| OrdeItem Table        |           |         |      |                |                          |
| Field Name            | Data      | Key     | Null | Default Value  | Description              |
| OrderItemID           | int       | primary | no   | Auto increment | Line item ID             |
| OrderID               | int       | foreign | no   | none           | reference Order          |
| CarID                 | int       | foreign | no   | none           | reference car            |

## F. Data Examples

## G. Database Seed Data

## H. Authentication and Authorization Plan

- **Technical Approach**:

## I. Coding Style Guide

- **[Java Style Guide](https://google.github.io/styleguide/javaguide.html)**: The Google Java Guide will be used for our backend Java development. It provides specific rules for commenting, naming, and filename conventions to ensure all team members follow a uniform and readable style of code throughout the application.
  
  - Naming Conventions: UpperCamelCase for classes; camelCase for variables and methods.
  - Filename Conventions: File names must match class names and use .java extensions.
  - Line Length: Break lines that exceed 100 characters.
  - Indentation: Use 2 spaces when indenting (no tabs).
- **[HTML/CSS/Javascript Style Guide](https://developer.mozilla.org/en-US/curriculum/)**: Frontend code is constructed with semantic HTML, an organized external CSS, and focused JavaScript for form behavior. Specific guidelines are followed to maintain a clean, frontend style.
  
  - HTML Structure: Utilize semantic HTML tags `<main>`,`<nav>`,`<section>` for steady page layouts.
  - CSS Structure: Must use descriptive class names (ex: `.user-info`).
  - JavaScript Structure: Write minimal scripts, purely focusing on interactive elements that improve a user's experience.
- **[SQLite Style Guide](https://www.sqlite.org/lang.html)**: SQLite serves as the embedded database for our application, storing data locally and persistently. Our team adheres to defined guidelines to keep database usage simple to maintain.

  - Naming Conventions: Use snake_case for column and table names (ex: order_id).
  - Query Formatting: For clean readability, break long SQLite statements across multiple lines.
- **Source Control Strategy**: Our team follows a [GitFlow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) style approach to maintain an organized codebase. Each feature has its own branch and pull request which helps us review code before merging.

## J. Video Presentation

- **Video Presentation**: [Watch our Technical Design Presentation on Loom.]()





  
