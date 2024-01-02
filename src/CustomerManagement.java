import java.util.ArrayList;

public class CustomerManagement {

    ArrayList<Customer> customers;
    CarRentalSystem carRentalSystem;


    public CustomerManagement(CarRentalSystem obj){
          this.customers=new ArrayList<>();
          this.carRentalSystem=obj;
    }

    public void addCustomer(String name, String mobileNo, String id, String carNumber, RentalHistory h){
        Customer obj=new Customer();
        obj.id=id;
        obj.name=name;
        if(available(carNumber))
        {
            obj.history=new ArrayList<>();
            obj.history.add(h);
        }
        obj.mobileNo=mobileNo;

        customers.add(obj);
    }

    public boolean available(String carNumber){
       
        return carRentalSystem.car.get(carNumber);
    }

    public void updateCustomer(String name, String mobileNo, String id,ArrayList<RentalHistory> history){
        for(Customer c:customers){
            if(c.id==id){
                c.history=history;
                c.mobileNo=mobileNo;
                c.name=name;
                break;
            }
        }
    }

     public void deleteCustomer(String id){
        for(Customer c:customers){
            if(c.id==id){
               customers.remove(c);
               break;
            }
        }
    }

    public void displayCustomers(){

        System.out.println("|--------------Displaying Customer Details-----------|");
        for(Customer c:customers){
            System.out.println("Id: "+c.id);
            System.out.println("name: "+c.name);
            System.out.println("Mobile No: "+c.mobileNo);
            System.out.println("Rental History");
            for(RentalHistory history:c.history){
                System.out.println("duration = "+history.duration+ "rental date = "+history.rentalDate +" return date = "+history.returnDate );
            }
        }
    }


}
