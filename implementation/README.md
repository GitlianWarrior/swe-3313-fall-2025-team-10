# Implementation
This document provides detailed configuration instructions to ensure the application runs smoothly. It explains how to configure the environment, set up the database, start the application, log in, and common troubleshooting issues a user may run into.

## Environment Setup
The following is required to operate the application from a terminal: 
####  **1. Java 24 or Higher**
- **Installing Java 24**: If not already installed, download Java 24 (JDK) from Oracle. Choose the installer based off your specific operating system. (https://www.oracle.com/java/technologies/downloads/)
  
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

#### **6. Login Information** 
Use the sample information to log into the application.

| **Username** | **Password** |
|--------------|--------------|
| admin        | admin123     |
| user         | user123      |

**Notes:**
- **admin** — Role has full administrator access in addition to user access.
- **user** — Role only has standard user access.

## How to add cars into the inventory
To add a new car into the inventory, go to the DataLoader.java file and then type the following code in the run block:

```java
carRepository.save(new Car(make, model, year, description, price, image path))
```

Replace the data inside the Car method for the data you actually want to save. (Don't forget to add the image of the car to the images folder before saving the data into the database, and also make sure to delete the line of code before running the app again).

## How to make someone an admin
To make someone an admin you just need to write this code into the DataLoader.java file in the run block

```java
if (userRepository.findByUsername("existingUser").isPresent()) {
    User user = userRepository.findByUsername("existingUser").get();
    user.setAdministrator(true);
    userRepository.save(user);
    System.out.println("User 'existingUser' promoted to ADMIN.");
}
```

Replace the existingUser by the user you want to promote
