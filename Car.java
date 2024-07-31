class Car {
    private String make;
    private String model;
    private int year;
    private double price;
    private String engineType;
    private int numberOfDoors;

    public Car(String make, String model, int year, double price, String engineType, int numberOfDoors) {
        this.make = make;
        this.model = model;
        this.engineType = engineType;
        
        if (price < 0) {
            throw new IllegalArgumentException("Car price cannot be negative.");
          } 
        else {
            this.price = price;
          }   
        
        if (year> 2024 | year < 2000) {
            throw new IllegalArgumentException("Car year must be between 2000 and 2024.");
          }
        else {
            this.year = year; 
        }
        
        if (numberOfDoors == 2 || numberOfDoors == 4) {
        	this.numberOfDoors = numberOfDoors;
        }
        else {
            throw new IllegalArgumentException("Number of doors must be 2 or 4.");

        }
        	
    }

    public String getMake() {return make; }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() { return price;}

    public void setPrice(double price) { this.price = price; }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + ", $" + price + ", Engine: " + engineType + ", Doors: " + numberOfDoors;
    }
}
