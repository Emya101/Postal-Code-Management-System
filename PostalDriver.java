import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

// The main driver class for Part B functionality
public class PostalDriver {
    public static void main(String[] args) {
        // Creating a new linked positional chain hash map to store PostalCode objects
        LinkedPositionalChainHashMap<String, PostalCode> postalCodeMap = new LinkedPositionalChainHashMap<>();
        try {
            // Reading data from a file and populating the postalCodeMap
            File file = new File("PartB.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String code = parts[0];
                String area = parts[1];
                String province = parts[2];
                double latitude = Double.parseDouble(parts[3]);
                double longitude = Double.parseDouble(parts[4]);

                // Creating a new PostalCode object and adding it to the map
                PostalCode postalCode = new PostalCode(code, area, province, latitude, longitude);
                postalCodeMap.put(code, postalCode);
            }
            scanner.close();

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Displaying the total number of entries and the number of collisions in the postalCodeMap
        System.out.println("Total number of entries: " + postalCodeMap.size());
        System.out.println("Number of collisions: " + postalCodeMap.getCollisions());

        // Prompting the user to choose the sorting criteria (by code or longitude)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Display by code (C) or Longitude (L) (any other key to quit)");

        // Processing the user's choice and sorting the postal codes accordingly
        String sortBy = scanner.nextLine().toUpperCase();
        switch (sortBy) {
            case "C":
                // Sorting postal codes by code
                LinkedQueue<PostalCode> sortedCodesByCode = sortPostalCodes(postalCodeMap.values(), new DefaultComparator<>());
                printPostalCodes(sortedCodesByCode);
                break;
            case "L":
                // Sorting postal codes by longitude
                LinkedQueue<PostalCode> sortedCodesByLongitude = sortPostalCodes(postalCodeMap.values(), new OrderByLongitude());
                printPostalCodes(sortedCodesByLongitude);
                break;
            default:
                System.out.println("Invalid choice. Quit");
        }
        scanner.close();

        // Demonstrating map operations
        PostalCode existingCode = postalCodeMap.get("V7E");
        System.out.println("Existing Postal Code: " + existingCode);

        // Adding a new PostalCode and updating an existing one
        PostalCode newCode = new PostalCode("V7E", "Supreme Area", "Supreme Province", 9.0, 15.0);
        postalCodeMap.put("V7E", newCode);
        System.out.println("New Postal Code: " + postalCodeMap.get("V7E"));

        // Removing a PostalCode and verifying its absence
        postalCodeMap.remove("V7E");
        System.out.println("Postal Code after Removal: " + postalCodeMap.get("V7E"));
    }

    // Method to sort PostalCode objects using a comparator
    private static LinkedQueue<PostalCode> sortPostalCodes(Iterable<PostalCode> postalCodes, Comparator<PostalCode> comparator) {
        LinkedQueue<PostalCode> queue = new LinkedQueue<>();
        for (PostalCode postalCode : postalCodes) {
            queue.enqueue(postalCode);
        }
        QuickSort.quickSort(queue, comparator);
        return queue;
    }

    // Method to print PostalCode objects from a queue
    private static void printPostalCodes(LinkedQueue<PostalCode> queue) {
        while (!queue.isEmpty()) {
            PostalCode postalCode = queue.dequeue();
            System.out.println(postalCode);
        }
    }
}
