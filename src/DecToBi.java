/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nisal Waduge
 */
class Node {

    int data;
    Node next;

    public Node(int i) { //A constructor to initialize members data and next 
        this.data = i;
        this.next = null;

    }

    public void display() {
        System.out.print(this.data);
       
    }
}

class Stack {

    private Node top; //holds a reference to the top node

    public Stack() { //A constructor to initialize top
        this.top = null;
    }

    public boolean isEmpty() { // A method to check the stack is empty or not 

        return (this.top == null);
    }

    public void push(int i) { // A method to push an ‘int’ i onto the stack 
        Node newNode = new Node(i);
        newNode.next = this.top;   //think as a stack, current top is going to be the next item(top to bottom)
        this.top = newNode;

    }

    public Node pop() { //A method to remove the top node and returns the reference of the removed node 

        if (!isEmpty()) {
            Node remved = this.top;
            this.top = remved.next;
            return remved;
        } else {
            return null;
        }
    }

    public Node peek() { //A method to peek the top node 
        return this.top;
    }
}

public class DecToBi {

    private int decimal;
    
    private Stack stk;

    public DecToBi(int decimal) {
        this.decimal = decimal;
    }
    
    public void convert(){
        int rem;
        stk = new Stack();
        System.out.println("Decimal >>"+this.decimal);
        while(this.decimal>0){
            rem = decimal%2;
            this.decimal = this.decimal/2;
            insertToStack(rem);
        }
        display();
    }
    private void insertToStack(int rem){
        this.stk.push(rem);
    }
    private void display(){
        System.out.print("Binary  >>");
        while(!(this.stk.isEmpty())){
            Node catcher = stk.pop();
            catcher.display();
        
    }
        System.out.println("\n----------END----------");
        }

    public static void main(String[] args) {
        
        DecToBi con1 = new DecToBi(10);   // create new conversion with decimal 10
        con1.convert();                   // convert 10 to binary
        DecToBi con2 = new DecToBi(24);
        con2.convert();
        
        

    }
}
