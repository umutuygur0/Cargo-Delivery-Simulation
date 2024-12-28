class City {
    String name;
    Stack<Cargo> cargoStack = new Stack<>();
    Queue<Vehicle> vehicleQueue = new Queue<>();

    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Packages:\n" + cargoStack + "\nVehicles:\n" + vehicleQueue;
    }
}

