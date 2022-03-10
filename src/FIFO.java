
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {
	ArrayList<Object> objects = new ArrayList<Object>();
	int maxSize = 0;

	public int size() {
		int size = objects.size();
		return size;
	}

	public int maxSize() {
		return maxSize;
	}

	public boolean isEmpty() {
		if (objects.size() == 0) {
			return true;
		}
			return false;
	}

	public Object first() throws NoSuchElementException {
		if (objects.size() == 0) {
			throw new NoSuchElementException("Den är tom");
		}
		return objects.get(0);
	}

	public void add(Object item) {
		objects.add(item);
		if (objects.size() > maxSize) {
			maxSize = objects.size();
		}
	}

	public void removeFirst() throws NoSuchElementException {
		if (objects.size() == 0) {
			throw new NoSuchElementException("Den är tom");
		}
		objects.remove(0);
	}

	public String toString() {
		String queue = "Queue: ";
		for (int i = 0; i < objects.size(); i++) {
			queue += "(" + String.valueOf(objects.get(i)) + ") ";
		}
		return queue;
	}

	public boolean equals(Object f) throws ClassCastException {
		if (f.getClass() != this.getClass()) {
			throw new ClassCastException("Olika klasser");
		}

		if (this.size() != ((FIFO) f).size()) {
			return false;
		}

		for (int i = 0; i < this.size(); i++) {
			if (objects.get(i) != null && ((FIFO) f).objects.get(i) == null) {
				return false;
			}
			if (objects.get(i) == null && ((FIFO) f).objects.get(i) != null) {
				return false;
			}

			if (objects.get(i) != null) {
				if (objects.get(i).getClass() == this.getClass()) {
					return objects.get(i).equals(((FIFO) f).objects.get(i));
				}
			}
		}
		return true;
	}
}