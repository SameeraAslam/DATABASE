        package arrayqueue;

        import java.sql.Connection;
        import java.sql.Date;

        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Scanner;

        public class ArrayQueue {
            static final String DB_URL =
              "jdbc:mysql://localhost:3308/dbtest";
           static final String DB_DRV =
              "com.mysql.jdbc.Driver";
           static final String DB_USER = "root";
           static final String DB_PASSWD = "";
            private Object[] a;
            private int size;
                ArrayQueue(int capacity){
                a=new Object[capacity];
        }   
            public void add(Object obj){
                a[size++]=obj;
        }
            public Object remove(){
                size--; 
                Object obj=a[0];
                System.arraycopy(a,1,a,0,size);
                return obj;
        }
            public Object first(){
                return a[0];
        }

            public int size(){
                return size;
        }
            public Object peek(){
                 if(size==0)
                         return null;
                 else
                         return a[0];
        }

                public String tOString(){
                     String s="";
                 for(int i=0; i<size;i++){
                     s+=a[i]+" ";
            }
                     return s;
            }
             private void resize(){
                 Object[] aa=a;
                 a=new Object[2*aa.length];

                 System.arraycopy(aa, 0, a, 0, size);
             }



            public static void main(String[] args) {

                 Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;



            char ch;
                do{


                    System.out.println("\nWELCOME TO RENTA CAR MANAGEMENT");
                    System.out.println("1. Car");
                    System.out.println("2. Location");
                    System.out.println("3. Booking");
                    System.out.println("4. Driver");
                    System.out.println("5. Billing");


                    int choice = new Scanner(System.in).nextInt();
                    switch (choice)
                    {
                    case 1 : 
                    int indexval=-1;
                    String  valFromDatabase[] =new String[20];    
                        ArrayQueue a=new ArrayQueue(4);
                        try{
                 connection=(Connection) DriverManager.getConnection
                    (DB_URL,DB_USER,DB_PASSWD);
                 statement=(Statement) connection.createStatement();
                 resultSet=statement.executeQuery
                    ("SELECT * FROM Car");
                 System.out.println("RegNo    Model   Year   Loc_id");

                 while(resultSet.next()){

                 valFromDatabase[++indexval] = (resultSet.getString(1))+"\t";
                 valFromDatabase[++indexval]=(resultSet.getString(2))+"\t";
                 valFromDatabase[++indexval]=(resultSet.getInt(3))+"\t"; 
                 valFromDatabase[++indexval]=(resultSet.getString(4))+"\t";

                  }
                  for(int i =0;i<20;i+=4){
                 a.add(valFromDatabase[i]);
                 a.add(valFromDatabase[i+1]);
                 a.add(valFromDatabase[i+2]);
                 a.add(valFromDatabase[i+3]);
                       String s=a.tOString();
                       System.out.println(s);
                        a.remove();
                        a.remove();
                        a.remove();
                         a.remove();
                 }
                 ;
              }
                catch(SQLException ex){
                  System.out.println(ex.getMessage());
              }                     
                        break; 

                    case 2 : 
                     int indval=-1;
                    String  valueFromdataBase[] =new String[15];       
                       a=new ArrayQueue(3);
                        try{
                 connection=(Connection) DriverManager.getConnection
                    (DB_URL,DB_USER,DB_PASSWD);
                 statement=(Statement) connection.createStatement();
                 resultSet=statement.executeQuery
                    ("SELECT * FROM Location");
                 System.out.println("LocId    LocName   LocCity");
                 while(resultSet.next()){
                 valueFromdataBase[++indval] = (resultSet.getString(1))+"\t";
                 valueFromdataBase[++indval]=(resultSet.getString(2))+"  ";
                 valueFromdataBase[++indval]=(resultSet.getString(3));

                 }
                 for(int i =0;i<15;i+=3){
                a.add(valueFromdataBase[i]);
                a.add(valueFromdataBase[i+1]);
                a.add(valueFromdataBase[i+2]);
                       String s=a.tOString();
                       System.out.println(s);
                        a.remove();
                        a.remove();
                        a.remove();
                 }
              }
                  catch(SQLException ex){
                  System.out.println(ex.getMessage());
              }
                        break;
                    case 3 : 
                        int indvalue=-1;
                   String  valuefromDataBase[] =new String[25];   
                         a=new ArrayQueue(5);
                        try{
                 connection=(Connection) DriverManager.getConnection
                    (DB_URL,DB_USER,DB_PASSWD);
                 statement=(Statement) connection.createStatement();
                 resultSet=statement.executeQuery
                    ("SELECT * FROM Booking");
                  System.out.println("BookId   Amount   Pickup     Dropoff     RegNo");
                 while(resultSet.next()){

                 valuefromDataBase[++indvalue] = (resultSet.getString(1))+"     ";
                 valuefromDataBase[++indvalue]=(resultSet.getInt(2))+"     ";
                 valuefromDataBase[++indvalue]=(resultSet.getString(3))+"     ";
                 valuefromDataBase[++indvalue]=(resultSet.getString(4))+"     ";
                 valuefromDataBase[++indvalue]=(resultSet.getString(5));
                 }
                 for(int i =0;i<25;i+=5){
                 a.add(valuefromDataBase[i]);
                 a.add(valuefromDataBase[i+1]);
                 a.add(valuefromDataBase[i+2]);
                 a.add(valuefromDataBase[i+3]);
                 a.add(valuefromDataBase[i+4]);
                       String s=a.tOString();
                       System.out.println(s);
                        a.remove();
                        a.remove();
                        a.remove();
                        a.remove();
                        a.remove();
                 }
              }
                  catch(SQLException ex){
                  System.out.println(ex.getMessage());
              }
                        break;  

                case 4 : 
                    int ind=-1;
               String valFromDataBase[] =new String[20];

                        a=new ArrayQueue(4);
                        try{
                 connection=(Connection) DriverManager.getConnection
                    (DB_URL,DB_USER,DB_PASSWD);
                 statement=(Statement) connection.createStatement();
                 resultSet=statement.executeQuery
                    ("SELECT * FROM Driver");
                   System.out.println("Dr_Id    LocId    Name         PhoneNo");
                 while(resultSet.next()){

                 valFromDataBase[++ind] = (resultSet.getString(1))+"\t";
                 valFromDataBase[++ind]=(resultSet.getString(2))+"\t";
                 valFromDataBase[++ind]=(resultSet.getString(3))+"\t";
                 valFromDataBase[++ind]=(resultSet.getString(4))+"\t";

                  }
                  for(int i =0;i<20;i+=4){
                 a.add(valFromDataBase[i]);
                 a.add(valFromDataBase[i+1]);
                 a.add(valFromDataBase[i+2]);
                 a.add(valFromDataBase[i+3]);
                       String s=a.tOString();
                       System.out.println(s);
                        a.remove();
                        a.remove();
                        a.remove();
                        a.remove();
                 }
              }
                  catch(SQLException ex){
                  System.out.println(ex.getMessage());
              }                     
                        break; 

                    case 5 : 
                        int index=-1;
                   String valueFromDataBase[] =new String[15];
                         a=new ArrayQueue(3);
                        try{
                 connection=(Connection) DriverManager.getConnection
                    (DB_URL,DB_USER,DB_PASSWD);
                 statement=(Statement) connection.createStatement();
                 resultSet=statement.executeQuery
                    ("SELECT * FROM Billing");
                  System.out.println("Billid  Bookid    Date");

                 while(resultSet.next()){

                 valueFromDataBase[++index] = (resultSet.getInt(1))+"\t";
                 valueFromDataBase[++index]=(resultSet.getString(2))+"\t";
                 valueFromDataBase[++index]=(resultSet.getDate(3)).toString()+"\t";

                 }
                 for(int i =0;i<15;i+=3){
                 a.add(valueFromDataBase[i]);
                 a.add(valueFromDataBase[i+1]);
                 a.add(valueFromDataBase[i+2]);
                       String s=a.tOString();
                       System.out.println(s);
                        a.remove();
                        a.remove();
                        a.remove();
                 }
              }
                  catch(SQLException ex){
                  System.out.println(ex.getMessage());
              }
                        break;

                    default : 
                        System.out.println("Wrong Entry \n ");
                        break;
                    }

                 System.out.println("\nDo you want to continue (Type y or n) \n");
                    ch = new Scanner(System.in).next().charAt(0);
                }
                while (ch == 'Y'|| ch == 'y');  

            }

                 }

