# Task1
Observer - UndoableStringBuilder

In this assignment I extended the functionality of UndoableStringBuilder.
I added an option to organize a group of recipients of updates on the status UndoableStringBuilder and send all updates to it in real time.
In addition, I added tracking of the size of the Heap object.

In the first step, I created the system for sending updates.
First, I learned the principles of "Observer" design patterns, and implemented it as follows:
1. Observerable - to implement the Observerable that describes the sender of the updates (Sender), I created the GroupAdmin class that implements the Sender interface.
The GroupAdmin class contains the state pool UdoableStringBuilder and a pool of ArrayList<Member> observers that receive updates on any changes made to the pool.
2. Observer - To implement the Observer that describes the recipient of the updates (Member) I implemented the ConcreteMember class that implements the Member interface.
The class contains a copy (copy sallow) of the UndoableStringBuilder repository.

In the second step I created a trace of the size of the Heap object.
To do this, I instantiated the JvmUtilities class and used a dependency management file (xml.pom) that imports the Java Layout Object library (JOL .
In the JvmUtilities class there are three static methods:
1. The objectFootprint method - shows all the references
that the object contains the size of each reference (including overhead)
2. The objectTotalSize method - displays the total size of
the object.
3. The jvmInfo method – displays the process ID of the JVM
and the total amount of memory for the benefit of the program.

Finally, to ensure correctness for all the methods I built, I created for each class its own test class (Junit).
