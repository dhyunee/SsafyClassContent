package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import Dto.DongCodeDto;
import Dto.GugunCodeDto;
import Dto.MainDto;
import Dto.SidoCodeDto;

public class MainDaoImpl implements MainDao {
	private static MainDaoImpl instance = new MainDaoImpl();

	private MainDaoImpl() {
	}

	public static MainDaoImpl getInstance() {
		return instance;
	}



	@Override
	public List<GugunCodeDto> getGugun(String sidocode) {
		List<GugunCodeDto> gugunlist = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DBManager.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" Select code,name,sido_code from gugun_code\n").append(" where sido_code= ? \n");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, sidocode);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				GugunCodeDto gugunCodeDto = new GugunCodeDto();
				System.out.println(rs.getString("name"));
				gugunCodeDto.setCode(rs.getString("code"));
				gugunCodeDto.setName(rs.getString("name"));
				gugunCodeDto.setSidoCode(sidocode);
				gugunlist.add(gugunCodeDto);
				System.out.println(gugunCodeDto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, conn);
		}
		return gugunlist;
	}

	@Override
	public List<DongCodeDto> getDong(String guguncode) {
		List<DongCodeDto> donglist = new ArrayList<DongCodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			conn = DBManager.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" Select code,name,city_code,city_name,gugun_code,gugun_name from dong_code\n")
					.append(" where gugun_code= ? \n");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, guguncode);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				DongCodeDto dongCodeDto = new DongCodeDto();
				dongCodeDto.setCode(rs.getString("code"));
				dongCodeDto.setName(rs.getString("name"));
				dongCodeDto.setCityCode(rs.getString("city_code"));
				dongCodeDto.setCityName(rs.getString("city_name"));
				dongCodeDto.setGuguncode(guguncode);
				dongCodeDto.setGugunName(rs.getString("gugun_name"));
				donglist.add(dongCodeDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, conn);
		}
		return donglist;
	}

	@Override
	public List<MainDto> mainList(String dongname, String guguncode) {
		List<MainDto> mainlist = new ArrayList<MainDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select d.dong,d.aptname,d.code,d.dealamount, d.buildyear,i.lat,i.lng,i.img")
					.append("  from housedeal d join houseinfo i \n")
					.append(" on d.dong=i.dong and d.aptname=i.aptname and d.jibun=i.jibun \n")
					.append("where d.dong=? and d.code=?");
			pstmt.setString(1, dongname);
			pstmt.setString(2, guguncode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MainDto mainDto = new MainDto();
				mainDto.setDong(dongname);
				mainDto.setAptname(rs.getString("aptname"));
				mainDto.setCode(guguncode);
				mainDto.setdealAmount(rs.getString("buildyear"));
				mainDto.setLat(rs.getString("lat"));
				mainDto.setLng(rs.getString("lng"));
				mainDto.setImg(rs.getString("img"));
				mainlist.add(mainDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, conn);
		}

		return mainlist;
	}

}
