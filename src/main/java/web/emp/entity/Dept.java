package web.emp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Dept {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;
//  單向查詢(一對多的一方)
//	@OneToMany
//	@JoinColumn(name = "DEPTNO",
//	referencedColumnName = "DEPTNO")
	
//  雙向查詢(一對多的一方)
	// 在對方的實體類別內，關聯自方的屬性名
	@OneToMany(mappedBy = "dept")
	private List<Emp> emps;
}
