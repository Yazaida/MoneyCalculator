package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Currency;
import model.ExchangeRate;

public class DBExchangeRateLoaderSqlite implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency to, Currency from) {
        if(!to.getCode().equals(from.getCode())){
            return new ExchangeRate(to, from, lookForRaet(to, from));
        }
        return new ExchangeRate(to, from, 1);
        
    }

    private double lookForRaet(Currency to, Currency from) {
        DBConnection connection = new DBConnection();
        try {
            String query = "select rate from cambio_divisas "
                    + "where divisa_desde='" + from.getCode() + "' and divisa_a='" + to.getCode() + "'";
            ResultSet resulSet = connection.createConnection("money.db").createStatement().executeQuery(query);
            while (resulSet.next()) {
                return resulSet.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return 0;
    }

}
