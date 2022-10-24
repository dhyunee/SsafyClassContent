package board.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class BoardDto {
	private int boardId,userSeq,readCount;
	private String userName,Title,Content;
	private String userProfileImageUrl;
	private LocalDateTime regDt;
	private boolean sameUser;//글쓴이와 보는 이가 같아야 수정 가능

	public BoardDto() {
		
	}
	
	public BoardDto(int userSeq, String title, String content) {
		super();
		this.userSeq = userSeq;
		Title = title;
		Content = content;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}


	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public boolean isSameUser() {
		return sameUser;
	}

	public void setSameUser(boolean sameUser) {
		this.sameUser = sameUser;
	}

    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }
    public void setUserProfileImageUrl(String userProfileImageUrl) {
        if( userProfileImageUrl == null || "null".equals(userProfileImageUrl) || "".equals(userProfileImageUrl)) {
            this.userProfileImageUrl = "/img/noProfile.png";
        }else {
            this.userProfileImageUrl = userProfileImageUrl;
        }
    }



	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", userSeq=" + userSeq + ", readCount=" + readCount + ", userName="
				+ userName + ", Title=" + Title + ", Content=" + Content + ", userProfileImageUrl="
				+ userProfileImageUrl + ", regDt=" + regDt + ", sameUser=" + sameUser + "]";
	}
    
	
}
