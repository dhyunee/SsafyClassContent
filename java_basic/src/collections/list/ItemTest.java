package collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemTest {

	public static void main(String[] args) {
		{
//			ArrayList<Item> al = new ArrayList<>();
//			al.add(new Item(1, "item1"));
//			al.add(new Item(2, "item2"));
//			al.add(new Item(3, "item3"));
//			System.out.println(al);
//
//			// for
//			for (int i = 0; i < al.size(); i++) {
//				Item item = al.get(i);
//				System.out.println(item);
//			}
//
//			// iterator
//			Iterator<Item> itr = al.iterator();
//			while (itr.hasNext()) {
//				Item item = itr.next();
//				System.out.println(item);
//			}
//
//			// for_each
//			for (Item item : al) {
//				System.out.println(item);
//			}
//
//			// 단순 순회-lambda
//			al.forEach(item -> System.out.println(item));
//		}
			List<Item> al = new ArrayList<>();

			al.add(new Item(1, "item1"));
			al.add(new Item(2, "item2"));
			al.add(new Item(3, "item3"));
			System.out.println(al);

			Item item2 = new Item(2, "item2");
//			
			// for
//			for(int i=0;i<al.size();i++) {
//				item item=al.get(i);
//				if (item.equals(item2))al.remove(i);
//			}
			// iterator
//			Iterator<Item> itr = al.iterator();
//			while (itr.hasNext()) {
//				Item item = itr.next();
//				if (item.equals(item2))
//					itr.remove();
//			}

			// lambda removeif
			al.removeIf(el -> el.equals(item2));
			System.out.println(al);
		}
	}

//
	static class Item {
		int itemId;
		String itemNm;

		public Item(int itemId, String itemNm) {
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

		public boolean equals(Object o) {
			if (o != null && o instanceof Item) {
				Item item = (Item) o;
				if (this.itemId == item.itemId && this.itemNm.equals(item.itemNm))
					return true;
				else
					return false;

			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(itemId, itemNm);
		}
	}

}
