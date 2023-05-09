import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuMcDonalds extends JFrame implements ActionListener {

    private double totalPrice = 0.0;
    private Map<String, Double> itemPrices = new HashMap<>();
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private JLabel priceLabel = new JLabel("Total: " + currencyFormat.format(totalPrice));

    public MenuMcDonalds() {
        setTitle("Menú de McDonald's");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar los precios de los productos
        itemPrices.put("Big Mac", 4.99);
        itemPrices.put("McExtreme", 5.99);
        itemPrices.put("McNífica", 6.99);
        itemPrices.put("McPollastre", 3.99);
        itemPrices.put("Coca-Cola", 1.99);
        itemPrices.put("Fanta", 1.99);
        itemPrices.put("Aigua", 0.99);
        itemPrices.put("McFlurry", 2.99);
        itemPrices.put("Gelat Vainilla", 1.99);

        // Crear los paneles de los botones
        JPanel panelHamburguesas = new JPanel(new GridLayout(0, 1));
        JPanel panelBebidas = new JPanel(new GridLayout(0, 1));
        JPanel panelPostres = new JPanel(new GridLayout(0, 1));

        // Crear los botones de hamburguesas
        addButton(panelHamburguesas, "Big Mac");
        addButton(panelHamburguesas, "McExtreme");
        addButton(panelHamburguesas, "McNífica");
        addButton(panelHamburguesas, "McPollastre");

        // Crear los botones de bebidas
        addButton(panelBebidas, "Coca-Cola");
        addButton(panelBebidas, "Fanta");
        addButton(panelBebidas, "Aigua");

        // Crear los botones de postres
        addButton(panelPostres, "McFlurry");
        addButton(panelPostres, "Gelat Vainilla");

        // Crear el panel de precios
        JPanel panelPrecios = new JPanel(new BorderLayout());
        panelPrecios.add(priceLabel, BorderLayout.CENTER);

        // Crear el botón para finalizar la compra y reiniciar el precio total
        JButton finishButton = new JButton("Finalitzar compra");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalPrice = 0.0;
                priceLabel.setText("Total: " + currencyFormat.format(totalPrice));
            }
        });
        panelPrecios.add(finishButton, BorderLayout.EAST);

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel(new GridLayout(0, 3));
        panelPrincipal.add(panelHamburguesas);
        panelPrincipal.add(panelBebidas);
        panelPrincipal.add(panelPostres);

        // Agregar los paneles al marco
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelPrecios, BorderLayout.SOUTH);
    }

    private void addButton(JPanel panel, String text) {
        JButton button = new JButton(text + " - " + currencyFormat.format(itemPrices.get(text)));
        button.addActionListener(this);
        panel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        double itemPrice = itemPrices.get(buttonText.substring(0, buttonText.indexOf(" - ")));
        totalPrice += itemPrice;
        priceLabel.setText("Total: " + currencyFormat.format(totalPrice));
    }

    public static void main(String[] args) {
        MenuMcDonalds menu = new MenuMcDonalds();
            menu.setVisible(true);
        }
    }