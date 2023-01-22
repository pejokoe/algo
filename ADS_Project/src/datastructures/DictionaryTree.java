package datastructures;

public class DictionaryTree {
	private class DictionaryPair implements Comparable {
		private Comparable key;
		private Comparable value;

		public DictionaryPair(Comparable key, Comparable value) {
			this.key = key;
			this.value = value;
		}

		public Comparable getKey() {
			return this.key;
		}

		public void setKey(Comparable key) {
			this.key = key;
		}

		public Comparable getValue() {
			return this.value;
		}

		public void setValue(Comparable value) {
			this.value = value;
		}

		public int compareTo(Object o) {
			return key.compareTo(((DictionaryPair)o).getKey());
		}
		public String toString() {
			return "Key: " + this.key.toString() + "\nValue: " + this.value.toString();
		}
	}

	private Tree data;

	public DictionaryTree() {
		data = new Tree();
	}

	public void add(Comparable key, Comparable value) {
		DictionaryPair toAdd = new DictionaryPair(key, value);
		data.insert(toAdd);
	}

	public Comparable findKey(Comparable key) {
		DictionaryPair dummy = new DictionaryPair(key, "dummy");
		return ((DictionaryPair)data.find(dummy)).getValue();
	}

//	public void removeKey(Comparable key) {
//		data.removeAt(findPosition(key));
//	}
//
//	public int size() {
//		return data.size();
//	}
	
	public String toString() {
		return data.toString();
	}
}