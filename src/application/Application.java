package application;

import console.ExchangeDisplay;
import control.ExchangeOperation;
import model.CurrencySet;
import swing.ApplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import persistence.DBCurrencySetLoaderSqlite;

public class Application {

    public static void main(String[] args) throws SQLException {
        CurrencySet currencySet = new DBCurrencySetLoaderSqlite().load();

        final ApplicationFrame frame = new ApplicationFrame(currencySet.toArray());
        frame.register(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExchangeOperation(frame.getExchangeDialog(), new ExchangeDisplay()).execute();
            }
        });
    }
}
