package stmt.AddStdInfo;
/*
Name varchar(45) 
Reg_no varchar(20) PK 
Prog varchar(45) 
Branch varchar(45) 
Blood_grp varchar(3)
 */
public class AddStudent {
	private String Name;
	private String Reg_no;
	private String Prog;
	private String Branch;
	private String Blood_grp;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getReg_no() {
		return Reg_no;
	}
	public void setReg_no(String reg_no) {
		Reg_no = reg_no;
	}
	public String getProg() {
		return Prog;
	}
	public void setProg(String prog) {
		Prog = prog;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getBlood_grp() {
		return Blood_grp;
	}
	public void setBlood_grp(String blood_grp) {
		Blood_grp = blood_grp;
	}
	@Override
	public String toString() {
		return "AddStudent [Name=" + Name + ", Reg_no=" + Reg_no + ", Prog=" + Prog + ", Branch=" + Branch
				+ ", Blood_grp=" + Blood_grp + "]";
	}

	
	
	
	
}
