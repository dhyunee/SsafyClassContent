<nav id="navbar-example2" class="navbar navbar-light bg-light px-3">
  <a class="navbar-brand" href="#">Navbar</a>
  <ul class="nav nav-pills">
    <li class="nav-item">
      <a class="nav-link" href="#scrollspyHeading1">First</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#scrollspyHeading2">Second</a>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Dropdown</a>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#scrollspyHeading3">Third</a></li>
        <li><a class="dropdown-item" href="#scrollspyHeading4">Fourth</a></li>
        <li><hr class="dropdown-divider"></li>
        <li><a class="dropdown-item" href="#scrollspyHeading5">Fifth</a></li>
      </ul>
    </li>
  </ul>
</nav>

<template>
  <div>
    <div
      class="container-fluid bg-primary mb-5 wow fadeIn"
      data-wow-delay="0.1s"
      style="padding: 35px"
    >
      <div class="container">
        <div class="row g-2">
          <div class="col-md-10">
            <div class="row g-2">
              <div class="col-md-4">
                <select class="form-select border-0 py-3">
                  <option selected>Property Type</option>
                  <option v-for="(item, index) in sido" :key="index">{{ item }}</option>
                  <option value="2">Property Type 2</option>
                  <option value="3">Property Type 3</option>
                </select>
              </div>
              <div class="col-md-4">
                <select class="form-select border-0 py-3">
                  <option selected>Property Type</option>
                  <option value="1">Property Type 1</option>
                  <option value="2">Property Type 2</option>
                  <option value="3">Property Type 3</option>
                </select>
              </div>
              <div class="col-md-4">
                <select class="form-select border-0 py-3">
                  <option selected>Location</option>
                  <option value="1">Location 1</option>
                  <option value="2">Location 2</option>
                  <option value="3">Location 3</option>
                </select>
              </div>
            </div>
          </div>
          <div class="col-md-2">
            <button class="btn btn-dark border-0 w-100 py-3">Search</button>
          </div>
        </div>
      </div>
    </div>

    <div class="mt-2 row no-gutters">
      <div class="col-3 md-4">
        <div
          class="container"
          v-for="(item, index) in sel_apt"
          :key="index"
          style="margin-left: 10%"
        >
          <div class="card" style="border: 1px solid grey; height: 20vh; max-width: 95%">
            <div class="container">
              <div class="row">
                <div class="col md-4">
                  <img class="img-fluid" src="img/carousel-1.jpg" alt="" />
                </div>
                <div class="col md-8">
                  <div class="mb-2">아파트 이름</div>
                  <div class="ml-0 pl-0">
                    평수 : 평<br />
                    층수 : 층<br />
                    매매가 : 억 원
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-9 md-8">
        <div id="map" style="width: 95%; height: 700px"></div>
      </div>
    </div>
  </div>
</template>
<script>
//axios 통신 위한 axios 모듈 import
//import axios from "axios";
// axios.defaults.baseURL = 'http://localhost:8080';
// axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
// axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
//kakao map 관련 전역변수
var container;
var options;
var map;
var markers = [];
var selectedMarker = null;
var MARKER_WIDTH = 33, // 기본, 클릭 마커의 너비
  MARKER_HEIGHT = 36, // 기본, 클릭 마커의 높이
  OFFSET_X = 12, // 기본, 클릭 마커의 기준 X좌표
  OFFSET_Y = MARKER_HEIGHT, // 기본, 클릭 마커의 기준 Y좌표
  OVER_MARKER_WIDTH = 40, // 오버 마커의 너비
  OVER_MARKER_HEIGHT = 42, // 오버 마커의 높이
  OVER_OFFSET_X = 13, // 오버 마커의 기준 X좌표
  OVER_OFFSET_Y = OVER_MARKER_HEIGHT, // 오버 마커의 기준 Y좌표
  SPRITE_MARKER_URL =
    "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markers_sprites2.png", // 스프라이트 마커 이미지 URL
  SPRITE_WIDTH = 126, // 스프라이트 이미지 너비
  SPRITE_HEIGHT = 146; // 스프라이트 이미지 높이
// SPRITE_GAP = 10; // 스프라이트 이미지에서 마커간 간격
var markerSize, // 기본, 클릭 마커의 크기
  markerOffset, // 기본, 클릭 마커의 기준좌표
  overMarkerSize, // 오버 마커의 크기
  overMarkerOffset, // 오버 마커의 기준 좌표
  spriteImageSize; // 스프라이트 이미지의 크기
