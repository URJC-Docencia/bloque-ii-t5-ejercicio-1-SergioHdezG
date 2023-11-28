
package material.graphs;

import java.util.*;

/**
 *
 * @author mayte
 * @param <V>
 * @param <E>
 */
public class ELGraph<V,E> implements Graph<V,E> {

    private Set<ELVertex<V>> vertexSet;
    private Set<ELEdge<V, E>> edgeSet;

    public ELGraph(){
        vertexSet = new HashSet<>();
        edgeSet = new HashSet<>();
    }
    
    @Override
    public Collection<? extends Vertex<V>> vertices() {
        return Collections.unmodifiableCollection(vertexSet);
    }

    @Override
    public Collection<? extends Edge<E>> edges() {
        return Collections.unmodifiableCollection(edgeSet);
    }

    private ELVertex<V> checkVertex(Vertex<V> vertex){
        if (vertex instanceof ELVertex<V>){
            ELVertex<V> v = (ELVertex<V>) vertex;
            if (v.getGraph().equals(this)){
                return v;
            }
        }
        throw new RuntimeException("The vertex is not in the graph");
    }

    private ELEdge<V, E> checkEdge(Edge<E> edge){
        if (edge instanceof ELEdge<V, E>){
            ELEdge<V, E> v = (ELEdge<V, E>) edge;
            if (v.getGraph().equals(this)){
                return v;
            }
        }
        throw new RuntimeException("The edge is not in the graph");
    }
    
    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) {
        ELVertex<V> vertex = checkVertex(v);
        Set<Edge<E>> edgeList = new HashSet<>();
        
        for (ELEdge<V, E> edge: this.edgeSet){
            if(vertex.equals(edge.getStarVertex()) || vertex.equals(edge.getEndVertex())){
                edgeList.add(edge);
            }
        }
        return edgeList;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        ELVertex<V> vertex = checkVertex(v);
        ELEdge<V, E> edge = checkEdge(e);
        
        if (edge.getStarVertex().equals(vertex)){
            return edge.getEndVertex();
        }
        else{
            return edge.getStarVertex();
        }
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) {
        ELEdge<V, E> e = checkEdge(edge);
        List<Vertex<V>> vList = new ArrayList();
        
        vList.add(e.getStarVertex());
        vList.add(e.getEndVertex());
        
        return vList;
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex<V> insertVertex(V value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V removeVertex(Vertex<V> vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeEdge(Edge<E> edge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class ELVertex<V> implements Vertex<V>{

    private V element;
    private final Graph graph;


    public ELVertex(V element, Graph graph){
        this.element = element;
        this.graph = graph;
    }

    public void setElement(V element){
        this.element = element;
    }
    @Override
    public V getElement() {
        return null;
    }

    public Graph getGraph() {
        return graph;
    }
}

class ELEdge<V, E> implements Edge<E>{
    private E element;
    private ELVertex<V> starVertex;
    private ELVertex<V> endVertex;

    private final Graph graph;

    public ELEdge(E e, ELVertex<V> starV, ELVertex<V> endV, Graph g){
        this.element = e;
        this.starVertex = starV;
        this.endVertex = endV;
        this.graph = g;
    }
    @Override
    public E getElement() {
        return null;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public ELVertex<V> getStarVertex() {
        return starVertex;
    }

    public void setStarVertex(ELVertex<V> starVertex) {
        this.starVertex = starVertex;
    }

    public ELVertex<V> getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(ELVertex<V> endVertex) {
        this.endVertex = endVertex;
    }

    public Graph getGraph() {
        return graph;
    }
}