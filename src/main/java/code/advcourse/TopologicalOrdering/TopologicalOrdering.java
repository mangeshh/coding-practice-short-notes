package code.advcourse.TopologicalOrdering;

import java.util.Stack;

public class TopologicalOrdering {

	private Stack<Vertex> stack;
	
	public TopologicalOrdering(){
		this.stack = new Stack<>();
	}
	
	public void dfs(Vertex vertex){
	
		vertex.setVisited(true);
		System.out.println("starting with vertex " + vertex.getData());
		System.out.println("neighbors are "+ vertex.getNeighbourList());
		for(Vertex v : vertex.getNeighbourList()){
			if( !v.isVisited()){
				dfs(v);
			}
		}
		
		stack.push(vertex);
		System.out.println("answer..." + stack);
	}
	
	public Stack<Vertex> getStack(){
		return this.stack;
	}
}
