package Jason_test0706;

import java.util.HashMap;

class key {
	private Integer key;
	private String value;

	public key(Integer key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj instanceof key) {
			return false;
		} else {
			return this.key.equals(key);
		}
	}
}

class key_ {
	private Integer key;
	private String value;

	public key_(Integer key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj instanceof key) {
			return false;
		} else {
			return this.key.equals(key);
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}

public class test020_hashmap {

	public static void main(String[] args) {
		HashMap<Object, String> hmap = new HashMap<Object, String>(5);
		key k1 = new key(1, "Belongs to Key.k1");
		key k2 = new key(1, "Belongs to Key.k1");
		System.out.println(k1.equals(k2)); // False
		hmap.put(k1, "value1");
		hmap.put(k2, "value2");
		System.out.println(hmap.get(k2));

		key_ k3 = new key_(1, "value3");
		key_ k4 = new key_(2, "value4");
		System.out.println(k3.equals(k4)); // True
		System.out.println(k3 == k4); // False

		hmap.put(k3, "value 3");
		hmap.put(k4, "value 4");
		System.out.println(hmap.get(k4));
	}

}