// axios 통신시 origin 오류 해결 위한 코드
// axios.defaults.baseURL = 'http://localhost:8080';
// axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
// axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
export default {
  data() {
    return {
      //시도, 구군, 동, 선택된 마커에 대한 데이터 바인딩
      sido: ["경기도", "서울시", "부산시"],
      sel_sido: ["도/광역시"],
      gugun: ["강남구", "서초구", "송파구", "성북구", "종로구", "강서구", "강동구", "동작구"],
      sel_gugun: ["시/구/군"],
      dong: [
        "잠원동",
        "신사동",
        "반포동",
        "성내동",
        "평창동",
        "길음동",
        "한남동",
        "이태원동",
        "압구정동",
      ],
      sel_dong: ["동"],
      sel_apt: ["아이파크", "더샵", "래미안", "자이", "아크로"],
      locations: [],
      selection: 1,
      images: {
        sample: "",
      },
      favorite: false,
    };
  },

  mounted() {
    //마운트 되면 kakaomap init
    if (window.kakao && window.kakao.maps) {
      //kakaomap 이미 존재하는 경우에는 단순히 init만
      this.initMap();
    } else {
      //그 외의 처음 경우에는 script cdn으로 가져와서 head에 추가
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => new kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=7d3136593c8329d6d08bf6df622638b6&libraries=services";
      document.head.appendChild(script);
    }
  },

  methods: {
    initMap() {
      container = document.getElementById("map");
      options = {
        center: new kakao.maps.LatLng(35.19656853772262, 129.0807270648317),
        level: 6,
      };
      map = new kakao.maps.Map(container, options);
      (markerSize = new kakao.maps.Size(MARKER_WIDTH, MARKER_HEIGHT)), // 기본, 클릭 마커의 크기
        (markerOffset = new kakao.maps.Point(OFFSET_X, OFFSET_Y)), // 기본, 클릭 마커의 기준좌표
        (overMarkerSize = new kakao.maps.Size(OVER_MARKER_WIDTH, OVER_MARKER_HEIGHT)), // 오버 마커의 크기
        (overMarkerOffset = new kakao.maps.Point(OVER_OFFSET_X, OVER_OFFSET_Y)), // 오버 마커의 기준 좌표
        (spriteImageSize = new kakao.maps.Size(SPRITE_WIDTH, SPRITE_HEIGHT)); // 스프라이트 이미지의 크기
    },

    addMarker(position, normalOrigin, overOrigin, clickOrigin) {
      // 기본 마커이미지, 오버 마커이미지, 클릭 마커이미지를 생성합니다
      let normalImage = this.createMarkerImage(markerSize, markerOffset, normalOrigin),
        overImage = this.createMarkerImage(overMarkerSize, overMarkerOffset, overOrigin),
        clickImage = this.createMarkerImage(markerSize, markerOffset, clickOrigin);
      // 마커를 생성하고 이미지는 기본 마커 이미지를 사용합니다
      let marker = new kakao.maps.Marker({
        map: map,
        position: position,
        title: "apt",
        image: normalImage,
      });
      //markers 배열에 생성된 marker 주입
      markers.push(marker);
      // 마커 객체에 마커아이디와 마커의 기본 이미지를 추가합니다
      marker.normalImage = normalImage;
      // 마커에 mouseover 이벤트를 등록합니다
      new kakao.maps.event.addListener(marker, "mouseover", () => {
        // 클릭된 마커가 없고, mouseover된 마커가 클릭된 마커가 아니면
        // 마커의 이미지를 오버 이미지로 변경합니다
        if (!selectedMarker || selectedMarker !== marker) {
          marker.setImage(overImage);
        }
      });
      // 마커에 mouseout 이벤트를 등록합니다
      new kakao.maps.event.addListener(marker, "mouseout", () => {
        // 클릭된 마커가 없고, mouseout된 마커가 클릭된 마커가 아니면
        // 마커의 이미지를 기본 이미지로 변경합니다
        if (!selectedMarker || selectedMarker !== marker) {
          marker.setImage(normalImage);
        }
      });
      // 마커에 click 이벤트를 등록합니다
      new kakao.maps.event.addListener(marker, "click", () => {
        // 클릭된 마커가 없고, click 마커가 클릭된 마커가 아니면
        // 마커의 이미지를 클릭 이미지로 변경합니다
        if (!selectedMarker || selectedMarker !== marker) {
          // 클릭된 마커 객체가 null이 아니면
          // 클릭된 마커의 이미지를 기본 이미지로 변경하고
          !!selectedMarker && selectedMarker.setImage(selectedMarker.normalImage);
          // 현재 클릭된 마커의 이미지는 클릭 이미지로 변경합니다
          marker.setImage(clickImage);
        }
      });
    },
    createMarkerImage(markerSize, offset, spriteOrigin) {
      let markerImage = new kakao.maps.MarkerImage(
        SPRITE_MARKER_URL, // 스프라이트 마커 이미지 URL
        markerSize, // 마커의 크기
        {
          offset: offset, // 마커 이미지에서의 기준 좌표
          spriteOrigin: spriteOrigin, // 스트라이프 이미지 중 사용할 영역의 좌상단 좌표
          spriteSize: spriteImageSize, // 스프라이트 이미지의 크기
        }
      );
      return markerImage;
    },

    reserve() {
      this.loading = true;
      this.seTimeout(() => (this.loading = false), 2000);
    },
  },
};
</script>
