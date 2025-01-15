public class Main {
    public static void main(String[] args) {
        TableRecords table = new TableRecords();
        table.addTable();
        table.addTable();
        table.editColumn();
        table.displayAllTables();
        table.findTablesWithSimilarColumns();
        table.removeColumn();
    }
}
