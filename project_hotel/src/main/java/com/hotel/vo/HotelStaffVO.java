package com.hotel.vo;

public class HotelStaffVO {

	//변수
	int rno, accountlevel, age;


	String sid, pass, sname, ename, teamname, position, birthyy, birthmm, birthdd, gender, 
			email, pnum1, pnum2, pnum3, zonecode, addr1, addr2, joinday;
	
	//커스텀
	String birth, pnumber, addr;
	
	

	//getter,setter
	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public int getAccountlevel() {
		return accountlevel;
	}

	public void setAccountlevel(int accountlevel) {
		this.accountlevel = accountlevel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBirthyy() {
		return birthyy;
	}

	public void setBirthyy(String birthyy) {
		this.birthyy = birthyy;
	}

	public String getBirthmm() {
		return birthmm;
	}

	public void setBirthmm(String birthmm) {
		this.birthmm = birthmm;
	}

	public String getBirthdd() {
		return birthdd;
	}

	public void setBirthdd(String birthdd) {
		this.birthdd = birthdd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPnum1() {
		return pnum1;
	}

	public void setPnum1(String pnum1) {
		this.pnum1 = pnum1;
	}

	public String getPnum2() {
		return pnum2;
	}

	public void setPnum2(String pnum2) {
		this.pnum2 = pnum2;
	}

	public String getPnum3() {
		return pnum3;
	}

	public void setPnum3(String pnum3) {
		this.pnum3 = pnum3;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	public String getAddr1() {
		//System.out.println(addr1 + "여기");
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getJoinday() {
		return joinday;
	}

	public void setJoinday(String joinday) {
		this.joinday = joinday;
	}

	public String getBirth() {
		if(birth == null) {
			return birthyy+"-"+birthmm+"-"+birthdd;
		}else {
			return birth; 
		}
	}

	public void setBirth(String birth) {
		String[] results = birth.split("-");
		
		birthyy = results[0];
		birthmm = results[1];
		birthdd = results[2];
		
		//this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPnumber() {
		if(pnumber == null) {
			return pnum1+"-"+pnum2+"-"+pnum3;
		}else {
			return pnumber; 
		}
	}

	public void setPnumber(String pnumber) {
		if(pnum1 == null) {
			String[] results = pnumber.split("-");
			
			pnum1 = results[0];
			pnum2 = results[1];
			pnum3 = results[2];
		}else if(pnum1 != null) {
			
		}
		
		//this.pnumber = pnumber;
		
	}

	
	public String getAddr() {
		if(addr == null) {
			return addr1+","+addr2;
		}else {		
			return addr; 
		}
	}
	
	public void setAddr(String addr) {
		//String str = addr.replace(" ", "n");

		String[] results = addr.split(",");
		
		addr1 = results[0];
		addr2 = results[1];
		//System.out.println(addr1);
		setAddr1(addr1);
		setAddr2(addr2);
		
		this.addr = addr;
	}
	

	
}
