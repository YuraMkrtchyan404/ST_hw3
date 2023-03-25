public class Car {
    private String make;
    private String model;
    private int year;
    private boolean isRunning;
    private int speed;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRunning = false;
    }

    public String start() {
        if (!isRunning) {
            setRunning(true);
            setSpeed(0);
            return "Starting the car...";
        } else {
            return "The car is already running.";
        }
    }

    public String stop() {
        if (isRunning) {
            setRunning(false);
            setSpeed(0);
            return "Stopping the car...";
        } else {
            return "The car is already stopped.";
        }
    }

    public String accelerate(int speed) {
        if (isRunning) {
            if (speed > 0 && speed <= 100) {
                setSpeed(speed);
                return "Accelerating to " + speed + " km/h";
            } else {
                return "Invalid speed. Please enter a speed between 1 and 100 km/h.";
            }
        } else {
            return "The car is not running. Please start the car first.";
        }
    }

    public String brake() {
        if (isRunning) {
            setSpeed(0);
            return "Applying the brakes...";
        } else {
            return "The car is not running. Please start the car first.";
        }
    }
}
