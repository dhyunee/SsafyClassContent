package oop.override.equals.hash;

import java.util.Objects;

public class item {
	int itemId;
	String itemNm;

	// equals 재정의 안 함 -> object클래스의 equals()사용-> overriding 안 하면 ==이랑 똑같이 동작
	// 객체 내용 비교 위해 equals()사용하겨면 재정의 해야한다.
	// String class는 재정의 하고 있음
	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj instanceof item) {
			item it = (item) obj;
			if (this.itemId == it.itemId && this.itemNm.equals(it.itemNm)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public int hashCode() {
//		int result=17;
//		result=31*result+ itemId;
//		result=31*result+itemNm.hashCode();
//		return result;
//	java17
		return Objects.hash(itemId, itemNm);
	}

}
