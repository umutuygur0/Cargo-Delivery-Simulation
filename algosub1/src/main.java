import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        Map<String, City> cities = new HashMap<>();
        List<Mission> missions = new ArrayList<>();

        // Reading input from the files
        readCities(cities, "cities.txt");
        readPackages(cities, "packages.txt");
        readVehicles(cities, "vehicles.txt");
        readMissions(missions, "missions.txt");

        // Execute each mission
        for (Mission mission : missions) {
            mission.execute(cities);
        }

        // Write final results to result.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            for (City city : cities.values()) {
                writer.write(city.name + "\n");
                writer.write(city.toString() + "\n");
                writer.write("-------------\n");
            }
        }
    }

    // Method to read the cities from cities.txt
    public static void readCities(Map<String, City> cities, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cities.put(line, new City(line));  // Add each city to the cities map
            }
        }
    }

    // Method to read packages from packages.txt
    public static void readPackages(Map<String, City> cities, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String packageId = parts[0];
                String cityName = parts[1];
                Cargo cargo = new Cargo(packageId);
                cities.get(cityName).cargoStack.push(cargo);  // Add each package to the respective city's cargo stack
            }
        }
    }

    // Method to read vehicles from vehicles.txt
    public static void readVehicles(Map<String, City> cities, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String vehicleId = parts[0];
                String cityName = parts[1];
                double capacity = Double.parseDouble(parts[2]); // Currently unused, but could be added for extra functionality
                Vehicle vehicle = new Vehicle(vehicleId);
                cities.get(cityName).vehicleQueue.enqueue(vehicle);  // Add each vehicle to the respective city's vehicle queue
            }
        }
    }

    // Method to read missions from missions.txt
    public static void readMissions(List<Mission> missions, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                missions.add(new Mission(line));  // Add each mission to the mission list
            }
        }
    }
}
