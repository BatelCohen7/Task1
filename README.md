# **Task1 - "Group Admin and Member Management"**
This project contains classes and test classes for managing groups and their members.
  *created by : Batel Cohen & Tal Sahar*

In this project we extended the functionality of UndoableStringBuilder.
We added an option to organize a group of recipients of updates on the status UndoableStringBuilder and send all updates to it in real time.
In addition, we added tracking of the size of the Heap object.

## **Class Descriptions**
  ***GroupAdmin:*** This class represents a group administrator and implements the Sender interface. It maintains a list of Member objects that have registered to      receive updates from the group administrator. When the group administrator's state is modified, it notifies all registered observers by calling the update method on each observer and passing the current state as an argument.

  ***ConcreteMember:*** This class represents a member in the group and implements the Member interface.
It has a private field, copy, which stores a copy of the group administrator's state. When the update method is called, the ConcreteMember class creates a new UndoableStringBuilder object using the list of strings stored in the UndoableStringBuilder object passed as an argument. This allows the ConcreteMember object to maintain its own copy of the group administrator's state.

  ***JvmUtilities:*** This is a utility class that provides several methods for tracking the resources allocated by the Java Virtual Machine (JVM) in the operating system.

Finally, to ensure correctness for all the methods we built, we created for each class its own test class (Junit).

## **Test Class Descriptions**
  ***GroupAdminTest:*** This class contains test cases for the GroupAdmin class.

  ***ConcreteMemberTest:*** This class contains test cases for the ConcreteMember class.

  ***JvmUtilitiesTest:*** This class contains test cases for the JvmUtilities class.

## **Running the Tests**
To run the tests, use a test runner or testing framework of your choice. For example, you can use the junit library in a Java project by including it as a dependency in your project and running the tests using the JUnitCore class.

## **Questions**
If you have any questions about this project, please open an issue or contact me at my email address: BatelCohen96@gmail.com

