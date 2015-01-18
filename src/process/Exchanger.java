package process;

import model.ExchangeRate;
import model.Money;

public class Exchanger {

    public Money exchangeCalculate(Money money, ExchangeRate exchangeRate) {
        Money moneyExchange = new Money(money.getAmount() * exchangeRate.getRate(), exchangeRate.getTo());
        return moneyExchange;
    }
}
