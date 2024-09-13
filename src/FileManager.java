import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public void createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.createNewFile()) {
            System.out.println("File created: " + filePath);
        } else {
            System.out.println("File already exists.");
        }
    }

    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Deleted the file: " + filePath);
            return true;
        } else {
            System.out.println("Failed to delete the file.");
            return false;
        }
    }

    public String readFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public void writeToFile(String filePath, String data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(data);
        }
    }

    public void writeCustomerToFile(String filePath, Customer customer) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            String customerData = "Customer ID: " + customer.getId() +
                    "\nName: " + customer.getName() +
                    "\nEmail: " + customer.getLastName() +
                    "\n";
            bw.write(customerData);
        }
    }

    public String readCustomersFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
