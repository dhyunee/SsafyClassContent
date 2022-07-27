package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ItemSortTest {

	public static void main(String[] args) {
		{
//			
//		//1 Item class 에 comparable interface 구현
//			List<Item> al = new ArrayList<>();
//
//			al.add(new Item(1, "item1"));
//			al.add(new Item(3, "item3"));
//			al.add(new Item(2, "item2"));
//			al.add(new Item(2, "item9"));
//			System.out.println(al);
//
//			Collections.sort(al);// sorting 하려는 al의 item이 Comparableimplement를 안 하면 오류 발생
//			System.out.println(al);

		}

		// 2
		{
			List<Item> al = new ArrayList<>();
			al.add(new Item(1, "item1"));
			al.add(new Item(3, "item3"));
			al.add(new Item(2, "item2"));
			al.add(new Item(2, "item9"));

			System.out.println(al);
//			Collections.sort(al.new Comparator<Item>){//2 anonymous 클래스 객체 생성 전달
//			System.out.println();
//			
//			@Override
//			public int compare(Item o1, Item o2) {
//				// TODO Auto-generated method stub
//				return o1.itemId == o2.itemId ?  o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId;
//				}
//			}
			// 3 lambda
			Collections.sort(al,
					(o1, o2) -> o1.itemId == o2.itemId ? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId);
			System.out.println(al);
		}
	}

	// comparator 인터페이스 구현
//	static class ComparatorImpl implements Comparator<Item>{
//
//		@Override
//		public int compare(Item o1, Item o2) {
//			// TODO Auto-generated method stub
//			return o1.itemId == o2.itemId ?  o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId;
//		}
//		
//	}
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

//		@Override
//		public int compareTo(Item o) {
//			// ItemId 만으로 정력 해보자
//			// natural ordering ->작은 거에서 큰 걸로
//			// return this.itemId - o.itemId;// 반대로 하고 싶으면 o.itemId-this.itemId
//			return this.itemId == o.itemId ? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;
//
//		}
	}

}
