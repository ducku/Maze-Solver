import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Maze{
    private Square maze[][];
    private int width;
    private int height;
    private String heuristic;
    private MyPoint start;
    private MyPoint end;

    public Maze(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter width and height");
        
        //Store width and height values
        String line1 = scan.nextLine();
        String[] parts = line1.split(" ");
        width = Integer.parseInt(parts[0]);
        height = Integer.parseInt(parts[1]);

        maze = new Square[height][width]; 
        

        System.out.println("Enter heuristic");
        heuristic = scan.nextLine();
        
        System.out.println("Enter maze");
        String input = scan.next();
        
        //Fills maze with the inputed maze, locate start and end
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                maze[row][col] = Square.fromChar(input.charAt(row * width + col));
                if(maze[row][col] == Square.fromChar('o')) {
                		start = new MyPoint(col, row);
                }
                if(maze[row][col] == Square.fromChar('*')) {
                		end = new MyPoint(col, row);
                }
                
            }
        }

        scan.close();
        
    }
    
    
    public boolean solveMaze() {
    		//Using Priority Queue to sort by heuristic value
    		MyQueue<MyPoint> toVisit = new MyQueue<MyPoint>();
    		ArrayList<MyPoint> visited = new ArrayList<MyPoint>();

    		toVisit.add(start);

    		while(!toVisit.isEmpty()) {
    			//If the top of the stack is visited, remove it
    			//Break the loop if the stack is empty
    			try{
    				while(visited.contains(toVisit.peek())){
        				toVisit.remove();
    				}
    			}
    			catch(NoSuchElementException ex) {
    				break;
    			}
    			
    			//Using Points to store x and y coordinates
    			MyPoint currPoint = toVisit.peek();
    			switch(maze[currPoint.y][currPoint.x]) {
    				case walls:
    					toVisit.remove();
    					break;
    				case finish:
    					return true;
    				//All thats left are the start and open_space, which we do the same thing for
    				default:
    					visited.add(currPoint);
    					maze[currPoint.y][currPoint.x] = Square.fromChar('-'); //Mark visually as visited
    					toVisit.remove();
    					
    					//get all adjacent points
    					MyPoint[] adj = currPoint.getAdjPoints();
    					//calculate their heuristic value and add them to agenda (if within boundaries)
    					for(MyPoint p : adj) {
    						if(withinBoundaries(p)) {
    							p.setHeuristicValue(heuristicValue(p));
    							toVisit.add(p);
    						}
    					}
    					break;
    			}
    		}
    		
    		//Nothing's left in the agenda
    		//Checked every reachable location and could not find an end
    		return false;
    		
    }
    
    public boolean withinBoundaries(MyPoint p) {
		return p.x > 0 && p.x < width && p.y > 0 && p.y < height;
    }

    //Returns estimated distance using heuristics
    public int heuristicValue(MyPoint p) {
    		int dx = Math.abs(p.x - end.x);
    		int dy = Math.abs(p.y - end.y);
    		int manhattan = (int) Math.sqrt(dx * dx + dy * dy);
    		switch(heuristic) {
    			case "Euclidean":
    				return dx + dy;
    			case "Manhattan":
    				return manhattan;
    			case "Proximity":
    				return (manhattan > 8) ? 8 : manhattan;
    			
    		}
    		return 0;
    }
    
    
    
    //Makes maze readable
    public String toString(){
        String result = "";
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                result += maze[row][col];
            }
            result += "\n";
        }
        return result;
    }

}