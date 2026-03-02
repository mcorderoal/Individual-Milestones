import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Hito1 extends JFrame {

    public Hito1() {

        setTitle("Hito1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);

        setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new FlowLayout());
        panelNorte.add(new JCheckBox("Katniss"));
        panelNorte.add(new JCheckBox("Peeta"));
        add(panelNorte, BorderLayout.NORTH);

        JPanel panelEste = new JPanel(null);
        panelEste.setPreferredSize(new Dimension(250, 0));

        String[] nombres = {"OPT 1", "OPT 2", "OPT 3"};
        JRadioButton[] radios = new JRadioButton[3];
        ButtonGroup grupo = new ButtonGroup();

        for (int i = 0; i < radios.length; i++) {
            radios[i] = new JRadioButton(nombres[i]);
            radios[i].setBounds(20, 50 + (i * 30), 100, 30);
            grupo.add(radios[i]);
            panelEste.add(radios[i]);
        }
        radios[0].setSelected(true);
        add(panelEste, BorderLayout.EAST);

        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.X_AXIS));
        panelSur.setPreferredSize(new Dimension(0, 50));
        panelSur.add(new JButton("But 1"));
        panelSur.add(new JButton("But 2"));
        add(panelSur, BorderLayout.SOUTH);

        JPanel panelCentro = new JPanel(new GridLayout(2, 2, 5, 5)); // 2x2 con gaps

        ImageIcon iconoOriginal = null;
        try {
            URL urlImagen = new URL("https://www.jardineromadrid.es/wp-content/uploads/2024/04/como-cuidar-tulipanes.jpg");
            iconoOriginal = new ImageIcon(urlImagen);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            for (int i = 0; i < 4; i++) panelCentro.add(new JLabel("Error imagen"));
        }

        if (iconoOriginal != null) {
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

            for (int i = 0; i < 4; i++) {
                JLabel etiquetaImagen = new JLabel(iconoEscalado);
                etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);
                panelCentro.add(etiquetaImagen);
            }
        }

        add(panelCentro, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Hito1().setVisible(true);
        });
    }
}