package console;

import javax.swing.JOptionPane;
import model.Money;

public class ExchangeDisplay implements ui.ExchangeDisplay {

    @Override
    public void display(Money money) {
      JOptionPane.showMessageDialog(null,money.getAmount() + " " + money.getCurrency());  
    }
    
}
