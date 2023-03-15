// 
//  Name:      Jin, David 
//  Project:   5
//  Due:       12/9/2022
//  Course:    cs-2400-02-f22 
// 
//  Description: 
//              Main class that creates a graph and inputs files of airport information and creates a user menu for Help, Query, Distance, I add, Remove, and Exit
//
import java.util.Scanner;
import java.io.*;
public class AirportApp {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Airports v0.1 by D. Jin");
        ////////////////////////////////////Get And Organize File Data/////////////////////////////////////////
        Scanner user = new Scanner(System.in);
        Scanner airports = new Scanner(new File("airports.csv"));
        Scanner distances = new Scanner(new File("distances.csv"));
        String[] userInput;
        
        GraphInterface<String> graph = new DiGraph<>();
        DictionaryInterface<String, String> search = new MapDictionary<>();
        
        while(airports.hasNext())
        {
            StringBuilder where = new StringBuilder();
            String ports = airports.nextLine();
            String[] info = ports.split(",");
            where.append(info[1]);
            where.append(", ");
            where.append(info[2]);
            search.add(info[0], where.toString());
            graph.addVertex(info[0]);
        }
        
        while(distances.hasNext())
        {
            String[] edge = distances.nextLine().split(",");
            Double weight = Double.valueOf(edge[2]);
            graph.addEdge(edge[0], edge[1], weight);
        }
        //////////////////////////////Options//////////////////////////////////////////
        StackInterface<String> path = new LinkedStack<>();
        
        boolean exit = false;
        while(!exit)
        {
            System.out.println();
            System.out.print("Command? ");
            String input = user.nextLine().toUpperCase();
            userInput = input.split(" ");
            switch(userInput[0].toUpperCase())
            {
                case "H":
                    //////////////////////Help Menu///////////////////////////////////////////////////////////////
                    System.out.println("Q Query the airport information by entering the airport code.");
                    System.out.println("D Find the minimum distance between two airports.");
                    System.out.println("A Add a distance from one airport to another in the format 'Airport Airport distance'.");
                    System.out.println("R Remove a distance from one airport to another in the format 'Airport Airport'.");
                    System.out.println("E Exit.");
                    break;
                    
                case "Q":
                    //////////////////////////////Print Airport Information///////////////////////////////////////////////
                    for(int i = 1; i < userInput.length; i++)
                    {
                        if(search.contains(userInput[i]))
                        {
                            System.out.println(userInput[i] + " - " + search.getValue(userInput[i]));
                        } else {
                            System.out.println(userInput[i] + " - unknown");
                        }
                    }
                    
                    break;
                    
                case "D":
                    ///////////////////////////////////Find Cheapest Path//////////////////////////////////////////////////////////////////////
                    if(graph.getCheapestPath(userInput[1], userInput[2], path) == 0)
                    {
                       System.out.println("There is no path from " + userInput[1] + " to " + userInput[2]); 
                    } else {
                        path.clear();
                        System.out.println(search.getValue(userInput[1]) + " to " + search.getValue(userInput[2]) + " is " + graph.getCheapestPath(userInput[1], userInput[2], path) + " through the route:");
                        
                        while(!path.isEmpty())
                    {
                        String place = path.pop();
                        System.out.println(place + " - " + search.getValue(place));
                    }
                    }
                    break;
                    
                case "I":
                    ///////////////////////////Add Edge////////////////////////////////////////////////////////////////////////////////////
                    if(!search.contains(userInput[1]))
                    {
                        System.out.println("Airport code unknown " + userInput[1]);
                    } else if (!search.contains(userInput[2])) {
                        System.out.println("Airport code unknown " + userInput[2]);
                    } else if (graph.hasEdge(userInput[1], userInput[2]))
                    {
                        System.out.println("A connection from " + userInput[1] + " to " + userInput[2] + " already exists");
                    } else {
                        Double distance = Double.valueOf(userInput[3]);
                        graph.addEdge(userInput[1], userInput[2], distance);
                        System.out.println(userInput[1] + " to " + userInput[2] + " with a distance of " + distance + " added.");
                    }
                    break;
                    
                case "R":
                    ////////////////////////////////////Remove Edge///////////////////////////////////////////////////////////////////
                    if(graph.hasEdge(userInput[1], userInput[2]))
                    {
                        graph.removeEdge(userInput[1], userInput[2]);
                        System.out.println(userInput[1] + " and " + userInput[2] + " removed.");
                    } else {
                        System.out.println("Airports not connected");
                    }
                    break;
                    /////////////////////////////////////////Exit Menu////////////////////////////////////////
                case "E":
                    exit = true;
                    break;
                    //////////////////////////////////////////Default////////////////////////////////////////
                default:
                    System.out.println("Invalid Command");
                    break;
                    
            }
        }
        /**System.out.println(graph.getNumberOfEdges() + " " + graph.getNumberOfEdges());
        graph.clear();
        if(graph.isEmpty())
        {
            System.out.println(graph.getNumberOfEdges() + " " + graph.getNumberOfEdges());
        } else {
            System.out.println("Graph is not empty");
        }*/
    }
}
