package algo;

public class Dictionary {
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
			return this.value.compareTo(o);
		}
	}

	private Vector data;

	public Dictionary() {
		data = new Vector(10);
	}

	public void add(Comparable key, Comparable value) {
		int position = findPosition(key);
		if (position > -1) {
			DictionaryPair toAdd = new DictionaryPair(key, value);
			data.addLast(toAdd);
		} else {
			((DictionaryPair)data.get(position)).value = value;
		}
	}

	public int findPosition(Comparable key) {
		for (int i = 0; i < data.size(); i++) {
			if (key == ((DictionaryPair)data.get(i)).key) {
				return i;
			}
		}
		return -1;
	}

	public Comparable find(Comparable key) {
		int position = findPosition(key);
		if (position > -1) {
			return ((DictionaryPair) data.get(position)).value;
		} else {
			return null;
		}
	}

	public void removeKey(Comparable key) {
		data.removeAt(findPosition(key));
	}

	public int size() {
		return data.size();
	}
}