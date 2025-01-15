# Java Maps Two
## Create a Column class with the following fields and include appropriate constructors, getters, setters: 
```
- Int columnId
- String columnName
- String dataType
```
## Create a Table class with the following fields and include appropriate constructors, getters, setters: 
```
- Int tableId
- String tableName
- Map<Integer, Column> columns
For the Columns, the key is the column position.
```
### Create a Map, Map<String, Table> tables to hold all the Table records: 
```
The key is the table name.
```
### NB: Make sure the Maps you use in this exercise lexicographically order their keys i.e. maintain the order of its keys from lowest to highest. 
The following are a list of functionalities to achieve: 
1. Add New Table and its columns 
2. Add/Edit/Remove column in a par cular table. 
3. Get Tables which have similar-named columns e.g. date_created 
4. Display All Tables and their columns
