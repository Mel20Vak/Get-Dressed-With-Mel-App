public class FashionApp {
    public static void main(String[] args) {
        // Launch the GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EnhancedAppGUI appGUI = new EnhancedAppGUI();
                appGUI.createAndShowGUI();
            }
        });
    }
}
