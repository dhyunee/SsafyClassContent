<template>
  <div class="map_wrap">
    <!-- <div v-for="(house, idx) in houseList" :key="idx"></div> -->
    <div>{{ length }}</div>
    <div id="map">
      <ul id="category">
        <li id="BK9" data-order="0">
          <span class="category_bg bank"></span>
          은행
        </li>
        <li id="MT1" data-order="1">
          <span class="category_bg mart"></span>
          마트
        </li>
        <li id="PM9" data-order="2">
          <span class="category_bg pharmacy"></span>
          약국
        </li>
        <li id="OL7" data-order="3">
          <span class="category_bg oil"></span>
          주유소
        </li>
        <li id="CE7" data-order="4">
          <span class="category_bg cafe"></span>
          카페
        </li>
        <li id="CS2" data-order="5">
          <span class="category_bg store"></span>
          편의점
        </li>
      </ul>
    </div>
    <house-list
      class="houseListVueWrapper bg-white"
      @moveToMarker="panTo"
      @moveToMarkerClose="tttest"
      @openHouseDealListModal="ttttest"
    ></house-list>
    <house-deal-modal></house-deal-modal>
  </div>
</template>
<!--
     맵에서 할 일
     1. info 창주기
     2. 주변상권 보여주기
     3. 주변상권 토글
     4. 모든 리스트 종료 구현
 -->

<script>
import { mapState, mapActions } from "vuex";
import HouseDealModal from "@/components/house/HouseDealModal.vue";
import HouseList from "@/components/house/HouseList.vue";
import { Modal } from "bootstrap";
const houseStore = "houseStore";

