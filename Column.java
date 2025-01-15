public class Column {
    int columnId;
    String columnName, dataType;

    public Column(int columnId, String columnName, String dataType){
        this.columnId = columnId;
        this.columnName = columnName;
        this.dataType = dataType;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}