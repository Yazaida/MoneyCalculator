package swing;

import model.Currency;
import ui.ExchangeDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationFrame extends JFrame {

    private final Currency[] currencies;
    private ActionListener actionListener;
    private ExchangeDialog exchangeDialog;

    public ApplicationFrame(Currency[] currencies) throws HeadlessException {
        this.currencies = currencies;
        this.setTitle("Money calculator");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createWidgets();
        this.setVisible(true);
    }

    public ExchangeDialog getExchangeDialog() {
        return exchangeDialog;
    }

    private void createWidgets() {
        this.add(createToolBar(), BorderLayout.SOUTH);
        this.add(createExchangeDialogPanel());
    }

    private Component createExchangeDialogPanel() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencies);
        this.exchangeDialog = panel;
        return panel;
    }

    private JPanel createToolBar() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpanel.add(createCalculateButton());
        jpanel.add(createExitButton());
        return jpanel;
    }

    private Component createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });
        return button;
    }

    private JButton createExitButton() {
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return exit;
    }

    public void register(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