export default {
  components: {
    HouseDealModal,
    HouseList,
  },
  computed: {
    ...mapState(houseStore, ["houseList", "length"]),
  },
  data() {
    return {
      map: null,
      circle: null,
      markers: [],
      placeOverlay: [],
      contentNode: [],
      mapContainer: null,
      mapOption: null,
      ps: [],
      category: "",
      categoryMarkers: [],
      sumlat: 0,
      sumlng: 0,
      houseDealModal: null,
      houseName: "",
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();

      this.$watch("houseList", function () {
        console.log(this.houseList);
        this.marker = [];
        this.removeMarker();
        this.removecategoryMarker();
        this.categoryMarkers = [];
        this.currCategory = "";

        this.sumlat = 0;
        this.sumlng = 0;

        if (!this.housList && this.length != 0 && this.houseList.length > 0) {
          //this.removeMarker();
          //console.log(this.houseList);
          this.changeMap(this.houseList);
        }
      });
      return;
    }

    const script = document.createElement("script");
    /* global kakao */
    script.onload = () => kakao.maps.load(this.initMap);

    script.src =
      "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=7d3136593c8329d6d08bf6df622638b6&libraries=services,clusterer,drawing";
    document.head.appendChild(script);

    this.$watch("houseList", function () {
      console.log(this.houseList);
      this.marker = [];
      this.removeMarker();
      this.removecategoryMarker();
      this.categoryMarkers = [];
      this.currCategory = "";

      this.sumlat = 0;
      this.sumlng = 0;

      if (!this.housList && this.length != 0 && this.houseList.length > 0) {
        //this.removeMarker();
        //console.log(this.houseList);
        this.changeMap(this.houseList);
      }
    });
  },
  // watch: {
  //     houseList() {
  //         this.marker = [];
  //         this.removecategoryMarker();
  //         this.categoryMarkers = [];
  //         this.currCategory = "";
  //         if (this.length == 0) {
  //             alert("해당 지역의 부동산 정보가 없습니다.");
  //             this.noSearchResult();

  //             return;
  //         }
  //         this.sumlat = 0;
  //         this.sumlng = 0;

  //         this.removeMarker();
  //         this.changeMap(this.houseList);
  //     },
  // },
  methods: {
    ...mapActions(houseStore, ["getHouseDealList", "getHouseInfo"]),
    openhouseDealModal() {
      this.houseDealModal.show();
      this.$emit("call-parent-price-change");
    },
    initMap() {
      (this.placeOverlay = new kakao.maps.CustomOverlay({ zIndex: 1 })),
        (this.contentNode = document.createElement("div")), // 커스텀 오버레이의 컨텐츠 엘리먼트
        (this.currCategory = "");
      this.mapContainer = document.getElementById("map");
      this.mapOption = {
        center: new kakao.maps.LatLng(35.09496719219515, 128.85334127177222),
        level: 5,
      };
      this.map = new kakao.maps.Map(this.mapContainer, this.mapOption);

      // 장소 검색 객체를 생성합니다
      this.ps = new kakao.maps.services.Places(this.map);
      kakao.maps.event.addListener(this.map, "idle", this.searchPlaces); // idle event 등록
      this.contentNode.classList.add("placeinfo_wrap");
      this.addEventHandle(this.contentNode, "mousedown", kakao.maps.event.preventMap);
      this.addEventHandle(this.contentNode, "touchstart", kakao.maps.event.preventMap);
      this.placeOverlay.setContent(this.contentNode);

      this.addCategoryClickEvent(); // 카테고리에 addEvent등록
      // init map
    },
    // 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
    addEventHandle(target, type, callback) {
      if (target.addEventListener) {
        target.addEventListener(type, callback);
      } else {
        target.attachEvent("on" + type, callback);
      }
    }, // 각 카테고리에 클릭 이벤트를 등록합니다
    addCategoryClickEvent() {
      var category = document.getElementById("category"),
        children = category.children;
      for (var i = 0; i < children.length; i++) {
        children[i].onclick = this.onClickCategory;
      }
    },
    // 카테고리를 클릭했을 때 호출되는 함수입니다
    onClickCategory(event) {
      this.map.setLevel(3);
      console.log(event);
      var id = event.currentTarget.id,
        className = event.currentTarget.className;
      console.log(event.target);
      console.log(id);
      console.log(className);
      this.placeOverlay.setMap(null);
      if (className === "on") {
        this.currCategory = "";
        this.changeCategoryClass();
        this.removecategoryMarker();
      } else {
        this.currCategory = id;
        this.changeCategoryClass(this);
        this.searchPlaces();
      }
    },
    // 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
    changeCategoryClass(el) {
      var category = document.getElementById("category"),
        children = category.children,
        i;

      for (i = 0; i < children.length; i++) {
        children[i].className = "";
      }
      if (el) {
        console.log(el);
        console.log(el.className);
        // el.className = 'on';
      }
    },
    // 카테고리 검색을 요청하는 함수입니다
    searchPlaces() {
      if (!this.currCategory) {
        return;
      }

      // 커스텀 오버레이를 숨깁니다
      this.placeOverlay.setMap(null);
      // 지도에 표시되고 있는 마커를 제거합니다
      this.removecategoryMarker();

      this.ps.categorySearch(this.currCategory, this.placesSearchCB, { useMapBounds: true });
    },
    // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
    placesSearchCB(data, status) {
      if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        this.displayPlaces(data);
      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
      } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
      }
    },
    // 지도에 마커를 표출하는 함수입니다
    displayPlaces(places) {
      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      var order = document.getElementById(this.currCategory).getAttribute("data-order");
      for (var i = 0; i < places.length; i++) {
        // 마커를 생성하고 지도에 표시합니다
        var marker = this.addcategoryMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);
        // 마커와 검색결과 항목을 클릭 했을 때
        // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
        var self = this;
        (function (marker, place) {
          kakao.maps.event.addListener(
            marker,
            "click",
            function () {
              self.displayplaceinfo(place);
            },
            false
          );
        })(marker, places[i]);
      }
    },
    // 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
    displayplaceinfo(place) {
      console.log("displayPlaceInfo");
      var content =
        '<div class="placeinfo">' +
        '   <a class="title" href="' +
        place.place_url +
        '" target="_blank" title="' +
        place.place_name +
        '">' +
        place.place_name +
        "</a>";
      if (place.road_address_name) {
        content +=
          '    <span title="' +
          place.road_address_name +
          '">' +
          place.road_address_name +
          "</span>" +
          '  <span class="jibun" title="' +
          place.address_name +
          '">(지번 : ' +
          place.address_name +
          ")</span>";
      } else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + "</span>";
      }

      content +=
        '    <span class="tel">' + place.phone + "</span>" + "</div>" + '<div class="after"></div>';
      this.contentNode.innerHTML = content;
      this.placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
      this.placeOverlay.setMap(this.map);
    },
    // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
    addcategoryMarker(position, order) {
      console.log("addcategoryMarker");
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28), // 마커 이미지의 크기
        imgOptions = {
          spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
          spriteOrigin: new kakao.maps.Point(46, order * 36), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
          offset: new kakao.maps.Point(11, 28), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });
      marker.setMap(this.map); // 지도 위에 마커를 표출합니다
      this.categoryMarkers.push(marker); // 배열에 생성된 마커를 추가합니다
      return marker;
    },

    noSearchResult() {
      if (this.map == null) return;
      this.removeMarker();

      let bounds = new kakao.maps.LatLngBounds();
      let placePosition = new kakao.maps.LatLng(35.09496719219515, 128.85334127177222);
      bounds.extend(placePosition);
      this.map.setBounds(bounds);
    },
    changeMap(houseList) {
      var lat = 0;
      var lng = 0;
      for (var i = 0; i < this.length; i++) {
        this.addMarker(houseList[i]);
        lat += houseList[i].lat;
        lng += houseList[i].lng;
      }

      this.panTo(lat / this.length, lng / this.length);
    },

    removeMarker() {
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },
    removecategoryMarker() {
      for (var i = 0; i < this.categoryMarkers.length; i++) {
        this.categoryMarkers[i].setMap(null);
      }
      this.categoryMarkers = [];
    },

    panTo(lat, lng) {
      var placePosition = new kakao.maps.LatLng(lat, lng);
      this.map.panTo(placePosition);
    },
    tttest(lat, lng) {
      this.map.setLevel(2);
      this.panTo(lat, lng);
    },
    ttttest(houseNo) {
      this.getHouseDealList(houseNo);
      this.getHouseInfo(houseNo);
      this.openhouseDealModal();
    },
    addMarker(house) {
      let position = new kakao.maps.LatLng(house.lat, house.lng);
      var marker = new kakao.maps.Marker({ position });
      marker.setMap(this.map);
      this.markers.push(marker);

      var infowindow = new kakao.maps.InfoWindow({
        content: "<div>" + house.aptName + "</div>", // 인포윈도우에 표시할 내용
      });
      this.houseName = house.name;
      let $this = this;
      $this.houseDealModal = new Modal(document.querySelector("#houseDealModal"));
      (function (marker, house, infowindow) {
        window.kakao.maps.event.addListener(marker, "click", function () {
          $this.removecategoryMarker();
          $this.panTo(house.lat, house.lng);
          $this.getHouseDealList(house.no);
          $this.getHouseInfo(house.no);
          $this.openhouseDealModal();
        });
        kakao.maps.event.addListener(marker, "mouseover", function () {
          infowindow.open($this.map, marker);
          $this.drawCircle(house.lat, house.lng);
        });

        // 마커에 mouseout 이벤트를 등록하고 마우스 아웃 시 인포윈도우를 닫습니다
        kakao.maps.event.addListener(marker, "mouseout", function () {
          infowindow.close();
          $this.removeCircle();
        });
      })(marker, house, infowindow);
    },
    drawCircle(lat, lng) {
      this.circle = new kakao.maps.Circle({
        center: new kakao.maps.LatLng(lat, lng), // 원의 중심좌표 입니다
        radius: 500, // 미터 단위의 원의 반지름입니다
        strokeWeight: 1, // 선의 두께입니다
        strokeColor: "#75B8FA", // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "line", // 선의 스타일 입니다
        fillColor: "#CFE7FF", // 채우기 색깔입니다
        fillOpacity: 0.5, // 채우기 불투명도 입니다
      });
      this.circle.setMap(this.map);
    },
    removeCircle: function () {
      this.circle.setMap(null);
    },
  },
};
</script>

