package com.springlec.address.dao;

import java.util.ArrayList;

import com.springlec.address.dto.InfoDto;

public interface IDao {
	public ArrayList<InfoDto> listDao();
	
	public InfoDto contentDao(String seqno);
	
	public void writeDao(String name, String telno, String address, String email, String relation);
	
	public void editDao(String name, String telno, String address, String email, String relation, String seqno);
	
	public void deleteDao(String seqno);
	
	public ArrayList<InfoDto> listQuery(String query,String content);
}
