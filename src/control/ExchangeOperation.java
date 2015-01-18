package control;

import model.Exchange;
import model.ExchangeRate;
import model.Money;
import persistence.DBExchangeRateLoaderSqlite;
import persistence.ExchangeRateLoader;
import process.Exchanger;
import ui.ExchangeDialog;
import ui.ExchangeDisplay;

public class ExchangeOperation {

    private final ExchangeDialog exchangeDialog;
    private final ExchangeDisplay exchangeDisplay;
    private Money exhangeMoney;

    public ExchangeOperation(ExchangeDialog exchangeDialog, ExchangeDisplay exchangeDiplay) {
        this.exchangeDialog = exchangeDialog;
        this.exchangeDisplay = exchangeDiplay;
    }

    public void execute() {

        Exchange exchange = exchangeDialog.getExchange();
        ExchangeRateLoader exchangeRateLoader = new DBExchangeRateLoaderSqlite();
        ExchangeRate exchangeRate = exchangeRateLoader.load(exchange.getCurrency(), exchange.getMoney().getCurrency());
        Exchanger exchanger = new Exchanger();
        Money moneyExchange = exchanger.exchangeCalculate(exchange.getMoney(), exchangeRate);
        exchangeDisplay.display(moneyExchange);

    }

}
