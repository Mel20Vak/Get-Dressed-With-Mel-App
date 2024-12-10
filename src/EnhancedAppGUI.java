import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

public class EnhancedAppGUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private AvatarPanel avatarPanel;
    private Stack<String> selectedItems; // Changed to Stack
    private Queue<String> userHistory;  // Changed to Queue
    private JTextArea historyArea;

    public EnhancedAppGUI() {
        selectedItems = new Stack<>(); // Initialize as Stack
        userHistory = new LinkedList<>(); // Initialize as Queue
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Get Dressed With Mel App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());

        // Modern Tabbed Pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tabbedPane.setBackground(new Color(35, 39, 50));
        tabbedPane.setForeground(Color.WHITE);

        frame.add(tabbedPane, BorderLayout.CENTER);

        // Add "Try On" Panel
        setupTryOnPanel();

        // Add footer
        JLabel footer = new JLabel("Future Fashion © 2024", SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        footer.setOpaque(true);
        footer.setBackground(new Color(25, 27, 35));
        footer.setForeground(Color.LIGHT_GRAY);
        frame.add(footer, BorderLayout.SOUTH);

        // Make frame visible
        frame.setVisible(true);
    }

    private void setupTryOnPanel() {
        JPanel tryOnPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color gradientStart = new Color(45, 52, 67);
                Color gradientEnd = new Color(25, 27, 35);
                GradientPaint gp = new GradientPaint(0, 0, gradientStart, 0, getHeight(), gradientEnd);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        JLabel tryOnLabel = new JLabel(" Virtual Fitting Room", SwingConstants.CENTER);
        tryOnLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        tryOnLabel.setForeground(new Color(0, 245, 255));
        tryOnLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

        String[] clothingItems = {"Red Top", "Green Sweater", "Blue Shirt", "Jeans", "Skirt", "Shorts", "Accessories", "Boots", "Sandals", "Brown Top", "Long Skirt"};
        JList<String> clothingList = new JList<>(clothingItems);
        clothingList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        clothingList.setBackground(new Color(45, 52, 67));
        clothingList.setForeground(Color.WHITE);
        clothingList.setSelectionBackground(new Color(0, 200, 255));
        clothingList.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(clothingList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        avatarPanel = new AvatarPanel();

        JButton tryButton = createButton("Try On", new Color(50, 205, 50), Color.WHITE);
        tryButton.addActionListener(e -> {
            String selected = clothingList.getSelectedValue();
            if (selected != null) {
                selectedItems.push(selected); // Push to Stack
                userHistory.offer(selected); // Enqueue to Queue
                avatarPanel.addClothingLayer(selected);
                updateUserHistory();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an item to try on.", "Selection Required", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton removeButton = createButton("Remove Last Item", new Color(255, 69, 0), Color.WHITE);
        removeButton.addActionListener(e -> {
            if (!selectedItems.isEmpty()) {
                selectedItems.pop(); // Pop from Stack
                avatarPanel.removeClothingLayer();
                updateUserHistory();
            } else {
                JOptionPane.showMessageDialog(frame, "No items to remove.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton checkoutButton = createButton("Checkout", new Color(50, 205, 50), Color.WHITE); // Updated to match "Try On"
        checkoutButton.addActionListener(e -> {
            StringBuilder history = new StringBuilder("Items in your history:\n");
            for (String item : userHistory) { // Iterate over Queue
                history.append(item).append("\n");
            }
            JOptionPane.showMessageDialog(frame, history.toString(), "User History", JOptionPane.INFORMATION_MESSAGE);
        });


        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(tryButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(checkoutButton);

        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.setOpaque(false);
        historyPanel.add(new JLabel("👚 User History:" , SwingConstants.CENTER), BorderLayout.NORTH);


        historyArea = new JTextArea(5, 20);
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        historyArea.setBackground(new Color(45, 52, 67));
        historyArea.setForeground(Color.WHITE);
        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);

        JScrollPane historyScrollPane = new JScrollPane(historyArea);
        historyPanel.add(historyScrollPane, BorderLayout.CENTER);

        tryOnPanel.add(tryOnLabel, BorderLayout.NORTH);
        tryOnPanel.add(historyPanel, BorderLayout.WEST);
        tryOnPanel.add(scrollPane, BorderLayout.CENTER);
        tryOnPanel.add(avatarPanel, BorderLayout.EAST);
        tryOnPanel.add(buttonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab(" ", tryOnPanel);
    }

    private void updateUserHistory() {
        StringBuilder historyText = new StringBuilder();
        for (String item : userHistory) { // Iterate over Queue
            historyText.append(item).append("\n");
        }
        historyArea.setText(historyText.toString());
    }

    private JButton createButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EnhancedAppGUI::new);
    }

    public void createAndShowGUI() {
    }

    class AvatarPanel extends JPanel {
        private final Image avatarImage;
        private final List<Image> clothingLayers;

        public AvatarPanel() {
            this.clothingLayers = new ArrayList<>();
            setPreferredSize(new Dimension(400, 600));

            // Load avatar base image
            String avatarPath = "src/avatar.png";
            avatarImage = loadImage(avatarPath);

            if (avatarImage == null) {
                System.err.println("Error: Could not load avatar image from " + avatarPath);
            }
        }

        private Image loadImage(String relativePath) {
            try {
                return new ImageIcon(relativePath).getImage();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public void addClothingLayer(String item) {
            // Construct the path to clothing image from the 'src' directory
            String imagePath = "src/" + item.toLowerCase().replace(" ", "_") + ".png";
            Image clothingImage = loadImage(imagePath);
            if (clothingImage != null) {
                clothingLayers.add(clothingImage);  // Add clothing image to the layers
                repaint();  // Repaint the panel to display the new layers
            } else {
                System.err.println("Error: Could not load clothing image for " + item + " from " + imagePath);
            }
        }

        public void removeClothingLayer() {
            if (!clothingLayers.isEmpty()) {
                clothingLayers.remove(clothingLayers.size() - 1);
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw avatar
            if (avatarImage != null) {
                g2d.drawImage(avatarImage, 0, 0, getWidth(), getHeight(), this);
            }

            // Draw clothing layers
            for (Image layer : clothingLayers) {
                g2d.drawImage(layer, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
