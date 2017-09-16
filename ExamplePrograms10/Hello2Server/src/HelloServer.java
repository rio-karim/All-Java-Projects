// Server serves methods to remote clients
//
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject
                                       implements Hello 
{
   // constructor
   public HelloServer() throws RemoteException 
   {
      message = "Hello, world!";
   }
   // method which returns a message
   public String displayMessage() throws RemoteException 
   {
      return message;
   }
   // main method
   public static void main( String[ ] args ) 
   {
      // create a security manager
      System.setSecurityManager( new SecurityManager() );
      try 
      {
          // Creating an RMI registry and listening at 1099 (default port)
          Registry reg = LocateRegistry.createRegistry(1099);   
          // The following assumes an RMI registry is already running
          // Registry reg = LocateRegistry.getRegistry();
          reg.rebind( "hello", new HelloServer() );
      } 
      catch( RemoteException e ) 
      { 
         System.err.println( e ); 
      }
   }
   // instance variable
   private String message;
}
