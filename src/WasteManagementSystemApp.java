import java.util.Arrays;
import java.util.List;

public class WasteManagementSystemApp {
    public static void main(String[] args) {
        // The Client creates the main WasteManagementChain (which sets up the concrete handlers)
        WasteManagementChain systemChain = new WasteManagementChain();

        // The Client creates WasteContainers
        List<WasteContainer> containers = Arrays.asList(
                new WasteContainer("Organic", 50, true),
                new WasteContainer("Hazardous", 20, true),
                new WasteContainer("Recyclable", 100, true),
                new WasteContainer("Unknown", 10, true), // Edge case test
                new WasteContainer("Organic", 30, false) // Not full test
        );

        // Process the containers
        System.out.println("--- Starting Automated Waste Collection ---");
        for (WasteContainer container : containers) {
            System.out.println("\nChecking: " + container);
            if (container.isFull()) {
                systemChain.collect(container);
            } else {
                System.out.println("Status: Container is not full yet. Skipping collection.");
            }
        }
    }
}
