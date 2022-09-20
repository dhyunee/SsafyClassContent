package board.dto;

import java.sql.Date;

public class BoardDto {
	private int BoardId,UserSeq,ReadCount;
	private String Title,Content;
	private Date RegDt;
	
	
	public int getBoardId() {
		return BoardId;
	}
	public void setBoardId(int boardId) {
		BoardId = boardId;
	}
	public int getUserSeq() {
		return UserSeq;
	}
	public void setUserSeq(int userSeq) {
		UserSeq = userSeq;
	}
	public int getReadCount() {
		return ReadCount;
	}
	public void setReadCount(int readCount) {
		ReadCount = readCount;
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
	public Date getRegDt() {
		return RegDt;
	}
	public void setRegDt(Date regDt) {
		RegDt = regDt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
	@Override
	public String toString() {
		return "BoardDto [BoardId=" + BoardId + ", UserSeq=" + UserSeq + ", ReadCount=" + ReadCount + ", Title=" + Title
				+ ", Content=" + Content + ", RegDt=" + RegDt + "]";
	}
	
	
}
