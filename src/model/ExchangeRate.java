
package model;

public class ExchangeRate {

    private final Currency to;
    private final Currency from;
    private final double rate;

    public ExchangeRate(Currency to, Currency from, double rate) {
        this.to = to;
        this.from = from;
        this.rate = rate;
    }

    public Currency getTo() {
        return to;
    }

    public Currency getFrom() {
        return from;
    }

    public double getRate() {
        return rate;
    }
}
