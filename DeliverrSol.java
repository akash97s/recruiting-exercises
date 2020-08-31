import java.util.*;
import java.io.*;
import java.lang.*;


class Warehouse {
String name; // warehouse name
HashMap<String, Integer> inventory;

    public Warehouse(String name, HashMap <String, Integer> inventory) {
        this.name = name;
        this.inventory = inventory;
    }
}


public class Main {

     public static List<Warehouse> computeOrder
        ( HashMap<String, Integer> order, List <Warehouse> warehouses ) {
        // System.out.println("inCompute");
        int running_total_apple = 0, running_total_orange = 0, running_total_banana = 0;
        int appleQuantity = 0, orangeQuantity = 0, bananaQuantity = 0;
        if(order.containsKey("apple"))
            appleQuantity = order.get("apple");
        if(order.containsKey("orange"))
            orangeQuantity = order.get("orange");
        if(order.containsKey("banana"))
            bananaQuantity = order.get("banana");
        List<Warehouse> results = new ArrayList<Warehouse>();
        // Set<Warehouse> results = new HashSet<Warehouse>();
         for(int i=0; i< warehouses.size(); i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            // System.out.println(i+ " : " +warehouses.get(i).name+" "+warehouses.get(i).inventory);
            // apple
            if(warehouses.get(i).inventory.get("apple") != null && running_total_apple < appleQuantity ) {
                if(warehouses.get(i).inventory.get("apple") >= appleQuantity ) {
                    running_total_apple += appleQuantity;
                }
                else {
                    running_total_apple += warehouses.get(i).inventory.get("apple");
                }
                    temp.put("apple", running_total_apple);
            }
            // orange
            if(warehouses.get(i).inventory.get("orange") != null && running_total_orange < orangeQuantity) {
                if(warehouses.get(i).inventory.get("orange") >= orangeQuantity ) {
                    running_total_orange += orangeQuantity;
                }
                else {
                    running_total_banana += warehouses.get(i).inventory.get("orange");
                }
                    temp.put("orange", running_total_orange);
            }
           // banana
           if(warehouses.get(i).inventory.get("banana") != null && running_total_banana < bananaQuantity) {
                if(warehouses.get(i).inventory.get("banana") >= bananaQuantity ) {
                    running_total_banana += bananaQuantity;
                }
               else {
                    running_total_banana += warehouses.get(i).inventory.get("banana");
                }
                    temp.put("banana", running_total_banana);
            }
             // System.out.println(temp);
             Warehouse w3 = new Warehouse(warehouses.get(i).name.toString(), temp);
             // System.out.println(w3.name+" "+w3.inventory);
             results.add(w3);
    }
         if(running_total_apple == appleQuantity && running_total_orange == orangeQuantity && running_total_banana == bananaQuantity) { // order fullfilled
             return results;
         }
         else { // order cannot be made (inventory not enough)
             results.clear();
             System.out.println("Results: " +results);
             return results;
         }
}

    public static void main(String[] args) {

        // TestCase1: Order with multiple warehouses
        // Input:
            // order: { apple: 5, banana: 5, orange: 5 }
            // warehouse: [{ name: owd, inventory: { apple: 5, orange: 10 } }, { name: dm:, inventory: { banana: 5,                    orange: 10 }}]
        // Output: [ { name: owd, inventory: { apple: 5, orange: 5 }, { name: dm, inventory: {banana: 5} } ]

        HashMap<String, Integer> order = new HashMap<String, Integer>();
        order.put("apple", 5);
        order.put("banana", 5);
        order.put("orange", 5);
        // warehouse1
        HashMap<String, Integer> inv1 = new HashMap<String, Integer>();
        inv1.put("apple", 5);
        inv1.put("orange", 10);
        // warehouse2
        HashMap<String, Integer> inv2 = new HashMap<String, Integer>();
        inv2.put("orange", 10);
        inv2.put("banana", 5);
        Warehouse w1 = new Warehouse("owd", inv1);
        Warehouse w2 = new Warehouse("dm",inv2);
        List<Warehouse> warehouses = new ArrayList<Warehouse>(); // list for warehouse inputs
        warehouses.add(w1);
        warehouses.add(w2);

        // TestCase1 ends

        // TestCase2: Order using single warehouse
        // Input:
            // order: { apple: 1 }
            // warehouse:[{ name: owd, inventory: { apple: 1 } }]
        // Output: [{ owd: { apple: 1 } }]

        // HashMap<String, Integer> order = new HashMap<String, Integer>();
        // order.put("apple", 1);
        // HashMap<String, Integer> inv1 = new HashMap<String, Integer>();
        // inv1.put("apple", 1);
        // Warehouse w1 = new Warehouse("owd", inv1);
        // List<Warehouse> warehouses = new ArrayList<Warehouse>(); // list for warehouse inputs
        // warehouses.add(w1);

        // TestCase 2 ends

        // TestCase 3: Inventory not enough
        // Input:
            // Order: { apple: 1 },
            // Warehouses: [{ name: owd, inventory: { apple: 0 } }]
        // Output: []

        // HashMap<String, Integer> order = new HashMap<String, Integer>();
        // order.put("apple", 1);
        // HashMap<String, Integer> inv1 = new HashMap<String, Integer>();
        // inv1.put("apple", 0);
        // Warehouse w1 = new Warehouse("owd", inv1);
        // List<Warehouse> warehouses = new ArrayList<Warehouse>(); // list for warehouse inputs
        // warehouses.add(w1);

        // TestCase 3 ends


        // common execution code
        List<Warehouse> result = computeOrder(order, warehouses);
        if(result != null) {
         for(Warehouse w: result) {
            System.out.println(w.name+" "+w.inventory);
         }
        }
        else {
            System.out.println("[]");
        }

    }
}
