# Relative Account Balance Utility

It is a utility to find relative balance for account between a time period

## How to run

Using Jar - use below command to pass arguments (csv_file_path, account_id, from_date_time, to_date_time) and run

```bash
java -jar AnalyseFinancialTransaction-1.0-SNAPSHOT-shaded.jar <csv_file_path> <account_id>, <from_date_time>, <to_date_time>
```
Using main class - update the arguments as below (csv_file_path, account_id, from_date_time, to_date_time) and run
```bash
String path = "<csv_file_path>";
String accountId = "<account_id>";
String from = "<from_date_time>";
String to = "<to_date_time>";
```