package hashtable;

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
		if(nodes[hashFunction(key)]==null) {
			nodes[hashFunction(key)]=new LinkedList<>(key, value);
		}else {
			nodes[hashFunction(key)].add(key, value);
		}
	}
	
	public int hashFunction(K key) {
		int nKey=toAscii(key);
		nKey=(nKey%nodes.length);
		System.out.println(nKey);
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
	
	public void setNodes(LinkedList<K, V>[] nodes) {
		this.nodes = nodes;
	}
	
	
	
}
