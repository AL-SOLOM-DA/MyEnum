public interface Columnable {
    //Возвращает полное имя колонки
    String getColumnName();

    //Возвращает true если колонка видимая
    boolean isShown();

    //Скрывает колонку - маскирует колонку -1 в массиве realOrder.
    //Сдвигает индексы отображаемых колонок, которые идут после скрытой

    void hide();

    //Возвращает порядок константы в enum
    int ordinal();
}
