// 

import java.util.*;
import java.io.*;

class Empoloyee implements Serializable    
{
    public int EmpID;       
    public String EmpName;
    public int EmpAge;
    public String EmpAddress;
    public int EmpSalary;
    
    private static int Counter;     

    static
    {
        Counter = 1;
    }

    public Empoloyee(String b,int c,String d,int e)
    {
        this.EmpID = Counter++;
        this.EmpName = b;
        this.EmpAge = c;
        this.EmpAddress = d;
        this.EmpSalary = e;
    }   

    public void DisplayInformation()
    {
        System.out.println("ID : "+this.EmpID+" Name : "+this.EmpName+" Age : "+this.EmpAge+" Address"+EmpAddress+" Salary : "+EmpSalary);
        System.out.println();
    }

    public String toString()
    {
        return "ID : "+this.EmpID+" Name : "+this.EmpName+" Age : "+this.EmpAge+" Address : "+EmpAddress+" Salary : "+EmpSalary;
    }
}

class MyDBMS implements Serializable

{
    private LinkedList <Empoloyee> Table;

    public MyDBMS()
    {
        System.out.println("---------------- My DBMS Started Successfully ... ------------");
        Table = new LinkedList<Empoloyee>();

    }

    //insert into empoloyee values(1,'Amit',23,'Pune',23000)
    public void InsertIntoTable(
                                    String name,
                                    int age,
                                    String address,
                                    int salary
                                )
                                
    {
        Empoloyee eobj = new Empoloyee(name,age,address,salary);

        Table.add(eobj);

        System.out.println("My DBMS : > New record inserted successfully ..");
    }

    // select * from Empoloyee
    public void SelectStarFrom()
    {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Data from the Empoloyee Table is : ");
        System.out.println("-----------------------------------------------------------------------");

        for(Empoloyee eref : Table)
        {
            System.out.println(eref);
        }

        System.out.println("-----------------------------------------------------------------------");

    }

    public void TakeBackup()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("My DBMS.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured..!");
            System.out.println(" Niwant ");
        }
    }

    //
    public static MyDBMS RestoreBackup(String path)
    {
        try
        {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            MyDBMS ret = (MyDBMS) ois.readObject();
            return ret;
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured..!");
            return null;
        }
    }
    // select * from Empoloyee where Empid = 11
    public void  SelectSpecificID(int id)
    {
        boolean Found = false;

        for(Empoloyee eref : Table)
        {
            if(eref.EmpID == id)
            {
                Found = true;
                System.out.println(eref);
                break;
            }
        }
        
        if(Found == false)
        {
            System.out.println("There is no such a record");
        }
    }

    public void  SelectSpecificname(String name)
    {
        boolean Found = false;

        for(Empoloyee eref : Table)
        {
            if(name.equals(eref.EmpName))
            {
                Found = true;
                System.out.println(eref);
            }
        }
        if(Found == false)
        {
            System.out.println("There is no such a record");
        }
    }

    // delete from empolyee where EmpID = 11
    public void  DeleteSpecificID(int id)
    {
        boolean Found = false;
        int index = 0;
        
        for(Empoloyee eref : Table)
        {
            if(eref.EmpID == id)
            {
                Found = true;
                break;            
            }
            index++;

        }
        if(Found == false)
        {
            System.out.println("There is no such a record");
        }
        else
        {
            Table.remove(index);
            System.out.println("Record successfully deleted..!");
        }
    }
} // End of MyDBMS

class program847
{

    public static void main(String A[]) throws Exception
    {

        MyDBMS mobj = MyDBMS.RestoreBackup("MyDBMS.ser");

        if(mobj == null)
        {
            System.out.println("Unable to restore the backup");
            mobj = new MyDBMS();
        }

        Scanner sobj = new Scanner(System.in);

        int iOption = 0;
        int salary = 0;
        int age = 0;
        int id = 0;

        String name = "";
        String address = "";

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("------------------------------ My DBMS --------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        while(iOption != 20)
        {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("1 : insert into Empoloyee");
            System.out.println("2 : select * from Empoloyee");
            System.out.println("3 : Take a backup of table");
            System.out.println("4 : select * from Empoloyee where EmpID = ___ ");
            System.out.println("5 : select * from Empoloyee where EmpName = ___");
            System.out.println("6 : delete from empoloyee where EmpId = ___");

            System.out.println("20 : Terminate the DBMS");
            System.out.println("-----------------------------------------------------------------------");

            System.out.println("Please select the desired operation on the database : ");

            iOption = sobj.nextInt();

            if(iOption == 1)
            {
                System.out.println("Please enter the data that you want to insert : ");

                sobj.nextLine();

                System.out.println("Enter tha name of Empoloyee : ");
                name = sobj.nextLine();

                System.out.println("Enter tha age of Empoloyee : ");
                age = sobj.nextInt();
                
                sobj.nextLine();

                System.out.println("Enter tha address of Empoloyee : ");
                address = sobj.nextLine();

                System.out.println("Enter tha salary of Empoloyee : ");
                salary = sobj.nextInt();

                mobj.InsertIntoTable(name,age,address,salary);
            }
            else if(iOption == 2)
            {
                mobj.SelectStarFrom();
            }
            else if(iOption == 3)
            {
                mobj.TakeBackup();
                System.out.println("Database gets successfully stored into secondary storage");
            }
            else if(iOption == 4)
            {
                System.out.println("Enter the Empoloyee ID : ");
                id = sobj.nextInt();

                mobj.SelectSpecificID(id);
            }
            else if(iOption == 5)
            {
                sobj.nextLine();

                System.out.println("Enter the Empoloyee Name : ");
                name = sobj.nextLine();

                mobj.SelectSpecificname(name);
            }
            else if(iOption == 6)
            {
                System.out.println("Enter the Empoloyee ID : ");
                id = sobj.nextInt();

                mobj.DeleteSpecificID(id);
            }
            else if(iOption == 20)
            {
                System.out.println("Thank you for using My DBMS");
                System.out.println("________________________________________________________________________");
                mobj = null;
                System.gc();
                break;
            }
        } // End of while

    } // End of main method
} // End of main class