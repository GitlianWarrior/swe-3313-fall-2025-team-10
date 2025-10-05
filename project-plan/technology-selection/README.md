# Technology Selection

## Language: Java 23

- **Why Selected**: All team members have prior experience with Java. This ensures efficient development and a reduced learning curve.

## Framework: Spring with Maven

- **Why Selected**: Spring with Maven is required for Java for this project.

## Storage Plan: SQLite

- **Why Selected**: SQLite is a simple database that stores your information in a single file, so everything stays safe and neatly organized, even if you shut down the app and start it up again later.  It ensures everything stays consistent without needing complicated setups like separate servers or cloud services, which makes it reliable for handling sales transactions. It lets you link related pieces of data together and automatically checks rules to avoid mistakes without having to write your own extra code to keep things accurate and secure.
- **Why not CSV?**: Professor Adkisson has never seen CSV work well for this project. They store data in a flat list without ways to connect related information, and they don't automatically check or enforce rules, such as ensuring numbers are treated as numbers or preventing invalid entries, which can lead to mistakes.
- **Why not JSON?**: JSON lacks built-in mechanisms to keep financial information accurate and error-free. It also lacks automatic tools for connecting and organizing related data which means you would have to write extra custom code to evalute everything and make it secure. Due to this, SQLite is a more straightforward option for this assignment.

## Operating Environment

1. #### Target Platforms (Runtime Environment)

   - Windows
   - macOS
   - Linux

2. #### Development Environment

 - **Integrated Development Environment (IDE)**: We will use IntelliJ IDEA because we can use the free JetBrains education license and it provides cross-platform tools that work on Windows, macOS, and Linux.
   - **Source Control**: We will use Git source control and put all the work into the Github repository.
   - **Planning and Documentation Tools**:
     - **Gantt Project**: For developing the project plan Gantt chart.
     - **Marvel**: For designing UI mockups.
     - **Loom**: For recording video presentations.
