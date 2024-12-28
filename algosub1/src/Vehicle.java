class Vehicle {
    String id;
    DLinkedList<Cargo> cargoList = new DLinkedList<>();

    public Vehicle(String id) {
        this.id = id;
    }

    public void loadCargo(Cargo cargo) {
        cargoList.addLast(cargo);
    }

    public void unloadCargo(Cargo cargo) {
        cargoList.remove(cargo);
    }

    @Override
    public String toString() {
        return "Vehicle " + id + ": " + cargoList;
    }
}
