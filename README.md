# Trade Management System

This project is a Java-based application for managing trade data. It includes functionality to add, view, and calculate the risk for trades stored in a MySQL database. The system uses JDBC for database connectivity.

## Features
- Add a new trade to the database.
- View all trades stored in the database.
- Calculate the risk for a specific trader by summing up the trade amounts.
- Database connection using JDBC.
- Basic trade-related operations (add, get all, calculate risk, remove).
- A dedicated folder to store backup files. You just need to specify the path to the backup directory in the code.


## Technologies Used
- **Java 8+** (JDK)
- **MySQL** (for the database)
- **JDBC** (for database connectivity)
- **Maven** (for dependency management)
- **IntelliJ IDEA** (IDE)

## Setup and Installation

### Prerequisites

1. **Java Development Kit (JDK 8 or higher)**
   - You can download the JDK from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   
2. **MySQL Database** 
   - You need a MySQL database running on your local machine or a remote server.
   - Ensure that you have a database schema created and that the connection details are set correctly.

3. **Maven** (for dependency management)
   - Install Maven from [here](https://maven.apache.org/download.cgi).

## Steps to Run the Project

### Setup Instructions

Clone the repository:

    git clone https://github.com/DanielFonsecaa/Risk-Monitoring.git
    cd <your-repo-directory>

Database Setup:

Ensure that your database is running and accessible.

Modify the connection details (username, password, database URL) inside DatabaseConnection.java.

Backup Folder:

On the root of the project you'll find a backup.sh script.
Important: Open the backup.sh script and update the path to your backup folder in the script.
For example, you should change:
  
    BACKUP_DIR="/path/to/your/backupDir"

Make sure the database has a trade table with the following structure:

    
    CREATE TABLE trade (
    trade_id INT AUTO_INCREMENT PRIMARY KEY,
    trader_id INT NOT NULL,
    amount FLOAT NOT NULL,
    trade_date DATE NOT NULL
    );

Edit the DatabaseConnection.java file to match your MySQL database connection details:

   
    public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/your-database-name";
    private static final String USER = "your-username";
    private static final String PASSWORD = "your-password";
    }

Build and run the project:

To build the project, run the following command:

    
    mvn clean install

To run the project, execute the main class:

   
    mvn exec:java -Dexec.mainClass="org.example.Main"
or:

    
     mvn spring-boot:run
    
## Usage

Adding a Trade

To add a trade, you need to create a Trade object with the trader ID, amount, and trade date, and then use the TradeDao.addTrade method.

    TradeService tradeService = new TradeService();
    Trade trade = new Trade();
    trade.setTraderId(1);
    trade.setAmount(1200.5);
    trade.setTradeDate(Date.valueOf("2024-12-10"));

    Connection connection = DatabaseConnection.getConnection();
    
    tradeService.addTrade(trade);
    
Viewing All Trades

To view all trades, use the TradeDao.getAllTrades method:

    java
    List<Trade> trades = tradeService.getAllTrades();
    trades.forEach(System.out::println);
    
Calculating Risk

To calculate the risk for a trader, pass the trader's Trade object and connection to the getRisk method:

    java
    Double risk = tradeService.getRisk(trade);
    System.out.println("Risk for trader " + trade.getTraderId() + ": " + risk);

Removing a Trade

To remove a trade, call the TradeDao.removeTrade method with the tradeId:

    java
    boolean isRemoved = tradeDao.removeTrade(tradeId, connection);
    if (isRemoved) {
        System.out.println("Trade removed successfully.");
    } else {
        System.out.println("Failed to remove the trade.");
    }
