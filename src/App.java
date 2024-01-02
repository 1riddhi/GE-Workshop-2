public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        CarRentalSystem obj=new CarRentalSystem();
        obj.addNewCar("car-1", true, new Car("model-1","2023","red","1000000"));
        obj.addNewCar("car-2", false,new Car("model-2","2022","black","5000000"));
        obj.addNewCar("car-3", true,new Car("model-3","2021","green","4000000"));
        obj.addNewCar("car-4", false,new Car("model-4","2020","yellow","2000000"));
        obj.addNewCar("car-5", true,new Car("model-5","2019","orange","3000000"));
        obj.addNewCar("car-6", false,new Car("model-6","2018","white","6000000"));

        obj.displayAvailableCars();

        obj.displayCarDetails();

        obj.updateCarDetails("car-1", new Car("model-100","2000","red","555555"));
        
        obj.displayCarDetails();

        CustomerManagement customerManagement=new CustomerManagement(obj);

        customerManagement.addCustomer("riddhi-1", "9876543210", "001", "car-1", new RentalHistory("2 days", obj.carDetails.get("car-1"), "01-01-2023","05-05-2023"));
        customerManagement.addCustomer("riddhi-2", "9876543210", "002", "car-3", new RentalHistory("2 days", obj.carDetails.get("car-3"), "01-01-2023","06-06-2023"));
        //customerManagement.addCustomer("riddhi-2", "9876543210", "002", "car-2");  


        customerManagement.displayCustomers();

        customerManagement.deleteCustomer("002");

        customerManagement.displayCustomers();
    }
}
