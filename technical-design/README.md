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

## A. Implementation Language(s)

- **Java 23**: Primary backend language for its strong typing, object-oriented features, and suitability for enterprise-level e-commerce systems. Selected due to team experience and its robustness in data persistence, security, and Spring integration.
  - [Official Java Documentation](https://docs.oracle.com/en/java/javase/23/)
  - [Java Tutorial for Beginners](https://docs.oracle.com/javase/tutorial/)
- **HTML/CSS/JavaScript**: Standard for frontend rendering and interactivity, enabling responsive UIs matching our Marvel mockups.
  
  - [MDN Web Docs for HTML](https://developer.mozilla.org/en-US/docs/Web/HTML)
  - [MDN Web Docs for CSS](https://developer.mozilla.org/en-US/docs/Web/CSS)
  - [MDN Web Docs for JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

## B. Implementation Framework(s)

- **Spring Boot**: Selected as the primary backend framework built on Spring, leveraging Java's strengths to simplify RESTful web services, dependency injection, and database integration. Enables rapid prototyping with production-ready features like embedded servers, ideal for our e-commerce APIs managing inventory, carts, and orders.
  - [Spring Boot Documentation](https://docs.spring.io/spring-boot/reference/)
  - [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
- **Bootstrap**: CSS framework for responsive design and pre-built components to accelerate UI development.
  
  - [Bootstrap Documentation](https://getbootstrap.com/docs/5.3/getting-started/introduction/)
  - [Bootstrap Tutorial](https://www.w3schools.com/bootstrap5/)
- **Thymeleaf**: Template engine for Spring-integrated server-side HTML rendering, enabling dynamic content while keeping the frontend simple.
  - [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
  - [Thymeleaf with Spring Tutorial](https://www.baeldung.com/spring-thymeleaf-3)
 
## C. Data Storage Plan

- **Database**: SQLite as the embedded SQL database for persistent storage; data survives application restarts. No external server is required.
  - [SQLite Documentation](https://www.sqlite.org/index.html)
- **Libraries and Technologies**:
  - ORM/Persistence: Spring Data JPA for mapping Java objects to database tables and handling CRUD operations.
  - Annotations: JPA standards like @Entity, @Id, @GeneratedValue for entity definitions.
  - Driver: sqlite-jdbc for JDBC connectivity to SQLite.
  - [Spring Data JPA Documentation](https://docs.spring.io/spring-data/jpa/reference/)
- **Implementation Steps**:
  
  - Configure the database in Spring Boot's application.properties (e.g., spring.datasource.url=jdbc:sqlite:database.db).
  - Define JPA entity classes to represent tables.
  - Create repository interfaces extending JpaRepository for automatic CRUD methods.
  - Use service classes with @Transactional for business logic and data commits.
  - On startup, use a CommandLineRunner or data.sql script to check/create the DB and seed initial data if needed.
- **Persistence Assurance**: All changes are committed transactionally via JPA, ensuring data durability beyond runtime memory; no fresh start on each launch.

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

  


  
