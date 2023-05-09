package com.nagarro.advacejavaboot.dto;


public class BookDto {
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + authorName + ", currentDate="
				+ currentDate + "]";
	}

	private int bookId;

	private String bookName;

	private String authorName;

	private String currentDate;

	public int getBookCode() {
		return bookId;
	}

	public void setBookCode(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDate() {
		return currentDate;
	}

	public void setDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}