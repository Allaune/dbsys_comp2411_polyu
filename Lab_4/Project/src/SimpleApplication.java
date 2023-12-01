import java.io.*;
import java.io.Console;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import oracle.jdbc.driver.*;
import oracle.sql.*;

public class SimpleApplication {
    public static void main(String args[]) throws SQLException, IOException {
        Console console = System.console();
        System.out.print("Enter your username: ");    // Your Oracle ID with double quote
        String username = console.readLine();         // e.g. "98765432d"
        System.out.print("Enter your password: ");    // Password of your Oracle Account
        char[] password = console.readPassword();
        String pwd = String.valueOf(password);

        // Connection
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        try (OracleConnection connection = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms", username, pwd)) {
            LoadDB(connection);
            // ----------- SHOPPING_CART TABLE ---------------
            /*String insertShoppingCartQuery = "INSERT INTO Shopping_cart (CartID, ProductQuantity, ProductPrice, TotalPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement insertShoppingCartStmt = connection.prepareStatement(insertShoppingCartQuery);
            String[][] shoppingCartValues = {
                    {"C001", "1", "300", null},
                    {"C002", "2", "100", null},
                    {"C003", "15", "10", null},
                    {"C004", "1", "2000", null},
                    {"C005", "2", "270", null},
                    {"C006", "1", "800", null},
                    {"C007", "20", "3", null},
                    {"C008", "5", "20", null},
                    {"C009", "1", "175", null},
                    {"C010", "2", "50", null}
            };
            for (String[] values : shoppingCartValues) {
                insertShoppingCartStmt.setString(1, values[0]);
                insertShoppingCartStmt.setInt(2, Integer.parseInt(values[1]));
                insertShoppingCartStmt.setString(3, values[2]);
                insertShoppingCartStmt.setString(4, values[3]);
                insertShoppingCartStmt.executeUpdate();
            }

            // ------------- ADMINISTRATOR TABLE ---------------
            // Create table Administrator
            String createTableQuery = "CREATE TABLE Administrator (" +
                    "adminID VARCHAR(20) NOT NULL, " +
                    "userName VARCHAR(20) NOT NULL, " +
                    "emailA VARCHAR(20) NOT NULL, " +
                    "PasswordA VARCHAR(20) NOT NULL, " +
                    "PRIMARY KEY (adminID)" +
                    ")";
            Statement createTableStmt = conn.createStatement();
            createTableStmt.executeUpdate(createTableQuery);
            createTableStmt.close();

            String insertAdministratorQuery = "INSERT INTO Administrator (adminID, userName, emailA, PasswordA) VALUES (?, ?, ?, ?)";
            PreparedStatement insertAdministratorStmt = connection.prepareStatement(insertAdministratorQuery);
            String[][] administratorValues = {
                    {"51128d", "ZHANG Dawen", "335338@gmail.com", "51128"},
                    {"51129d", "ZHANG Daqiang", "335339@gmail.com", "51129"},
                    {"51130d", "LI Dawen", "335340@gmail.com", "51130"},
                    {"51131d", "WANG Xiaomei", "335341@gmail.com", "51131"},
                    {"51132d", "LIU Ping", "335342@gmail.com", "51132"},
                    {"51133d", "LI Wen", "335343@gmail.com", "51133"},
                    {"51134d", "WANG Ping", "335344@gmail.com", "51134"},
                    {"51135d", "ZHAO Lei", "335345@gmail.com", "51135"},
                    {"51136d", "SUN Hongli", "335346@gmail.com", "51136"},
                    {"51137d", "WANG Lili", "335347@gmail.com", "51137"}
            };
            for (String[] values : administratorValues) {
                insertAdministratorStmt.setString(1, values[0]);
                insertAdministratorStmt.setString(2, values[1]);
                insertAdministratorStmt.setString(3, values[2]);
                insertAdministratorStmt.setString(4, values[3]);
                insertAdministratorStmt.executeUpdate();
            }

            // --------------- INVENTORIES TABLE --------------------
            String insertInventoriesQuery = "INSERT INTO Inventories (InventoryID, stocklevel, productCategory) VALUES (?, ?, ?)";
            PreparedStatement insertInventoriesStmt = connection.prepareStatement(insertInventoriesQuery);
            String[][] inventoriesValues = {
                    {"S001", "1", "clothes"},
                    {"S002", "2", "fruits"},
                    {"S003", "2", "clothes"},
                    {"S004", "3", "stationary"},
                    {"S005", "2", "fruits"},
                    {"S006", "1", "fruits"},
                    {"S007", "1", "toys"},
                    {"S008", "2", "stationary"},
                    {"S009", "3", "clothes"},
                    {"S010", "1", "toys"}
            };
            for (String[] values : inventoriesValues) {
                insertInventoriesStmt.setString(1, values[0]);
                insertInventoriesStmt.setInt(2, Integer.parseInt(values[1]));
                insertInventoriesStmt.setString(3, values[2]);
                insertInventoriesStmt.executeUpdate();
            }*/

            System.out.println("--------------- DB TABLES and DATA inserted successfully ----------------");
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }




    }

