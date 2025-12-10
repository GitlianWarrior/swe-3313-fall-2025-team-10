# Implementation
This document provides detailed configuration instructions to ensure the application runs smoothly. It explains how to configure the environment, set up the database, start the application, log in, and common troubleshooting issues a user may run into.

## Environment Setup
The following is required to operate the application from a terminal: 
####  **1. Java 24 or Higher**
- **Installing Java 24**: If not already installed, download Java 24 (JDK) from Oracle. Choose the installer based on your specific operating system. (https://www.oracle.com/java/technologies/downloads/)
  
- **Confirm Java Version**: Once installed (or if you already had Java installed), verify the Java version in the terminal.
  ```bash
  java -version
  ```
  A result similar to "24.0.2" should appear.

####  **2. Maven**
- **Install Maven:** If not already installed, download Maven on Mac OS [(with Homebrew)](https://brew.sh/). Then run the command below in the terminal.
  
  ```bash
  brew install maven
  
- **Confirm Maven Installation:** Verify that Maven is available by using the command below in the terminal.
   ```bash
    mvn --version
    ```

## Database Setup
The seed will be automatically uploaded in the database once the app runs, as long as the database is empty. No database setup is required.

## How to Start and Login
####  **1. Clone the Repository (if needed)**
Utilize this command in the terminal to download the project.

  ```bash
git clone https://github.com/GitlianWarrior/swe-3313-fall-2025-team-10.git
  ```

####  **2. Navigate to Project Directory**
Proceed into the folder where the source code is available.

   ```bash
cd swe-3313-fall-2025-team-10/source/rare-cars-sales
   ```

#### **3. Build Application**
Use command below to compile and install dependencies.

  ```bash
   mvn clean install
  ```

#### **4. Run Command**
Start the Spring Boot application from the terminal.

   ```bash
    mvn spring-boot:run
   ```

#### **5. To View Site**
Open link in browser to access the project.

  ```
    http://localhost:8080/
   ```

## Login Information

## Troubleshooting
