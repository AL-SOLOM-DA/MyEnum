import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName){
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[index in enum] = порядок отображения; -1, если колонка не отображается
     * @param newOrder новая последовательность колонок в которой они будут отображться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */

    public static void configureColumns(Column...newOrder) {
        realOrder = new int[values().length];
        for (Column column: values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if(column == newOrder[i]){
                    if (isFound){
                        throw new IllegalArgumentException("NO");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурируемом порядке (см. метоа configureColumns)
     * Используется поле realOrder
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns(){
        List<Column> result = new LinkedList<>();
        for (Column column:values()) {
            if(column.isShown()) result.add(column);
        }
        return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return false;
    }

    @Override
    public void hide() {
        
    }
}
