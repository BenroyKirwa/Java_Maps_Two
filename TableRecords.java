import java.util.Scanner;
import java.util.TreeMap;

public class TableRecords {
    private TreeMap<String, Table> tableRecords;
    private Scanner scanner;

    public TableRecords() {
        this.tableRecords = new TreeMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addTable() {
        System.out.print("Enter table ID: ");
        int tableId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();

        if (tableRecords.containsKey(tableName)) {
            System.out.println("Table with this name already exists!");
            return;
        }

        Table newTable = new Table(tableId, tableName, new TreeMap<>());

        // Add columns
        System.out.print("Enter number of columns to add: ");
        int numColumns = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numColumns; i++) {
            addColumnToTable(newTable);
        }

        tableRecords.put(tableName, newTable);
        System.out.println("Table added successfully!");
    }

    public void addColumnToTable(String tableName) {
        Table table = tableRecords.get(tableName);
        if (table == null) {
            System.out.println("Table not found!");
            return;
        }
        addColumnToTable(table);
    }

    private void addColumnToTable(Table table) {
        System.out.print("Enter column ID: ");
        int columnId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter column name: ");
        String columnName = scanner.nextLine();

        System.out.print("Enter data type: ");
        String dataType = scanner.nextLine();

        System.out.print("Enter column position: ");
        int position = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Column newColumn = new Column(columnId, columnName, dataType);
        table.getColumns().put(position, newColumn);
        System.out.println("Column added successfully!");
    }

    public void editColumn() {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();

        Table table = tableRecords.get(tableName);
        if (table == null) {
            System.out.println("Table not found!");
            return;
        }

        System.out.print("Enter column position to edit: ");
        int position = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (!table.getColumns().containsKey(position)) {
            System.out.println("Column position not found!");
            return;
        }

        // Get new values
        System.out.print("Enter new column ID (or -1 to keep current): ");
        int columnId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter new column name (or press Enter to keep current): ");
        String columnName = scanner.nextLine();

        System.out.print("Enter new data type (or press Enter to keep current): ");
        String dataType = scanner.nextLine();

        Column column = table.getColumns().get(position);
        if (columnId != -1) column.setColumnId(columnId);
        if (!columnName.isEmpty()) column.setColumnName(columnName);
        if (!dataType.isEmpty()) column.setDataType(dataType);

        System.out.println("Column updated successfully!");
    }

    public void removeColumn() {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();

        Table table = tableRecords.get(tableName);
        if (table == null) {
            System.out.println("Table not found!");
            return;
        }

        System.out.print("Enter column position to remove: ");
        int position = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (table.getColumns().remove(position) != null) {
            System.out.println("Column removed successfully!");
        } else {
            System.out.println("Column position not found!");
        }
    }

    public void findTablesWithSimilarColumns() {
        System.out.print("Enter column name to search: ");
        String columnName = scanner.nextLine();

        boolean found = false;
        for (String tableName : tableRecords.keySet()) {
            Table table = tableRecords.get(tableName);
            for (Column column : table.getColumns().values()) {
                if (column.getColumnName().equals(columnName)) {
                    if (!found) {
                        System.out.println("Tables containing column '" + columnName + "':");
                        found = true;
                    }
                    System.out.println("- " + tableName);
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No tables found with column name: " + columnName);
        }
    }

    public void displayAllTables() {
        if (tableRecords.isEmpty()) {
            System.out.println("No tables exist!");
            return;
        }

        System.out.println("\n=== All Tables and Columns ===");
        for (String tableName : tableRecords.keySet()) {
            Table table = tableRecords.get(tableName);
            System.out.println("\nTable: " + tableName + " (ID: " + table.getTableId() + ")");

            if (table.getColumns().isEmpty()) {
                System.out.println("  No columns");
                continue;
            }

            System.out.println("  Columns:");
            for (Integer position : table.getColumns().keySet()) {
                Column col = table.getColumns().get(position);
                System.out.printf("    Position %d: %s (ID: %d, Type: %s)\n",
                        position, col.getColumnName(), col.getColumnId(), col.getDataType());
            }
        }
        System.out.println();
    }
}