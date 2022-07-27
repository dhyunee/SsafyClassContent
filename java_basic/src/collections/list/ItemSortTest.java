package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ItemSortTest {

	public static void main(String[] args) {
		{
//			
//		
			List<Item> al = new ArrayList<>();

			al.add(new Item(1, "item1"));
			al.add(new Item(3, "item3"));
			al.add(new Item(2, "item2"));
			al.add(new Item(2, "item9"));
			System.out.println(al);

			Collections.sort(al);// sorting 하려는 al의 item이 Comparableimplement를 안 하면 오류 발생
			System.out.println(al);
		}
	}

//
	static class Item implements Comparable<Item> {
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

		@Override
		public int compareTo(Item o) {
			// ItemId 만으로 정력 해보자
			// natural ordering ->작은 거에서 큰 걸로
			// return this.itemId - o.itemId;// 반대로 하고 싶으면 o.itemId-this.itemId
			return this.itemId == o.itemId ? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;

		}
	}

}
