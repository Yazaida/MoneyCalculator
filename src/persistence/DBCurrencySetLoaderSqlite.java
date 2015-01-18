package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Currency;
import model.CurrencySet;

public class DBCurrencySetLoaderSqlite implements CurrencySetLoader {

    @Override
    public CurrencySet load() {
        DBConnection connection = new DBConnection();
        CurrencySet currencySet = new CurrencySet();
        try {
            ResultSet resulSet = connection.createConnection("money.db").createStatement().executeQuery("select DISTINCT divisa_desde from cambio_divisas;");
            while (resulSet.next()) {
                addCurrency(resulSet, currencySet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return currencySet;
    }

    private static void addCurrency(ResultSet resulSet, CurrencySet currencySet) throws SQLException {
        currencySet.add(new Currency(resulSet.getString("divisa_desde"), null, null));
    }
}
