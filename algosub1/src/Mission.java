import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Mission {
    String source, middle, destination;
    int cargoFromSource, cargoFromMiddle;
    List<Integer> cargoDropIndices;

    public Mission(String missionLine) {
        String[] parts = missionLine.split("-");
        source = parts[0];
        middle = parts[1];
        destination = parts[2];
        String[] cargoParts = parts[3].split(",");
        cargoFromSource = Integer.parseInt(cargoParts[0]);
        cargoFromMiddle = Integer.parseInt(cargoParts[1]);
        cargoDropIndices = Arrays.stream(parts[4].split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void execute(Map<String, City> cities) {
        City sourceCity = cities.get(source);
        City middleCity = cities.get(middle);
        City destinationCity = cities.get(destination);

        // Get the vehicle from source city
        Vehicle vehicle = sourceCity.vehicleQueue.dequeue();

        // Load cargo from source city
        for (int i = 0; i < cargoFromSource; i++) {
            vehicle.loadCargo(sourceCity.cargoStack.pop());
        }

        // Load cargo from middle city
        for (int i = 0; i < cargoFromMiddle; i++) {
            vehicle.loadCargo(middleCity.cargoStack.pop());
        }

        // Drop specific cargos at the middle city
        for (int index : cargoDropIndices) {
            vehicle.unloadCargo(middleCity.cargoStack.pop());
        }

        // Drop the vehicle at the destination city
        destinationCity.vehicleQueue.enqueue(vehicle);
    }
}
