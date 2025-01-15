import java.util.TreeMap;

public class Table {
    int tableId;
    String tableName;
    TreeMap<Integer, Column> columns;

    public Table(){
        this.columns = new TreeMap<>();
    }

    public Table(int tableId, String tableName, TreeMap<Integer, Column> columns){
        this.tableId = tableId;
        this.tableName = tableName;
        this.columns = columns != null ? columns : new TreeMap<>();
    }
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public TreeMap<Integer, Column> getColumns() {
        return columns;
    }

    public void setColumns(TreeMap<Integer, Column> columns) {
        this.columns = columns;
    }
}
