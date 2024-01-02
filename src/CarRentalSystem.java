
// import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.HashMap;

public class CarRentalSystem {
    HashMap<String, Boolean> car;
    HashMap<String,Car> carDetails;

    public CarRentalSystem() {
        this.car = new HashMap<>();
        this.carDetails=new HashMap<>();
    }

    public void addNewCar(String registrationNumber, Boolean avail, Car carDetails) {
        this.car.put(registrationNumber, avail);
        this.carDetails.put(registrationNumber, carDetails);
    }

    public void deleteCar(String registrationNumber) {
        if (this.car.containsKey(registrationNumber))
            this.car.remove(registrationNumber);
        else {
            System.out.println("Car does not exist");
        }
    }

    public void updateCarDetails(String registrationNumber,Car carDetails){
        if(this.car.containsKey(registrationNumber)){
            this.carDetails.put(registrationNumber, carDetails);
            System.out.println("Car details upadted successfully");
        }
        else{
            System.out.println("Invalid car registration number !!!");
        }
    }
    
    public void displayCarDetails(){
        System.out.println("|--------------Car Details------------|");
        for(HashMap.Entry<String,Car> carss: carDetails.entrySet()){
              System.out.println("Registration number: "+carss.getKey());
              System.out.println("model = "+carss.getValue().model+" color = "+carss.getValue().color + " year = "+carss.getValue().year+ " price = "+carss.getValue().price);
        }
    }
    public void displayAvailableCars() {

        System.out.println("|-------------List of available cars------------|");

        for (HashMap.Entry<String, Boolean> c : car.entrySet()) {
            if (c.getValue() == true) {
                System.out.println(c.getKey());
            }
        }
    }

    public void rentCar(String registrationNumber) {
        if (car.containsKey(registrationNumber) && car.get(registrationNumber)) {
            car.put(registrationNumber, false);
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

 
    public void returnCar(String registrationNumber) {
        if (car.containsKey(registrationNumber) && !car.get(registrationNumber)) {
            car.put(registrationNumber, true); // set availability to true (car is now returned)
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("Invalid return request. Check car registration number.");
        }
    }

}
