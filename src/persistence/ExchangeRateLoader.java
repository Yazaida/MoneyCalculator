package persistence;

import model.Currency;
import model.ExchangeRate;

public interface ExchangeRateLoader {

    public ExchangeRate load(Currency to, Currency from);
}
