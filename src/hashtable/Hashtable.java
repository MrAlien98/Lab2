package hashtable;

import exceptions.NoBookException;

public class Hashtable<K, V> {
	
	private LinkedList<K, V>[] nodes;
	
	@SuppressWarnings("unchecked")
	public Hashtable(int size) {
		nodes=new LinkedList[size];
	}

	public LinkedList<K, V>[] getNodes() {
		return nodes;
	}

	public void add(K key, V value) {
		int k=hashFunction(key);
		if(nodes[k]==null) {
			nodes[k]=new LinkedList<>(key, value);
		}else {
			nodes[k].add(key, value);
		}
	}
	
	public int hashFunction(K key) {
		int nKey=toAscii(key);
		nKey=(nKey%nodes.length);
		return nKey;
	}
	
	public int toAscii(K key) {
		String nKey=String.valueOf(key);
		int res=0, c=0;
		while(c<nKey.length()) {
			res+=(nKey.charAt(c)*Math.pow(128, nKey.length()-1-c));
			c++;
		}
		return res;
	}
	
	public void delete(K key, V value) throws NoBookException {
		int k=hashFunction(key);
		if(nodes[k]!=null) {
			nodes[k].delete(value);
		}
	}
	
	public HashNode<K, V> find(K key) throws NoBookException {
		int x=hashFunction(key);
		return nodes[x].find(key);
	}
	
	public void setNodes(LinkedList<K, V>[] nodes) {
		this.nodes = nodes;
	}
	
	
	
}