<style>
#map {
  /* width: 100%;
    height: 500px; */
  position: absolute;
  top: 0;
  width: 100%;
  height: 96vh;
}

.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}
.map_wrap {
  /* position: relative; */
  width: 100%;
  /* height: 350px; */
  height: 100%;
}

.houseListVueWrapper {
  position: absolute;
  display: grid;
  top: 20vh;
  left: 15vw;
  width: 20vw;
  margin-left: -10vw;
  height: auto;
  z-index: 3;
  background-color: white;
}

#category {
  position: absolute;
  /* top: 10px; */
  /* left: 10px; */
  top: 13vh;
  left: 15vw;
  margin-left: -150px;
  border-radius: 5px;
  border: 1px solid #909090;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
  background: #fff;
  overflow: hidden;
  z-index: 2;
}
#category li {
  float: left;
  list-style: none;
  width: 50px;
  border-right: 1px solid #acacac;
  padding: 6px 0;
  text-align: center;
  cursor: pointer;
}
#category li.on {
  background: #eee;
}
#category li:hover {
  background: #ffe6e6;
  border-left: 1px solid #acacac;
  margin-left: -1px;
}
#category li:last-child {
  margin-right: 0;
  border-right: 0;
}
#category li span {
  display: block;
  margin: 0 auto 3px;
  width: 27px;
  height: 28px;
}
#category li .category_bg {
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
    no-repeat;
}
#category li .bank {
  background-position: -10px 0;
}
#category li .mart {
  background-position: -10px -36px;
}
#category li .pharmacy {
  background-position: -10px -72px;
}
#category li .oil {
  background-position: -10px -108px;
}
#category li .cafe {
  background-position: -10px -144px;
}
#category li .store {
  background-position: -10px -180px;
}
#category li.on .category_bg {
  background-position-x: -46px;
}
.placeinfo_wrap {
  position: absolute;
  bottom: 28px;
  left: -150px;
  width: 300px;
}
.placeinfo {
  position: relative;
  width: 100%;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  padding-bottom: 10px;
  background: #fff;
}
.placeinfo:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.placeinfo_wrap .after {
  content: "";
  position: relative;
  margin-left: -12px;
  left: 50%;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
.placeinfo a,
.placeinfo a:hover,
.placeinfo a:active {
  color: #fff;
  text-decoration: none;
}
.placeinfo a,
.placeinfo span {
  display: block;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
.placeinfo span {
  margin: 5px 5px 0 5px;
  cursor: default;
  font-size: 13px;
}
.placeinfo .title {
  font-weight: bold;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
  margin: -1px -1px 0 -1px;
  padding: 10px;
  color: #fff;
  background: #d95050;
  background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.placeinfo .tel {
  color: #0f7833;
}
.placeinfo .jibun {
  color: #999;
  font-size: 11px;
  margin-top: 0;
}
</style>
