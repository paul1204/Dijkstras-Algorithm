import java.util.*;

public class a3 {

	private static Scanner sc = new Scanner(System.in);
	private static int max = Integer.MAX_VALUE;
	
	private static final int numCity = sc.nextInt();
	private static  int count = numCity;
	private static int highwayNum = sc.nextInt();
	
	private static HashMap<Integer,Integer> hotel = new HashMap<Integer, Integer>();
	private static int city[] = new int[numCity];
	private static boolean[] visited = new boolean[numCity];
	private static int[][] gps = new int[numCity][numCity];
	
	public static void relax(int to, int from, int gps[][], boolean visited[], int city[]){
		int a = (to);
		int b = (from);
		int edgeDis = -1;
		int newDis = -1;
	
		
		if((!visited[to])&& (gps[from][to] != 0)) {
			if(city[to] > city[from] + gps[from][to]) {
				city[to] = city[from] + gps[from][to] + hotel.get(to+1);
			}
		}

		
		
	}
	
	public static int extractMinIndex(int city[], boolean visited[]) {
		  
		int min_dis = max;
		int min_dis_i = 0;
		int i;
		
		for(i = 0; i < numCity; i++) {
			if((visited[i] == false) && (city[i] <= min_dis)) {
					 min_dis = city[i];
					 min_dis_i = i;
			}
		}
		 visited[min_dis_i] = true;
		count--;
		return min_dis_i;
	}
	
	static void dijkstra(int gps[][]) {
		int c;
		int start = 0;
		int from;
		int to;
	
		for(c = 0; c < numCity; c++) {
			city[c] = max;

			visited[c] = false;
			//set boolean to f... I think it is all false initially
		}		
		city[0] = 0;

		
		
		for(from = 0; from <(numCity); from++) {
		while(count >= 0) {
			from = extractMinIndex(city,visited);
			for(to = 0; to <numCity; to++) {
				relax(to,from,gps,visited,city);
			}
		  }	
		}
	   
		System.out.println(city[1]);
	}
	
	
	public static void main(String[] args) {
	int i;
	//This is the Price of Hotel, in a HashMap 
	//This is so we can add the Price of Hotel when we are relaxing since default is Infinity 
	hotel.put(1,0);

	for(i = 0; i< (numCity-2); i++) {
		int cityName = sc.nextInt();
		int hotePric = sc.nextInt();

	   hotel.put(cityName, hotePric);
	}
	hotel.put(2,0);

	while(sc.hasNextInt()) {
		//A is From
		int A = (sc.nextInt() -1);
		//B is To
		int B = (sc.nextInt() -1);
		//Price of case one way
		int gasCost = sc.nextInt();	
		gps[A][B] = gasCost;
		gps[B][A] = gasCost;
	}
	for(i = 0; i <gps.length; i++) {
		for(int y= 0; y<gps.length; y++) {
		}
	}
	dijkstra(gps);
	}
}