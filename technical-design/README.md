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
