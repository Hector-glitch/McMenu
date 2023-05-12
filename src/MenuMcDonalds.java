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
    private final Map<String, Double> itemPrices = new HashMap<>();
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private final JLabel priceLabel = new JLabel("Total: " + currencyFormat.format(totalPrice));

    public MenuMcDonalds() {
        setTitle("Menú de McDonald's");
        setSize(500, 400);
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
        itemPrices.put("Poma Podrida", 5.00);

        // Crear los paneles de los botones
        JPanel panelHamburguesas = new JPanel(new GridLayout(0, 1));
        JPanel panelBegudes = new JPanel(new GridLayout(4, 1));
        JPanel panelPostres = new JPanel(new GridLayout(4, 1));

        JLabel labelHamburguesas = new JLabel("Hamburguesas");
        labelHamburguesas.setHorizontalAlignment(JLabel.CENTER);

        // Crear los botones de hamburguesas
        panelHamburguesas.add(labelHamburguesas, BorderLayout.NORTH);
        addButton(panelHamburguesas, "Big Mac");
        addButton(panelHamburguesas, "McExtreme");
        addButton(panelHamburguesas, "McNífica");

        JLabel labelBegudes = new JLabel("Begudes");
        labelBegudes.setHorizontalAlignment(JLabel.CENTER);

        // Crear los botones de bebidas
        panelBegudes.add(labelBegudes, BorderLayout.NORTH);
        addButton(panelBegudes, "Coca-Cola");
        addButton(panelBegudes, "Fanta");
        addButton(panelBegudes, "Aigua");

        JLabel labelPostres = new JLabel("Postres");
        labelPostres.setHorizontalAlignment(JLabel.CENTER);

        // Crear los botones de postres
        panelPostres.add(labelPostres, BorderLayout.NORTH);
        addButton(panelPostres, "McFlurry");
        addButton(panelPostres, "Gelat Vainilla");
        addButton(panelPostres, "Poma Podrida");

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
        JPanel panelPrincipal = new JPanel(new GridLayout(3, 4));
        panelPrincipal.add(panelHamburguesas);
        panelPrincipal.add(panelBegudes);
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