    public static void LoadDB(OracleConnection connection) throws SQLException, ParseException {

        // ----------- SHOPPING_CART TABLE ---------------
        // CREATE TABLE
        System.out.println("------------------ Creating table SHOPPING_CART ---------------------");

        String createTableShopCart = "CREATE TABLE Shopping_cart (" +
                "CartID varchar(20) NOT NULL," +
                "ProductQuantity number(3) NOT NULL," +
                "ProductPrice varchar(10) NOT NULL," +
                "TotalPrice varchar(45) DEFAULT NULL" +
                ")";

        Statement createShoppingStmt = connection.createStatement();
        createShoppingStmt.executeUpdate(createTableShopCart);
        System.out.println("Table SHOPPING_CART created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into SHOPPING_CART ---------------------");
        String insertShoppingCartQuery = "INSERT INTO Shopping_cart (CartID, ProductQuantity, ProductPrice, TotalPrice) VALUES (?, ?, ?, ?)";
        PreparedStatement insertShoppingCartStmt = connection.prepareStatement(insertShoppingCartQuery);
        String[][] shoppingCartValues = {
                {"C001", "1", "300", null},
                {"C002", "2", "100", null},
                {"C003", "15", "10", null},
                {"C004", "1", "2000", null},
                {"C005", "2", "270", null},
                {"C006", "1", "800", null},
                {"C007", "20", "3", null},
                {"C008", "5", "20", null},
                {"C009", "1", "175", null},
                {"C010", "2", "50", null}
        };
        for (String[] values : shoppingCartValues) {
            insertShoppingCartStmt.setString(1, values[0]);
            insertShoppingCartStmt.setInt(2, Integer.parseInt(values[1]));
            insertShoppingCartStmt.setString(3, values[2]);
            insertShoppingCartStmt.setString(4, values[3]);
            insertShoppingCartStmt.executeUpdate();
        }
        System.out.println("Data successfully added to SHOPPING_CART.\n\n");




        // ------------- ADMINISTRATOR TABLE ---------------
        System.out.println("------------------ Creating table ADMINISTRATOR ---------------------");
        // CREATE TABLE
        String createTableAdmin = "CREATE TABLE Administrator (" +
                "adminID VARCHAR(20) NOT NULL, " +
                "userName VARCHAR(20) NOT NULL, " +
                "emailA VARCHAR(20) NOT NULL, " +
                "PasswordA VARCHAR(20) NOT NULL, " +
                "PRIMARY KEY (adminID)" +
                ")";
        Statement createTableStmt = connection.createStatement();
        createTableStmt.executeUpdate(createTableAdmin);
        createTableStmt.close();
        System.out.println("Table ADMINISTRATOR created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table ADMINISTRATOR ---------------------");
        String insertAdministratorQuery = "INSERT INTO Administrator (adminID, userName, emailA, PasswordA) VALUES (?, ?, ?, ?)";
        PreparedStatement insertAdministratorStmt = connection.prepareStatement(insertAdministratorQuery);
        String[][] administratorValues = {
                {"51128d", "ZHANG Dawen", "335338@gmail.com", "51128"},
                {"51129d", "ZHANG Daqiang", "335339@gmail.com", "51129"},
                {"51130d", "LI Dawen", "335340@gmail.com", "51130"},
                {"51131d", "WANG Xiaomei", "335341@gmail.com", "51131"},
                {"51132d", "LIU Ping", "335342@gmail.com", "51132"},
                {"51133d", "LI Wen", "335343@gmail.com", "51133"},
                {"51134d", "WANG Ping", "335344@gmail.com", "51134"},
                {"51135d", "ZHAO Lei", "335345@gmail.com", "51135"},
                {"51136d", "SUN Hongli", "335346@gmail.com", "51136"},
                {"51137d", "WANG Lili", "335347@gmail.com", "51137"}
        };
        for (String[] values : administratorValues) {
            insertAdministratorStmt.setString(1, values[0]);
            insertAdministratorStmt.setString(2, values[1]);
            insertAdministratorStmt.setString(3, values[2]);
            insertAdministratorStmt.setString(4, values[3]);
            insertAdministratorStmt.executeUpdate();
        }
        System.out.println("Data successfully added to ADMINISTRATOR.\n\n");




        // --------------- INVENTORIES TABLE --------------------
        // CREATE TABLE
        System.out.println("------------------ Creating table INVENTORIES ---------------------");
        String createTableQuery = "CREATE TABLE Inventories (" +
                "InventoryID varchar(20) NOT NULL," +
                "stocklevel int NOT NULL," +
                "productCategory varchar(45) NOT NULL," +
                "PRIMARY KEY (InventoryID))";

        Statement createInventoriesStmt = connection.createStatement();
        createInventoriesStmt.executeUpdate(createTableQuery);
        System.out.println("Table INVENTORIES created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Insert data into table INVENTORIES ---------------------");

        String insertInventoriesQuery = "INSERT INTO Inventories (InventoryID, stocklevel, productCategory) VALUES (?, ?, ?)";
        PreparedStatement insertInventoriesStmt = connection.prepareStatement(insertInventoriesQuery);
        String[][] inventoriesValues = {
                {"S001", "1", "clothes"},
                {"S002", "2", "fruits"},
                {"S003", "2", "clothes"},
                {"S004", "3", "stationary"},
                {"S005", "2", "fruits"},
                {"S006", "1", "fruits"},
                {"S007", "1", "toys"},
                {"S008", "2", "stationary"},
                {"S009", "3", "clothes"},
                {"S010", "1", "toys"}
        };
        for (String[] values : inventoriesValues) {
            insertInventoriesStmt.setString(1, values[0]);
            insertInventoriesStmt.setInt(2, Integer.parseInt(values[1]));
            insertInventoriesStmt.setString(3, values[2]);
            insertInventoriesStmt.executeUpdate();
        }
        System.out.println("Data successfully added to INVENTORIES.\n\n");






        // ----------- CUSTOMER_SUPPORT TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table CUSTOMER_SUPPORT ---------------------");
        String createTableCustomerSupport = "CREATE TABLE Customer_supports (" +
                "supportID varchar(20) NOT NULL," +
                "issueState varchar(20) NOT NULL," +
                "createDate date NOT NULL," +
                "issue varchar(45) NOT NULL," +
                "PRIMARY KEY (supportID))";

        Statement createCustSuppStmt = connection.createStatement();
        createCustSuppStmt.executeUpdate(createTableCustomerSupport);
        System.out.println("Table CUSTOMER_SUPPORT created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table CUSTOMER_SUPPORT ---------------------");
        String insertDataCustomerSupport = "INSERT INTO Customer_supports (supportID, issueState, createDate, issue) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement insertCustSuppStmt = connection.prepareStatement(insertDataCustomerSupport);

        String[][] supportData = {
                {"A123", "Progressing", "2023-01-01", "1"},
                {"A124", "Complete", "2023-01-15", "4"},
                {"A125", "Complete", "2023-02-19", "4"},
                {"A126", "Progressing", "2023-03-03", "6"},
                {"A127", "Complete", "2023-04-01", "5"},
                {"A128", "Complete", "2023-04-05", "3"},
                {"A129", "Progressing", "2023-05-10", "5"},
                {"A130", "Progressing", "2023-05-15", "5"},
                {"A131", "Complete", "2023-06-09", "9"},
                {"A132", "Complete", "2023-06-23", "4"}
        };

        for (String[] support : supportData) {
            insertCustSuppStmt.setString(1, support[0]);
            insertCustSuppStmt.setString(2, support[1]);
            insertCustSuppStmt.setDate(3, Date.valueOf(support[2]));
            insertCustSuppStmt.setString(4, support[3]);
            insertCustSuppStmt.addBatch();
        }

        insertCustSuppStmt.executeBatch();
        System.out.println("Data successfully inserted to CUSTOMER_SUPPORT.\n\n");





        // ----------- ORDER_TRACKING TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table ORDER_TRACKING ---------------------");
        String createOrderTrackingTable = "CREATE TABLE Order_tracking(" +
                "trackingID varchar(20) NOT NULL," +
                "trackingStatus varchar(45) NOT NULL," +
                "updateDate varchar(45) NOT NULL," +
                "PRIMARY KEY (trackingID)" +
                ")";

        Statement createOrderTrackStmt = connection.createStatement();
        createOrderTrackStmt.executeUpdate(createOrderTrackingTable);
        System.out.println("Table ORDER_TRACKING created successfully.");

        // INSERT VALUES
        String insertOrderTrackingData = "INSERT INTO Order_tracking VALUES (?, ?, ?)";

        PreparedStatement insertOrderTrackStmt = connection.prepareStatement(insertOrderTrackingData);

        String[][] orderTrackingData = {
                {"T001", "The express has been delivered", "2023-11-15"},
                {"T002", "The express has been delivered", "2023-11-19"},
                {"T003", "The express has been delivered", "2023-11-20"},
                {"T004", "The express has been delivered", "2023-11-21"},
                {"T005", "The express is in transit", "2023-11-23"},
                {"T006", "The express is in transit", "2023-11-23"},
                {"T007", "The express is in transit", "2023-11-24"},
                {"T008", "The express is in transit", "2023-11-25"},
                {"T009", "The express not delivered", "2023-11-26"},
                {"T010", "The express not delivered", "2023-11-27"}
        };

        for (String[] data : orderTrackingData) {
            insertOrderTrackStmt.setString(1, data[0]);
            insertOrderTrackStmt.setString(2, data[1]);
            insertOrderTrackStmt.setDate(3, Date.valueOf(data[2]));
            insertOrderTrackStmt.addBatch();
        }

        insertOrderTrackStmt.executeBatch();
        System.out.println("Data successfully added to ORDER_TRACKING.\n\n");





        // ----------- USER_ACCOUNT TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table USER_ACCOUNT ---------------------");
        String createUserAccountTable = "CREATE TABLE User_Account(" +
                "UserID varchar(20) NOT NULL," +
                "PasswordA varchar(20) NOT NULL," +
                "JoinDate date NOT NULL," +
                "FirstName varchar(10) NOT NULL," +
                "LastName varchar(10) NOT NULL," +
                "Email varchar(30) DEFAULT NULL," +
                "PRIMARY KEY (UserID)" +
                ")";

        Statement createUserAccStmt = connection.createStatement();
        createUserAccStmt.executeUpdate(createUserAccountTable);

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table USER_ACCOUNT ---------------------");
        String insertUserAccountData = "INSERT INTO User_Account VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement insertUserAccStmt = connection.prepareStatement(insertUserAccountData);

        String[][] userAccountData = {
                {"111111", "123456", "2023-01-01", "Yifan", "Qi", "123456789@gmail.com"},
                {"111112", "123457", "2023-01-02", "Ruojia", "Zhu", "123456788@gmail.com"},
                {"111113", "123458", "2023-01-02", "Yuhan", "Hu", "123456787@gmail.com"},
                {"111114", "123459", "2023-01-03", "Si", "Li", "123456786@gmail.com"},
                {"111115", "123460", "2023-01-04", "San", "Zhang", "123456785@gmail.com"},
                {"111116", "123461", "2023-01-05", "Wu", "Wang", "123456784@gmail.com"},
                {"111117", "1234562", "2023-03-18", "Mei", "Xiao", "12345683@gmail.com"},
                {"111118", "1234563", "2023-03-20", "Qiang", "Xiao", "123456782@gmail.com"},
                {"111119", "1234564", "2023-03-23", "Hong", "Xiao", "123456781@gmail.com"},
                {"111120", "1234565", "2023-04-01", "Lihong", "Wang", "123456780@gmail.com"}
        };

        for (String[] data : userAccountData) {
            insertUserAccStmt.setString(1, data[0]);
            insertUserAccStmt.setString(2, data[1]);
            insertUserAccStmt.setDate(3, Date.valueOf(data[2]));
            insertUserAccStmt.setString(4, data[3]);
            insertUserAccStmt.setString(5, data[4]);
            insertUserAccStmt.setString(6, data[5]);
            insertUserAccStmt.addBatch();
        }

        insertUserAccStmt.executeBatch();
        System.out.println("Data successfully added to USER_ACCOUNT.\n\n");






        // ----------- PRODUCTS TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table PRODUCTS ---------------------");
        String createTableProducts = "CREATE TABLE Products (" +
                "ProductID varchar(20) NOT NULL," +
                "Specification varchar(45) NOT NULL," +
                "ProductName varchar(45) NOT NULL," +
                "Reviews varchar(45) NOT NULL," +
                "Category varchar(45) NOT NULL," +
                "Price varchar(45) NOT NULL," +
                "description varchar(45) NOT NULL," +
                "PRIMARY KEY (ProductID))";

        Statement createProductsStmt = connection.createStatement();
        createProductsStmt.executeUpdate(createTableProducts);
        System.out.println("Table PRODUCTS created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table PRODUCTS ---------------------");
        String insertDataProducts = "INSERT INTO Products (ProductID, Specification, ProductName, Reviews, Category, Price, description) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement insertProductsStmt = connection.prepareStatement(insertDataProducts);

        String[][] productsData = {
                {"P1", "s", "A1003", "4.4/5", "Clothes", "$300", "Spring clothes"},
                {"P2", "m", "A1004", "4.5/5", "Clothes", "$400", "Summer dress"},
                {"P3", "l", "A1005", "4.2/5", "Clothes", "$500", "Autumn shirt"},
                {"P4", "m", "A1006", "3.5/5", "Clothes", "$600", "Down jacket"},
                {"P5", "xl", "A1007", "4.0/5", "Clothes", "$250", "trousers"},
                {"P6", "m", "A1008", "4.9/5", "Clothes", "$350", "T-shirt"},
                {"P7", "l", "A1009", "4.5/5", "Clothes", "$450", "shirt"},
                {"P8", "s", "A1010", "4.6/5", "Clothes", "$500", "trousers"},
                {"P9", "xxl", "A1011", "3.9/5", "Clothes", "$350", "coat"},
                {"P10", "m", "A1012", "4.4/5", "Clothes", "$450", "dress"}
        };

        for (String[] data : productsData) {
            insertProductsStmt.setString(1, data[0]);
            insertProductsStmt.setString(2, data[1]);
            insertProductsStmt.setString(3, data[2]);
            insertProductsStmt.setString(4, data[3]);
            insertProductsStmt.setString(5, data[4]);
            insertProductsStmt.setString(6, data[5]);
            insertProductsStmt.setString(7, data[6]);
            insertProductsStmt.addBatch();
        }

        insertProductsStmt.executeBatch();
        System.out.println("Data successfully added to PRODUCTS.\n\n");






        // ----------- ADDRESS TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table ADDRESS ---------------------");
        String createTableAddress = "CREATE TABLE Address (" +
                "RecipientName varchar(45) NOT NULL," +
                "Postal int NOT NULL," +
                "Country varchar(20) NOT NULL," +
                "State varchar(20) NOT NULL," +
                "City varchar(45) NOT NULL," +
                "Street varchar(45) DEFAULT NULL)";

        Statement createAddressStmt = connection.createStatement();
        createAddressStmt.executeUpdate(createTableAddress);
        System.out.println("Table ADDRESS created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table ADDRESS ---------------------");
        String insertDataAddress = "INSERT INTO Address (RecipientName, Postal, Country, State, City, Street) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement insertAddressStmt = connection.prepareStatement(insertDataAddress);

        String[][] addressData = {
                {"A", "75000", "France", "Europe", "Paris", "Rue de la Tour Eiffel"},
                {"B", "30290", "France", "Europe", "Laudun", "Rue du commerce"},
                {"C", "30200", "France", "Europe", "Bagnols", "Rue de la republique"},
                {"D", "99230", "Hong Kong", "Asia", "Hong Kong", "Nathan road"},
                {"E", "31000", "France", "Europe", "Toulouse", "Allee des sciences appliquees"},
                {"F", "26000", "France", "Europe", "Valence", "Rue Rabelais"},
                {"G", "38000", "France", "Europe", "Grenoble", "Rue Raoul Blanchard"},
                {"H", "34000", "France", "Europe", "Montpellier", "Rue Seigneurs"},
                {"I", "69000", "France", "Europe", "Lyon", "Boulevard de la Croix-Rousse"},
                {"J", "33000", "France", "Europe", "Bordeaux", "Rue Bradley"}
        };

        for (String[] data : addressData) {
            insertAddressStmt.setString(1, data[0]);
            insertAddressStmt.setString(2, data[1]);
            insertAddressStmt.setString(3, data[2]);
            insertAddressStmt.setString(4, data[3]);
            insertAddressStmt.setString(5, data[4]);
            insertAddressStmt.setString(6, data[5]);
            insertAddressStmt.addBatch();
        }

        insertAddressStmt.executeBatch();
        System.out.println("Data successfully added to ADDRESS.\n\n");





        // ----------- ORDERS TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table ORDERS ---------------------");
        String createTableOrders = "CREATE TABLE Orders (" +
                "OrderID number(8) NOT NULL," +
                "Payment varchar(45) DEFAULT NULL," +
                "Status varchar(45) DEFAULT NULL," +
                "OrderDate varchar(45) DEFAULT NULL," +
                "PRIMARY KEY (OrderID))";

        String createSequence = "CREATE SEQUENCE OrderID_Seq START WITH 1 INCREMENT BY 1";

        String createTrigger = "CREATE OR REPLACE TRIGGER Orders_BI" +
                "  BEFORE INSERT ON Orders" +
                "  FOR EACH ROW" +
                "  BEGIN" +
                "    SELECT OrderID_Seq.NEXTVAL INTO :new.OrderID FROM dual;" +
                "  END;";

        Statement createOrdersStmt = connection.createStatement();
        createOrdersStmt.executeUpdate(createTableOrders);
        createOrdersStmt.executeUpdate(createSequence);
        createOrdersStmt.executeUpdate(createTrigger);
        System.out.println("Table ORDERS created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table ORDERS ---------------------");
        String insertDataOrders = "INSERT INTO Orders (OrderID, Payment, Status, OrderDate) VALUES (?, ?, ?, ?)";

        PreparedStatement insertOrdersStmt = connection.prepareStatement(insertDataOrders);

        String[][] ordersData = {
                {"01", "Alipay", "Paid", "2023-11-27"},
                {"02", "WeChat Pay", "Pending", "2023-11-28"},
                {"03", "Credit Card", "Paid", "2023-11-29"},
                {"04", "Alipay", "Pending", "2023-11-30"},
                {"05", "Alipay", "Paid", "2023-12-01"},
                {"06", "PayPal", "Paid", "2023-12-02"},
                {"07", "WeChat Pay", "Paid", "2023-12-03"},
                {"08", "WeChat Pay", "Paid", "2023-12-04"},
                {"09", "Alipay", "Paid", "2023-12-05"},
                {"10", "Alipay", "Paid", "2023-12-06"}
        };

        for (String[] data : ordersData) {
            insertOrdersStmt.setString(1, data[0]);
            insertOrdersStmt.setString(2, data[1]);
            insertOrdersStmt.setString(3, data[2]);

            // Formatage de la valeur de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date orderDate = new Date(dateFormat.parse(data[3]).getTime());
            insertOrdersStmt.setDate(4, orderDate);

            insertOrdersStmt.addBatch();
        }

        insertOrdersStmt.executeBatch();
        System.out.println("Data successfully added to ORDERS.\n\n");

        // Closing resources
        insertOrdersStmt.close();




        // ----------- REPORT TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table REPORT ---------------------");
        String createReportTableQuery = "CREATE TABLE Report (" +
                "ReportID varchar(10) NOT NULL," +
                "ReportDate varchar(45) NOT NULL)";

        Statement createReportStmt = connection.createStatement();
        createReportStmt.executeUpdate(createReportTableQuery);
        System.out.println("Table REPORT created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table REPORT ---------------------");
        String insertReportDataQuery = "INSERT INTO Report (ReportID, ReportDate) VALUES (?, ?)";

        PreparedStatement insertReportStmt = connection.prepareStatement(insertReportDataQuery);

        String[][] reportData = {
                {"R100", "2023-01-31"},
                {"R101", "2023-02-28"},
                {"R102", "2023-03-31"},
                {"R103", "2023-04-30"},
                {"R104", "2023-05-31"},
                {"R105", "2023-06-30"},
                {"R106", "2023-07-31"},
                {"R107", "2023-08-31"},
                {"R108", "2023-09-30"},
                {"R109", "2023-10-31"}
        };

        for (String[] data : reportData) {
            insertReportStmt.setString(1, data[0]);
            insertReportStmt.setString(2, data[1]);

            // Formatage de la valeur de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date reportDate = new Date(dateFormat.parse(data[1]).getTime());
            insertReportStmt.setDate(2, reportDate);

            insertReportStmt.addBatch();
        }

        insertReportStmt.executeBatch();
        System.out.println("Data successfully added to REPORT.\n\n");





        // ----------- WATCHLIST TABLE --------------
        // CREATE TABLE
        System.out.println("------------------ Creating table WATCHLIST ---------------------");
        String createWatchlistTableQuery = "CREATE TABLE Watchlist (" +
                "ListDate varchar(45) NOT NULL)";

        Statement createWatchlistStmt = connection.createStatement();
        createWatchlistStmt.executeUpdate(createWatchlistTableQuery);
        System.out.println("Table Watchlist created successfully.");

        // INSERT VALUES
        System.out.println("------------------ Inserting data into table WATCHLIST ---------------------");
        String insertWatchlistDataQuery = "INSERT INTO Watchlist (ListDate) VALUES (?)";

        PreparedStatement insertWatchlistStmt = connection.prepareStatement(insertWatchlistDataQuery);

        String[] watchlistData = {
                "2023-01-20",
                "2023-02-20",
                "2023-04-20",
                "2023-06-20",
                "2023-07-20",
                "2023-08-20",
                "2023-09-20",
                "2023-09-21",
                "2023-09-22",
                "2023-09-23"
        };

        for (String data : watchlistData) {
            insertWatchlistStmt.setString(1, data);

            // Formatage de la valeur de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date watchListDate = new Date(dateFormat.parse(data).getTime());
            insertWatchlistStmt.setDate(1, watchListDate);

            insertWatchlistStmt.addBatch();
        }

        insertWatchlistStmt.executeBatch();
        System.out.println("Data successfully added to WATCHLIST.");
    }
}