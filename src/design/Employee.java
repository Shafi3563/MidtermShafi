package design;

public interface Employee {

	//Method declared in interface (supplied)
	public int employeeId();
	public String employeeName();
	public void assignDepartment();
	public int calculateYearlySalary();
	public void benefitLayout();

	//default and static method can be implemented in Interface(created)
	public default void startUpBonus(){
		System.out.println("Every employee got 5000$ at start up bonus");
	}

	public static void housing(){
		System.out.println("\nDoctors and postdoc got housing near the hospital in a 50% discounted rate");

	}

}
